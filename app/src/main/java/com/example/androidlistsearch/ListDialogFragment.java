package com.example.androidlistsearch;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListDialogFragment extends android.app.DialogFragment {

    static ListDialogFragment newInstance(String[] itemname, int[] imgid, Integer position) {
        ListDialogFragment listDialogFragment = new ListDialogFragment();
        Bundle args = new Bundle();

        args.putInt("position", position);
        args.putIntArray("imgid", imgid);
        args.putStringArray("itemname", itemname);

        listDialogFragment.setArguments(args);

        return listDialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Integer position = getArguments().getInt("position");
        String[] itemname = getArguments().getStringArray("itemname");
        int[] imgid = getArguments().getIntArray("imgid");

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_list, null);

//        View dialogView = inflater.inflate(R.layout.dialog_list, null, true);

        TextView txtTitle = (TextView) dialogView.findViewById(R.id.dialog_item);
        ImageView imageView = (ImageView) dialogView.findViewById(R.id.dialog_icon);
        TextView extratxt = (TextView) dialogView.findViewById(R.id.dialog_text);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText("Description: " + itemname[position]);

        return new AlertDialog.Builder(getActivity())
                .setView(dialogView)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("Item Selected")
                .setNeutralButton("OK", null).create();
    }
}

package com.example.androidlistsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    ListView list;

    String[] itemname = {
            "Sakata",
            "Kagura",
            "Shimura",
            "Okita",
            "Mitsuba",
            "Kondo",
            "Toshiro",
    };

    int[] imgid = {
            R.mipmap.pic1 ,
            R.mipmap.pic2,
            R.mipmap.pic3,
            R.mipmap.pic4,
            R.mipmap.pic5,
            R.mipmap.pic6,
            R.mipmap.pic7
    };

    ArrayList<String> textSearchData = new ArrayList<String>();
    ArrayList<Integer> imageSearchData = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputSearch = (EditText) findViewById(R.id.inputSearch);

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int index, int i1, int i2) {
                textSearchData.clear();
                imageSearchData.clear();

                for (int i = 0, j = 0; i < itemname.length; i++) {
                    if (((String)itemname[i].toLowerCase(Locale.getDefault())).contains(inputSearch.getText().toString().toLowerCase())) {
                        Log.d("ITEMNAME LOGGING", itemname[i]);
                        textSearchData.add(itemname[i]);
                        imageSearchData.add(imgid[i]);
                    }
                }

                CustomListAdapter adapter = new CustomListAdapter(MainActivity.this, textSearchData, imageSearchData);
                list = (ListView) findViewById(R.id.list);

                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String selectedItem = itemname[+i];

                        ListDialogFragment listDialogFragment = ListDialogFragment.newInstance(itemname, imgid, i);
                        listDialogFragment.show(getFragmentManager(), "dialog");
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}

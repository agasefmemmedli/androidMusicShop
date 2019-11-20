package com.example.musicshop;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int qyt = 0;
    ArrayList array ;
    ArrayAdapter adapter;
    Spinner spinner;
    HashMap map ;
    String selectname;
    Double selectPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        array = new ArrayList();
        array.add("airpods");
        array.add("earpods");
        array.add("airdost");
        map = new HashMap();
        map.put("airpods",250.0);
        map.put("earpods",25.0);
        map.put("airdost",59.0);
        adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,array);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
    }


    public void minusCount(View view) {
        TextView count = findViewById(R.id.countTextView);

        if (qyt>0)
        {
            qyt=qyt-1;
            count.setText(""+qyt);
            TextView  price = findViewById(R.id.priceCountTextView);

            price.setText(""+(qyt*selectPrice));
        }
    }
    public void plusCount(View view) {
        TextView count = findViewById(R.id.countTextView);
        qyt=qyt+1;

        count.setText(""+qyt);
        TextView  price = findViewById(R.id.priceCountTextView);

        price.setText(""+(qyt*selectPrice));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectname = spinner.getSelectedItem().toString();
        selectPrice =(double)map.get(selectname);

        TextView  price = findViewById(R.id.priceCountTextView);

        price.setText(""+(qyt*selectPrice));

        ImageView image = findViewById(R.id.goodsImage);
        switch (selectname)
        {
            case "airpods":
                image.setImageResource(R.drawable.airpods);
                break;
            case "airdost":
                image.setImageResource(R.drawable.airdots);
                break;
            case "earpods":
                image.setImageResource(R.drawable.earpods);
                break;
             default:
                 image.setImageResource(R.drawable.airpods);
                 break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

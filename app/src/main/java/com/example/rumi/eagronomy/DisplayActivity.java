package com.example.rumi.eagronomy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Rumi on 11/5/2016.
 */

public class DisplayActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        String response = getIntent().getExtras().getString("response");
        TextView textView1 = (TextView) findViewById(R.id.textureaval);
        TextView textView2 = (TextView) findViewById(R.id.texttspval);
        TextView textView3 = (TextView) findViewById(R.id.textmopval);
        TextView textView4 = (TextView) findViewById(R.id.textgypsumval);
        TextView textView5 = (TextView) findViewById(R.id.textzincval);
        TextView textView6 = (TextView) findViewById(R.id.textsolubleval);

        try {
            JSONArray myData = new JSONArray(response);
            for(int i = 0 ; i < myData.length();i++){
                JSONObject row = myData.getJSONObject(i);
                String urea = row.getString("Urea");
                String tsp = row.getString("T.S.P.");
                String mop = row.getString("M.O.P.");
                String gypsum = row.getString("Gypsum");
                String zincsulphate = row.getString("ZincSulphate");
                String soluble = row.getString("Soluble");
//                int u = Integer.parseInt(urea);
//                int t = Integer.parseInt(tsp);
//                int m = Integer.parseInt(mop);
//                int g = Integer.parseInt(gypsum);
//                int z = Integer.parseInt(zincsulphate);
//                int s = Integer.parseInt(soluble);
                textView1.setText(urea);
                textView2.setText(tsp);
                textView3.setText(mop);
                textView4.setText(gypsum);
                textView5.setText(zincsulphate);
                textView6.setText(soluble);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

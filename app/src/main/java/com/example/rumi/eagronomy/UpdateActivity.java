package com.example.rumi.eagronomy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.nearby.messages.internal.Update;

import static com.example.rumi.eagronomy.MyLocationActivity.mark;
import static com.example.rumi.eagronomy.R.id.query_button;

/**
 * Created by Rumi on 11/22/2016.
 */

public class UpdateActivity extends Activity {

    private ProgressDialog progressDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        //query_button.setLayoutParams(new RelativeLayout.LayoutParams(10, 100));
        findViewById(query_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 = (EditText) findViewById(R.id.textareaval);
                editText1.setBackgroundColor(Color.WHITE);
                String s1 = editText1.getText().toString();

                EditText editText2 = (EditText) findViewById(R.id.textlandval);
                editText2.setBackgroundColor(Color.WHITE);
                String s2 = editText2.getText().toString();

                EditText editText3 = (EditText) findViewById(R.id.textcropval);
                editText3.setBackgroundColor(Color.WHITE);
                String s3 = editText3.getText().toString();

                EditText editText4 = (EditText) findViewById(R.id.textureaup);
                editText4.setBackgroundColor(Color.WHITE);
                String s4 = editText4.getText().toString();

                EditText editText5 = (EditText) findViewById(R.id.texttspup);
                editText5.setBackgroundColor(Color.WHITE);
                String s5 = editText5.getText().toString();

                EditText editText6 = (EditText) findViewById(R.id.textmopup);
                editText6.setBackgroundColor(Color.WHITE);
                String s6 = editText6.getText().toString();

                EditText editText7 = (EditText) findViewById(R.id.textgypsumup);
                editText7.setBackgroundColor(Color.WHITE);
                String s7 = editText7.getText().toString();

                EditText editText8 = (EditText) findViewById(R.id.textzincup);
                editText8.setBackgroundColor(Color.WHITE);
                String s8 = editText8.getText().toString();

                EditText editText9 = (EditText) findViewById(R.id.textsolup);
                editText9.setBackgroundColor(Color.WHITE);
                String s9 = editText9.getText().toString();

                progressDialog = ProgressDialog.show(UpdateActivity.this, "Please wait", "Loading");
                Snackbar.make(v, "Request sent", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                RequestQueue queue = Volley.newRequestQueue(UpdateActivity.this);
                String url = "http://10.100.5.31:8080/workshop_app_server/UpdateInfos?area=" + s1 + "&land=" + s2 + "&harvest=" + s3 +"&ur="+ s4 +"&ts="+ s5 +"&mo="+ s6 +"&gy="+ s7 +"&zs="+ s8 +"&so="+ s9;

                Log.i("rumi",url);

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                progressDialog.dismiss();
                                Toast.makeText(UpdateActivity.this,"Successfully Updated",Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(UpdateActivity.this,"Error or no connection!",Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                    }
                });
                queue.add(stringRequest);

            }
        });
    }
}

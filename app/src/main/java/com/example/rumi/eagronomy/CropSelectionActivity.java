package com.example.rumi.eagronomy;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static com.example.rumi.eagronomy.MyLocationActivity.mark;

/**
 * Created by Rumi on 10/4/2016.
 */

public class CropSelectionActivity  extends Activity implements AdapterView.OnItemSelectedListener {


    final Context context=this;
    //Button b1;
    Spinner sp1 , sp2 , sp3;
    ArrayList<String> categories1 = new ArrayList<String>();
    ArrayList<String> categories2;
    ArrayList<String> categories3;
    private ProgressDialog progressDialog;
    String s1 , s2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_selection);
        sp1 = (Spinner) findViewById(R.id.spinner_area);
        sp2 = (Spinner) findViewById(R.id.spinner_land_type);
        sp2.setOnItemSelectedListener(this);
        sp3 = (Spinner) findViewById(R.id.spinner_crops_type);

        categories1 = new ArrayList<>();
        categories1.add("Tukerbazar");       //area2
        categories1.add("Khadimnagar");       //area3
        categories1.add("Citycorporation");    //area4
        categories1.add("Kandigao");       //area5
        categories1.add("Jalalabad");      //area7

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(dataAdapter1);

        sp1.setOnItemSelectedListener(new OnItemSelectedListener() {
                                          @Override
                                          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                              final String selectedString1 = categories1.get(position);
                                              categories2 = new ArrayList<String>();
                                              if (mark.equals("Tukerbazar") || selectedString1.equals("Tukerbazar")) {
                                                  categories2.add("High");
                                                  categories2.add("Medium_high");
                                              }
                                              if (mark.equals("Khadimnagar") || selectedString1.equals("Khadimnagar")) {
                                                  categories2.add("High");
                                                  categories2.add("Medium_high");
                                              }
                                              if (mark.equals("Citycorporation") || selectedString1.equals("Citycorporation")) {
                                                  categories2.add("High");
                                                  categories2.add("Medium_high");
                                              }
                                              if (mark.equals("Kandigao") || selectedString1.equals("Kandigao")) {
                                                  categories2.add("Medium_low");
                                                  categories2.add("Low");
                                              }
                                              if (mark.equals("Jalalabad") || selectedString1.equals("Jalalabad")) {
                                                  categories2.add("Medium_high");
                                                  categories2.add("Medium_low");
                                              }
                                              ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(CropSelectionActivity.this, android.R.layout.simple_spinner_item, categories2);
                                              dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                              sp2.setAdapter(dataAdapter2);

                                              sp2.setOnItemSelectedListener(new OnItemSelectedListener() {
                                                  @Override
                                                  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                      String selectedString2 = categories2.get(position);
                                                      categories3 = new ArrayList<String>();
                                                      if (selectedString2.equals("High") && (mark.equals("Tukerbazar") || selectedString1.equals("Tukerbazar"))) {
                                                          categories3.add("Ginger");
                                                          categories3.add("Holud");
                                                          categories3.add("Pineapple");
                                                          categories3.add("Lemon");
                                                          categories3.add("Lemon(3-5)");
                                                          categories3.add("Lemon(6-10)");
                                                          categories3.add("Lemon(10+)");
                                                          categories3.add("Bona_Aush");
                                                          categories3.add("Ropa_Aush(Br)");
                                                          categories3.add("Ropa_Amon(Br)");
                                                          categories3.add("Ropa_Amon(Local)");
                                                      }
                                                      if ((mark.equals("Tukerbazar") || selectedString1.equals("Tukerbazar")) && selectedString2.equals("Medium_high")) {
                                                          categories3.add("Ropa_Amon(Br)");
                                                          categories3.add("Ropa_Amon(Local)");
                                                      }
                                                      if ((mark.equals("Khadimnagar") || selectedString1.equals("Khadimnagar")) && selectedString2.equals("High")) {
                                                          categories3.add("Ginger");
                                                          categories3.add("Holud");
                                                          categories3.add("Pineapple");
                                                          categories3.add("Lemon");
                                                          categories3.add("Lemon(3-5)");
                                                          categories3.add("Lemon(6-10)");
                                                          categories3.add("Lemon(10+)");
                                                          categories3.add("Badhakopi");
                                                          categories3.add("Fulkopi");
                                                          categories3.add("Borboti");
                                                          categories3.add("Bona_Aush(Local)");
                                                          categories3.add("Ropa_Amon(Br)");
                                                          categories3.add("Ropa_Amon(Local)");
                                                      }
                                                      if ((mark.equals("Khadimnagar") || selectedString1.equals("Khadimnagar")) && selectedString2.equals("Medium_high")) {
                                                          categories3.add("Ropa_Amon(Br)");
                                                          categories3.add("Ropa_Amon(Local)");
                                                      }
                                                      if ((mark.equals("Citycorporation") || selectedString1.equals("Citycorporation")) && selectedString2.equals("High")) {
                                                          categories3.add("Ginger");
                                                          categories3.add("Holud");
                                                          categories3.add("Pineapple");
                                                          categories3.add("Lemon");
                                                          categories3.add("Lemon(3-5)");
                                                          categories3.add("Lemon(6-10)");
                                                          categories3.add("Lemon(10+)");
                                                          categories3.add("Badhakopi");
                                                          categories3.add("Fulkopi");
                                                          categories3.add("Borboti");
                                                          categories3.add("Bona_Aush");
                                                          categories3.add("Ropa_Amon(Br)");
                                                          categories3.add("Ropa_Amon(Local)");
                                                      }
                                                      if ((mark.equals("Citycorporation") || selectedString1.equals("Citycorporation")) && selectedString2.equals("Medium_high")) {
                                                          categories3.add("Badhakopi");
                                                          categories3.add("Fulkopi");
                                                          categories3.add("Tomato");
                                                          categories3.add("Bona_Aush");
                                                          categories3.add("Rop_Amon(Br)");
                                                          categories3.add("Ropa_Amon(Local)");
                                                      }
                                                      if ((mark.equals("Kandigao") || selectedString1.equals("Kandigao")) && selectedString2.equals("Medium_low")) {
                                                          categories3.add("Boro(Br)");
                                                      }
                                                      if ((mark.equals("Kandigao") || selectedString1.equals("Kandigao")) && selectedString2.equals("Low")) {
                                                          categories3.add("Boro(Br)");
                                                          categories3.add("Boro(B)");
                                                          categories3.add("Boro(Br-wet)");
                                                      }
                                                      if ((mark.equals("Jalalabad") || selectedString1.equals("Jalalabad")) && selectedString2.equals("Medium_high")) {
                                                          categories3.add("Fulkopi");
                                                          categories3.add("Tomato");
                                                          categories3.add("Bona_Aush(Local)");
                                                          categories3.add("Ropa_Aush(Br)");
                                                          categories3.add("Ropa_Amon(Br)");
                                                          categories3.add("Badhakopi");
                                                      }
                                                      if ((mark.equals("Jalalabad") || selectedString1.equals("Jalalabad")) && selectedString2.equals("Medium_low")) {
                                                          categories3.add("Boro(Br-29,Hybrid)");
                                                          categories3.add("Boro(Br-28)");
                                                          categories3.add("Boro(Local)");
                                                      }
                                                      ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(CropSelectionActivity.this, android.R.layout.simple_spinner_item, categories3);
                                                      dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                                      sp3.setAdapter(dataAdapter3);
                                                  }

                                                  @Override
                                                  public void onNothingSelected(AdapterView<?> parent) {

                                                  }
                                              });
                                          }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spinnerString1 = categories1.get(sp1.getSelectedItemPosition());
                String spinnerString1al = mark;
                String spinnerString2 = categories2.get(sp2.getSelectedItemPosition());
                String spinnerString3 = categories3.get(sp3.getSelectedItemPosition());

                progressDialog = ProgressDialog.show(CropSelectionActivity.this , "Please wait" , "Loading");
                Snackbar.make(v , "Request sent" , Snackbar.LENGTH_LONG)
                        .setAction("Action" , null).show();
                RequestQueue queue = Volley.newRequestQueue(CropSelectionActivity.this);
                final String url = "http://172.16.5.141:8080/workshop_app_server/Login?area="+spinnerString1al+"&land="+spinnerString2+"&harvest="+spinnerString3;
                Log.i("rumi",url);

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.i("sofijaosifj",url);
                                progressDialog.dismiss();
                                Toast.makeText(CropSelectionActivity.this,"Success",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(CropSelectionActivity.this , DisplayActivity.class);
                                    intent.putExtra("response",response);
                                    startActivity(intent);
                                    finish();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(CropSelectionActivity.this,"Error or no connection!",Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                    }
                });
                queue.add(stringRequest);

            }
        });

        findViewById(R.id.map_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CropSelectionActivity.this , MyLocationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ///sp3.setOnItemSelectedListener(this);
        //AbsoluteLayout rl = (AbsoluteLayout)findViewById(R.id.sign_up);
        //rl.setBackgroundColor(Color.WHITE);
    }



  //  @Override
    /*public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }*/

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}



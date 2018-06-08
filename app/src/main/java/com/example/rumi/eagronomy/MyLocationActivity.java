package com.example.rumi.eagronomy;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MyLocationActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public static String mark = "Tukerbazar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng tukerbazar = new LatLng(24.9131, 91.813);
        Marker myMarker = mMap.addMarker(new MarkerOptions().position(tukerbazar).title("Tukerbazar"));
        myMarker.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tukerbazar));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                mark = marker.getTitle();
                Toast.makeText(MyLocationActivity.this,"You have selected Tukerbazar",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MyLocationActivity.this , CropSelectionActivity.class);
                startActivity(intent);
                finish();
                //Log.i("my position",mark);
                return false;
            }
        });

        LatLng khadimnagar = new LatLng(24.9287, 91.968);
        Marker myMarker1 = mMap.addMarker(new MarkerOptions().position(khadimnagar).title("Khadimnagar"));
        myMarker1.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(khadimnagar));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                mark = marker.getTitle();
                Toast.makeText(MyLocationActivity.this,"You have selected Khadimnagar",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MyLocationActivity.this , CropSelectionActivity.class);
                startActivity(intent);
                finish();
                //Log.i("my position",mark);
                return false;
            }
        });

        LatLng citycorporation = new LatLng(24.9, 91.877);
        Marker myMarker2 = mMap.addMarker(new MarkerOptions().position(citycorporation).title("Citycorporation"));
        myMarker2.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(citycorporation));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                mark = marker.getTitle();
                Toast.makeText(MyLocationActivity.this,"You have selected Citycorporation",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MyLocationActivity.this , CropSelectionActivity.class);
                startActivity(intent);
                finish();
                //Log.i("my position",mark);
                return false;
            }
        });

        LatLng kandigao = new LatLng(24.919, 91.787);
        Marker myMarker3 = mMap.addMarker(new MarkerOptions().position(kandigao).title("Kandigao"));
        myMarker3.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kandigao));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                //String mark;
                mark = marker.getTitle();
                Toast.makeText(MyLocationActivity.this,"You have selected Kandigao",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MyLocationActivity.this , CropSelectionActivity.class);
                startActivity(intent);
                finish();
                //Log.i("my position",mark);
                return false;
            }
        });

        LatLng jalalabad = new LatLng(24.91, 91.86);
        Marker myMarker4 = mMap.addMarker(new MarkerOptions().position(jalalabad).title("Jalalabad"));
        myMarker4.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jalalabad));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                mark = marker.getTitle();
                Toast.makeText(MyLocationActivity.this,"You have selected Jalalabad",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MyLocationActivity.this , CropSelectionActivity.class);
                startActivity(intent);
                finish();
                //Log.i("my position",mark);
                return false;
            }
        });
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("MyLocation Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

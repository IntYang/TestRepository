package com.mycompany.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermission();
    }

    public void checkPermission() {
        int permissionGps = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int permissionNetwork = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if(permissionGps != PackageManager.PERMISSION_GRANTED || permissionNetwork != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    1
            );
        }
    }

    public void handleBtnCurrentLocation(View view) {
        checkPermission();
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(
            LocationManager.NETWORK_PROVIDER,
            10000,
            0,
            locationListener
        );
    }

    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            Log.i(TAG, "위도: " + latitude);
            Log.i(TAG, "경도: " + longitude);
            locationManager.removeUpdates(locationListener);
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {}
        @Override
        public void onProviderEnabled(String provider) {}
        @Override
        public void onProviderDisabled(String provider) {}
    };

    public void handleBtnFromAddressToLocation(View v) {
        String url = "https://apis.daum.net/local/geo/addr2coord";
        HttpUrl httpUrl = HttpUrl.parse(url).newBuilder()
                .addQueryParameter("apikey", "6ea947c658d564e97b4aefa5d1c5d4de")
                .addQueryParameter("q","서울특별시 동작구 사당로14길 23(사당동)")
                .addQueryParameter("output", "json")
                .build();
        Request request = new Request.Builder()
                .url(httpUrl)
                .build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // \u00aa 등을 한글로 변환하기 위해 StringEscapeUtils 사용
                // compile 'commons-lang:commons-lang:2.6' 추가해야 함
                final String json = StringEscapeUtils.unescapeJava(response.body().string());
                Log.i(TAG, json);
                try{
                    JSONObject jsonObject = new JSONObject(json);
                    jsonObject = jsonObject.getJSONObject("channel");
                    JSONArray jsonArray = jsonObject.getJSONArray("item");
                    jsonObject = jsonArray.getJSONObject(0);
                    double latitude = jsonObject.getDouble("lat");
                    double longitude = jsonObject.getDouble("lng");
                    Log.i(TAG, "위도:"+latitude);
                    Log.i(TAG, "경도:"+longitude);
                }catch(JSONException e){
                    e.printStackTrace();
                }


            }
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG, e.toString());
            }
        });
    }
}

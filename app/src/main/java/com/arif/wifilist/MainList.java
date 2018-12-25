package com.arif.wifilist;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.arif.wifilist.Adapters.RecyclerViewAdapter;
import com.arif.wifilist.Util.GetData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainList extends AppCompatActivity {

    private GetData getData = new GetData();
    private String macAdress = "";

    private RecyclerViewAdapter setAdapter;


    private WifiManager wifiManager;
    private RecyclerView list;
    private Button buttonScan;
    private int size = 0;
    private List<ScanResult> results;
    private Map<String,String> arrayList = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        buttonScan = findViewById(R.id.btn);
        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanWifi();
            }
        });

        list = findViewById(R.id.list_recyc);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        if (!wifiManager.isWifiEnabled()) {
            Toast.makeText(this, "WiFi is disabled ... We need to enable it", Toast.LENGTH_LONG).show();
            wifiManager.setWifiEnabled(true);
        }

        setAdapter = new RecyclerViewAdapter(MainList.this,arrayList);
        list.setAdapter(setAdapter);
        scanWifi();
    }

    private void scanWifi() {

        arrayList.clear();

        registerReceiver(wifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        wifiManager.startScan();
        results = wifiManager.getScanResults();


        Toast.makeText(this, "Scanning WiFi ...", Toast.LENGTH_SHORT).show();
    }

    BroadcastReceiver wifiReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            results = wifiManager.getScanResults();
            unregisterReceiver(this);

            arrayList.put("", String.valueOf(wifiManager.getConnectionInfo().getIpAddress()));

            for (ScanResult scanResult : results) {
                arrayList.put(scanResult.SSID , scanResult.capabilities);
                setAdapter.notifyDataSetChanged();
            }
        }
    };
}
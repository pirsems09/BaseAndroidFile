package com.arif.wifilist.Util.Dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arif.wifilist.R;
import com.arif.wifilist.Util.Dagger2.DaggerHomeComponent;
import com.arif.wifilist.Util.Dagger2.Home;
import com.arif.wifilist.Util.Dagger2.HomeComponent;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity {

    @Inject Home home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        HomeComponent homeComponent = DaggerHomeComponent.create();
        homeComponent.inject(this);
        home.door();

    }
}

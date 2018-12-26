package com.arif.wifilist.Util.Dagger2;

import android.util.Log;

import javax.inject.Inject;

public class Home {

    private static final String TAG = "Home";

    ClassOne classOne;
    ClassTwo classTwo;

    @Inject
    public Home(ClassOne classOne, ClassTwo classTwo) {
        this.classOne = classOne;
        this.classTwo = classTwo;
    }

    public void door(){
        Log.d(TAG, "door.... ");
    }

}

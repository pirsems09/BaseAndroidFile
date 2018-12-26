package com.arif.wifilist.Util.Dagger2;

import dagger.Component;

@Component
public interface HomeComponent {

    Home getHome();

    void inject(DaggerActivity daggerActivity);
}

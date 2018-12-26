package com.arif.wifilist.Util;

import android.content.Context;

import com.onesignal.OneSignal;

public class PushNotification {

    public void run(Context context){


        OneSignal.startInit(context)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        OneSignal.idsAvailable(new OneSignal.IdsAvailableHandler() {
            @Override
            public void idsAvailable(String userId, String registrationId) {
                //session.createNotification(userId);
            }
        });
    }
}

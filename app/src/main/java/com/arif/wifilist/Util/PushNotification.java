package com.arif.wifilist.Util;

import com.onesignal.OneSignal;

public class PushNotification {

    public void run(){

        OneSignal.startInit(this)
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

package com.arif.wifilist.Util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class TwitterBroadcastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();
        /*
        if (TweetUploadService.UPLOAD_SUCCESS.equals(intent.getAction())) {
            final Long tweetId = intentExtras.getLong(TweetUploadService.EXTRA_TWEET_ID);
            Log.i("Twitter", "Sucess");
        } else if (TweetUploadService.UPLOAD_FAILURE.equals(intent.getAction())) {
            final Intent retryIntent = intentExtras.getParcelable(TweetUploadService.EXTRA_RETRY_INTENT);
            Log.i("Twitter", "Failure");
        } else if (TweetUploadService.TWEET_COMPOSE_CANCEL.equals(intent.getAction())) {
            Log.i("Twitter", "Cancelled");
        }
        */
    }
}

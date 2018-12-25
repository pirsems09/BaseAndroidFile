package com.arif.wifilist.Util;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
public class Webview extends AppCompatActivity {

    private WebView myWebView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        url = String.valueOf(getIntent().getExtras().getString("url"));

        //WebView myWebView = findViewById(R.id.load_url_web_view);

        myWebView.loadUrl(url);

        WebSettings webSettings = myWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);
    }
}

package com.neon.wv_test;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {
    private WebView wv;
    private WebSettings webSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv = findViewById(R.id.wv);

        webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);

        wv.setWebViewClient(new WebViewClient());
        wv.addJavascriptInterface(new WebAppInterface(this),"Android");
        wv.loadUrl("http://smart.tobesoft.co.kr/M/_android_/index.jsp");

    }
    public void btnClick(View v)
    {
        wv.loadUrl("javascript:fn_Interface('nativeMessage');");
    }
}

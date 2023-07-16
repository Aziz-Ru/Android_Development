package com.aziz.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private WebView web;
Button buttonIncrease,buttonDecrease;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web=findViewById(R.id.webView);
        WebSettings webSettings=web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://codeforces.com");
//        buttonIncrease.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                increaseFontSize();
//            }
//        });

//        buttonDecrease.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                decreaseFontSize();
//            }
//        });
    }

    private void increaseFontSize() {
        WebSettings webSettings = web.getSettings();
        int currentSize = webSettings.getTextZoom();
        webSettings.setTextZoom(currentSize + 1);
    }

    private void decreaseFontSize() {
        WebSettings webSettings = web.getSettings();
        int currentSize = webSettings.getTextZoom();
        webSettings.setTextZoom(currentSize - 1);
    }

    @Override
    public void onBackPressed() {
        // Check if WebView can go back and navigate back
        if (web.canGoBack()) {
            web.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
package com.example.myapplication.DU;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myapplication.R;

public class Arts extends shake {

    private WebView artView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts);

        artView =(WebView) findViewById(R.id.artWeb);
        artView.setWebViewClient(new WebViewClient());
        artView.getSettings().setDomStorageEnabled(true);
        artView.getSettings().setJavaScriptEnabled(true);
        artView.getSettings().setGeolocationEnabled(true);
        artView.loadUrl("https://stephensplace.org/16-crafts-for-adults-with-intellectual-and-developmental-disabilities/");
        artView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
            {
                // Handle the error
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
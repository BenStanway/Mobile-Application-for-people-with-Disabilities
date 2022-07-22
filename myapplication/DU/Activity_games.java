package com.example.myapplication.DU;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myapplication.R;

public class Activity_games extends shake {

    private WebView gamesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        MediaPlayer Games = MediaPlayer.create(this, R.raw.menugames);
        Games.start();
        gamesView =(WebView) findViewById(R.id.gamesweb);
        gamesView.setWebViewClient(new WebViewClient());
        gamesView.getSettings().setDomStorageEnabled(true);
        gamesView.getSettings().setJavaScriptEnabled(true);
        gamesView.loadUrl("https://www.coolmathgames.com/");//https://www.coolmathgames.com/
        gamesView.setWebViewClient(new WebViewClient() {
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
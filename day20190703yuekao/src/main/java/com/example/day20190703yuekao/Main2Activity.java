package com.example.day20190703yuekao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {
    String urls = "http://www.cctv.com/";
    private WebView web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //控件
        web_view = (WebView)findViewById(R.id.web_view);

        web_view.loadUrl(urls);
        web_view.setWebViewClient(new WebViewClient());


    }
}

package com.example.day20190703yuekao.httputils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpUtils {

    //单例模式
    private static HttpUtils httpUtils = new HttpUtils();

    public HttpUtils() {
    }

    public  static HttpUtils getInstance(){
        return getInstance();
    }


    //判断网络状态
    public static boolean isNetWork(Context context){

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null){
            return networkInfo.isAvailable();
        }

        return false;
    }


    //网络请求
    public static String HttpData(String s){
        try {
            URL url = new URL(s);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int code = connection.getResponseCode();
            if (code==HttpURLConnection.HTTP_OK){
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();
                String str = "";
                while ((str=reader.readLine())!=null){
                    builder.append(str);

                }
                reader.close();
                return builder.toString();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}

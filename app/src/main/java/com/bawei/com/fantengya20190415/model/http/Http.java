package com.bawei.com.fantengya20190415.model.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/15 09:03:30
 * @Description:
 */
public class Http {

    //单例
    private static Http http;
    private static String TAG = ".http";
    private Http(){};
    public static Http getInstance(){
        if (http == null){
            synchronized (Http.class){
                if (http == null){
                    http = new Http();
                }
            }
        }
        return http;
    }
    //异步请求
    public static void getAsyncTask(String url, final String phone, final String pwd, final CallBack callBack){
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return doPost(strings[0],strings[1],strings[2]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (!TextUtils.isEmpty(s)){
                    callBack.onSuccess(s);
                }else {
                    callBack.onFail(503,"网页找不到");
                }
            }
        }.execute(url,phone,pwd);
    }
    //判断有无网络
    public static boolean isNet(Context context){
        if (context!=null){
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null){
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    //获取网络请求（post）
    public static String doPost(String StrUrl,String phone,String pwd){
        try {
            URL url = new URL(StrUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("POST");
            String body = "phone="+ URLEncoder.encode(phone)+"&pwd="+URLEncoder.encode(pwd);
            connection.getOutputStream().write(body.getBytes());
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();
            String str = "";
            while ((str=reader.readLine())!=null){

                builder.append(str);
            }
            connection.disconnect();
            Log.d("xxx",builder.toString());
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //创建一个接口
    public interface CallBack{
        void onSuccess(String result);
        void onFail(int errorcode,String message);
    }

}

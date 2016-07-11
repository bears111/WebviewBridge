package com.vrseen.webviewbridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import jsbridge.core.JsCallback;

/**
 * Created by sunjie on 2016/06/30.
 */
public class BridgePlug  {
    private final static  String TAG="BridgePlug";
    public static void showToast(WebView webView, JSONObject data, JsCallback callback) {
        Toast.makeText(webView.getContext(), data.toString(), Toast.LENGTH_SHORT).show();
        JSONObject result = new JSONObject();
        try {
            result.put("result", "appName");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsCallback.invokeJsCallback(callback, true, result, "1234");
    }

    public static void getIMSI(final WebView webView, JSONObject data, final JsCallback callback) {
        TelephonyManager telephonyManager = ((TelephonyManager) webView.getContext().getSystemService(Context.TELEPHONY_SERVICE));
        String imsi = telephonyManager.getSubscriberId();
        if (TextUtils.isEmpty(imsi)) {
            imsi = telephonyManager.getDeviceId();
        }
        JSONObject result = new JSONObject();
        try {
            result.put("imsi", imsi);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsCallback.invokeJsCallback(callback, true, result, "123");
    }


    public static void getAppName(final WebView webView, JSONObject data, final JsCallback callback) {
        String appName;
        JSONObject result = new JSONObject();
        try {
            PackageManager packageManager = webView.getContext().getApplicationContext().getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(webView.getContext().getApplicationContext().getPackageName(), 0);
            appName = packageManager.getApplicationLabel(applicationInfo).toString();
            result.put("result", appName);
        } catch (Exception e) {
            appName = "";
            Log.e(TAG,e.getMessage());
        }
        JsCallback.invokeJsCallback(callback, true, result, null);
    }

    public static void  jumpActivity(final WebView webView, JSONObject data, final JsCallback callback) {
        try {
            if (webView.getContext() instanceof Activity)
            {
                Activity activity =(Activity) webView.getContext();
                Intent intent = new Intent(activity,LoginActivity.class);
                activity.startActivity(intent);
            }
        } catch (Exception e) {
           Log.e(TAG,e.getMessage());
        }
        JsCallback.invokeJsCallback(callback, true, null, null);
    }

    public static void getOsSdk(WebView webView, JSONObject data, JsCallback callback) {
        JSONObject result = new JSONObject();
        try {
            result.put("os_sdk", Build.VERSION.SDK_INT);
        } catch (JSONException e) {
            Log.e(TAG,e.getMessage());
        }
        JsCallback.invokeJsCallback(callback, true, result, null);
    }

    public static void finish(WebView webView, JSONObject data, JsCallback callback) {
        try{
            if (webView.getContext() instanceof Activity) {
                ((Activity) webView.getContext()).finish();
            }
        }catch (Exception e){
            Log.e(TAG,e.getMessage());
        }
    }

    public static void delayExecuteTask(WebView webView, JSONObject data, final JsCallback callback) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                JSONObject result = new JSONObject();
                try {
                    result.put("result", "延迟3s执行native方法");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JsCallback.invokeJsCallback(callback, true, result, null);
            }
        }, 3000);
    }


}

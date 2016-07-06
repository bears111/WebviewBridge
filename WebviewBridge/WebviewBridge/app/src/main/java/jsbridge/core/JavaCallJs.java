package jsbridge.core;

import android.util.Log;
import android.webkit.WebView;

import org.json.JSONObject;

import java.util.Locale;

import jsbridge.async.AsyncTaskExecutor;

/**
 * Created by Administrator on 2016/6/30.
 */
public class JavaCallJs {
    public static void javaCallJs(WebView DOwebView,String Activity,JSONObject resultData)  {
        final WebView DTOwebView = DOwebView;
        String CALLBACK_JS_FORMAT = "javascript:RainbowBridge.onJavaComplete"+Activity+"(%s);";
        final String callbackJs = String.format(Locale.getDefault(), CALLBACK_JS_FORMAT, resultData.toString());
        if (AsyncTaskExecutor.isMainThread()) {
            DTOwebView.loadUrl(callbackJs);
        } else {
            AsyncTaskExecutor.runOnMainThread(new Runnable() {
                @Override
                public void run() {
                    DTOwebView.loadUrl(callbackJs);
                }
            });
        }
    }
}

package jsbridge.core;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.vrseen.webviewbridge.LoginActivity;
import com.vrseen.webviewbridge.R;

/**
 * Created by sunjie on 2016/7/1.
 */
public class BridgeWebChromeClinet extends WebChromeClient {
    public BridgeWebChromeClinet() {

    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        result.confirm();
        JsCallJava.newInstance().call(view,message);
        return true;
    }

    @Override
    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        return super.onJsConfirm(view, url, message, result);
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        return super.onJsAlert(view, url, message, result);
    }
    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        Activity activity = (Activity) view.getContext();
        final ProgressBar bar = (ProgressBar)activity.findViewById(R.id.myProgressBar);
        Log.i("BridgeWebChromeClinet",newProgress+"-------------------");
        if (newProgress == 100) {
            bar.setVisibility(View.INVISIBLE);
        } else {
            if (View.INVISIBLE == bar.getVisibility()) {
                bar.setVisibility(View.VISIBLE);
            }
            bar.setProgress(newProgress);
        }
        super.onProgressChanged(view, newProgress);
    }
}

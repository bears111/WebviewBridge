package jsbridge.core;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by Administrator on 2016/7/1.
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
}

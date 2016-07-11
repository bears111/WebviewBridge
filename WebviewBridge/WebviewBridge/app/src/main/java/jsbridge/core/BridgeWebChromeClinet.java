package jsbridge.core;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.vrseen.webviewbridge.R;

/**
 * Created by sunjie on 2016/7/1.
 */
public class BridgeWebChromeClinet extends WebChromeClient {
    private final String TAG="BridgeWebChromeClinet";
    public BridgeWebChromeClinet() {

    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        result.confirm();
        //Log.i(TAG,message+"--"+defaultValue+"----"+result+"-----"+JsCallJava.newInstance());
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

    @Override
    public void onConsoleMessage(String message, int lineNumber, String sourceID) {
        Log.i("console", message + "(" +sourceID  + ":" + lineNumber+")");
        super.onConsoleMessage(message, lineNumber, sourceID);
    }

    @Override
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Log.i("console", "["+consoleMessage.messageLevel()+"] "+ consoleMessage.message() + "(" +consoleMessage.sourceId()  + ":" + consoleMessage.lineNumber()+")");
        return super.onConsoleMessage(consoleMessage);
    }

}

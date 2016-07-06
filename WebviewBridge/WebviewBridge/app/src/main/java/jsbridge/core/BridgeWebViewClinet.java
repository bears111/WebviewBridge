package jsbridge.core;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 2016/7/1.
 */
public class BridgeWebViewClinet extends WebViewClient {
    private final String TAG="BridgeWebViewClinet";
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
//        Log.i(TAG,"加载的URL"+url);
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
     /*   Log.i(TAG,"加载的URL"+url);*/
        super.onPageFinished(view, url);
    }

}

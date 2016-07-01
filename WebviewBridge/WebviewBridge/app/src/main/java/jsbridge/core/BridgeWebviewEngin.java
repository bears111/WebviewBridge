package jsbridge.core;

import android.graphics.Bitmap;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by sunjie on 2016/6/28.
 */
public  class BridgeWebviewEngin {

 public static  WebView initWebViewSettings(WebView myWebView ){
   WebSettings webSettings = myWebView.getSettings();
   webSettings.setJavaScriptEnabled(true);
   webSettings.setAllowFileAccess(true);
   webSettings.setAllowContentAccess(true);
   webSettings.setUseWideViewPort(true);
   webSettings.setLoadWithOverviewMode(true);
   if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
     webSettings.setAllowUniversalAccessFromFileURLs(true);
     webSettings.setAllowFileAccessFromFileURLs(true);
   }

   if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
     webSettings.setMediaPlaybackRequiresUserGesture(false);
   }


     myWebView.setWebViewClient(new BridgeWebViewClinet());
     myWebView.setWebChromeClient(new BridgeWebChromeClinet());
   return myWebView;
 }
}

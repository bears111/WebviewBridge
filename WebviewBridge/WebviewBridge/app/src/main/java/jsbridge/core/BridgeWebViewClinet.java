package jsbridge.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.vrseen.webviewbridge.R;

/**
 * Created by Administrator on 2016/7/1.
 */
public class BridgeWebViewClinet extends WebViewClient {
    private final String TAG="BridgeWebViewClinet";
    private WindowManager mWM;
    private View mViewToast;
    private Context mContext;
    private boolean flag=true;
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
//        Log.i(TAG,"加载的URL"+url);
        mContext = view.getContext();
        //Toast.makeText(App.getInstance().getApplicationContext(),"加载中",Toast.LENGTH_LONG).show();
        mWM = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        if (flag){
            showToast();
        }
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
     /*   Log.i(TAG,"加载的URL"+url);*/
        if(flag&&mWM!=null && mViewToast!=null){
            flag=false;
            mWM.removeView(mViewToast);
        }
        super.onPageFinished(view, url);
    }
    public void showToast() {
        //自定义吐司

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();

        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
        params.format = PixelFormat.TRANSLUCENT;
        params.type = WindowManager.LayoutParams.TYPE_TOAST ;
        params.gravity = Gravity.CENTER;
        params.setTitle("Toast");

        mViewToast = View.inflate(mContext, R.layout.loading, null);
        mWM.addView(mViewToast, params);
    }
}

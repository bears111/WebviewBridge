package com.vrseen.webviewbridge;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.List;

import jsbridge.RainbowBridge;
import jsbridge.core.BridgeWebviewEngin;
import jsbridge.core.JavaCallJs;

public class MainActivity extends Activity {
    private final String TAG="MainActivity";
    private WebView myWebView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = (WebView) findViewById(R.id.webView);
        button=(Button)findViewById(R.id.button);
        Activity activity=(Activity)button.getContext();
        myWebView= BridgeWebviewEngin.initWebViewSettings(myWebView);
        RainbowBridge.getInstance().clazz(BridgePlug.class).inject();
        myWebView.loadUrl("file:///android_asset/dist/index.html");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myWebView.getContext(), "原生按钮点击了", Toast.LENGTH_SHORT).show();
                JSONObject resultObj = new JSONObject();
                try {
                    resultObj.put("msg",12);
                    resultObj.put("code",2);
                }catch (Exception e){
                    e.printStackTrace();
                }
                JavaCallJs.javaCallJs(myWebView,"MainActivity",resultObj);
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack(); // goBack()表示返回WebView的上一页面
            Log.i(TAG,"----"+myWebView.getProgress());
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}

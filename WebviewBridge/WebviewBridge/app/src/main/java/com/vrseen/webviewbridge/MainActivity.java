package com.vrseen.webviewbridge;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONObject;

import jsbridge.RainbowBridge;
import jsbridge.core.BridgeWebviewEngin;
import jsbridge.core.JavaCallJs;

public class MainActivity extends Activity {
    private WebView myWebView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = (WebView) findViewById(R.id.webView);
        button=(Button)findViewById(R.id.button);
        myWebView= BridgeWebviewEngin.initWebViewSettings(myWebView);
        RainbowBridge.getInstance()
                .clazz(BridgePlug.class)
                .inject();
        myWebView.loadUrl("file:///android_asset/dist/index.html");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myWebView.getContext(), "点击了", Toast.LENGTH_SHORT).show();
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
}

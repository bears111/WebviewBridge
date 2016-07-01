package jsbridge;


import jsbridge.core.NativeMethodInjectHelper;

/**
 * Created by sunjie on 2016/06/30.
 */
public class RainbowBridge {
    private volatile static RainbowBridge sInstance;

    private RainbowBridge() {
    }

    public static RainbowBridge getInstance() {
        RainbowBridge instance = sInstance;
        if (instance == null) {
            synchronized (RainbowBridge.class) {
                instance = sInstance;
                if (instance == null) {
                    instance = new RainbowBridge();
                    sInstance = instance;
                }
            }
        }
        return instance;
    }

    public NativeMethodInjectHelper clazz(Class<?> clazz) {
        return NativeMethodInjectHelper.getInstance()
                .clazz(clazz);
    }
}

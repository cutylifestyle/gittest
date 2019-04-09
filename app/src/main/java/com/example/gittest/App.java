package com.example.gittest;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.Toast;

public class App extends Application {

    private static final String TAG = "APP1";
    private MyBroadCastReceiver receiver;
    public static final String action = "com.action.test";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "app onCreate");
        receiver = new MyBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(action);
        registerReceiver(receiver, intentFilter);
    }

    private class MyBroadCastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "action:" + intent.getAction());
            Toast.makeText(context, intent.getAction(), Toast.LENGTH_SHORT).show();
        }
    }
}

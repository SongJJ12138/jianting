package com.example.jianting.Service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class CallService extends IntentService {

    public CallService() {
        super("CallService");
    }

    public CallService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        long dateTime=intent.getLongExtra("date",0);
        Log.e("服务","开启通话记录服务");
    }

    @Override
    public void onDestroy() {
        Log.e("服务","结束通话记录服务");
        super.onDestroy();
    }
}

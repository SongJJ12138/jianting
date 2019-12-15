package com.example.jianting.Service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

class PhoneService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public PhoneService(String name) {
        super(name);
    }
    public PhoneService() {
        super("PhoneService");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        long dateTime=intent.getLongExtra("date",0);
        Log.e("服务","开启手机基本信息服务");
    }

    @Override
    public void onDestroy() {
        Log.e("服务","结束手机基本信息服务");
        super.onDestroy();
    }
}

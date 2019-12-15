package com.example.jianting.Service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class RadiusService extends IntentService {
    public RadiusService(){
        super("RadiusService");
    }
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public RadiusService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        long dateTime=intent.getLongExtra("date",0);
        Log.e("服务","开启地址服务");
    }

    @Override
    public void onDestroy() {
        Log.e("服务","结束地址服务");
        super.onDestroy();
    }
}

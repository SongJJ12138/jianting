package com.example.jianting.Service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class PicService extends IntentService {
    public PicService() {
        super("PicService");
    }
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public PicService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        long dateTime=intent.getLongExtra("date",0);
        Log.e("服务","开启照片服务");
    }

    @Override
    public void onDestroy() {
        Log.e("服务","结束照片服务");
        super.onDestroy();
    }
}

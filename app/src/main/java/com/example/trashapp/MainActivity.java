package com.example.trashapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                if(count >= 3){
                    timer.cancel();
                    Intent time = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(time);
                    finish();
                }
                else{
                    count++;
                }
            }
        },1000, 1000);
    }
}
package com.mirea.shakhnazaryan.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class MyLooper extends Thread{
    private int number = 0;
    Handler handler;
    int timeDelay;

    @SuppressLint("HandlerLeak")
    @Override
    public void run(){
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                timeDelay = 20;
                int age = msg.getData().getInt("AGE");
                String work = msg.getData().getString("WORK");
                try {
                    Thread.sleep(age);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("MyLooper", number + ": "+ msg.getData().getString("KEY"));
                number++;

                Log.d("MyLooper", "Age: " + age);
                Log.d("MyLooper", "Work: " + work);
            }
        };
        Looper.loop();
    }
}

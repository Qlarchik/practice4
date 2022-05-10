package com.mirea.shakhnazaryan.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText countOfLessons;
    private EditText countOfDays;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countOfLessons = findViewById(R.id.editText1);
        countOfDays = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView);
    }

    public void onClick(View view) {
        Runnable runnable = new Runnable() {
            public void run() {
                int number1 = 0;
                int number2 = 0;
                int result = 0;
                number1 = Integer.parseInt(countOfLessons.getText().toString());
                number2 = Integer.parseInt(countOfDays.getText().toString());
                result = number1 / number2;
                textView.setText(String.valueOf(result));
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
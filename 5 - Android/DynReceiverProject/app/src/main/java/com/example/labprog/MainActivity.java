package com.example.labprog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    protected BroadcastReceiver batteryReceiver;
    protected Integer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        count = 0;
        batteryReceiver = new BroadcastReceiver(){

            @Override
            public void onReceive(Context context, Intent intent)
            {

                TextView textView = (TextView) findViewById(R.id.textView);
                String text = textView.getText().toString();

                count += 1;
                if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                    text = "\n" + count.toString() + " - BATTERY_CHANGED" + text;
                }

                if (intent.getAction().equals("android.intent.action.BATTERY_LOW")) {
                    text = "\n" + count.toString() + " - BATTERY_LOW" + text;
                }


                textView.setText(text);
            }
        };
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            if(batteryReceiver != null){
                unregisterReceiver(batteryReceiver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.BATTERY_CHANGED");
        filter.addAction("android.intent.action.BATTERY_LOW");
        registerReceiver(batteryReceiver, filter);
    }

}
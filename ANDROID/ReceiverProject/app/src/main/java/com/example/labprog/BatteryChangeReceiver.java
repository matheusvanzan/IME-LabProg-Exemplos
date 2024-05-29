package com.example.labprog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class BatteryChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
            Toast.makeText(context, "BATTERY_CHANGED", Toast.LENGTH_SHORT).show();
        }

        if (intent.getAction().equals("android.intent.action.BATTERY_LOW")) {
            Toast.makeText(context, "BATTERY_LOW", Toast.LENGTH_SHORT).show();
        }
    }

}
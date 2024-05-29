package com.example.labprog;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.ActivityManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        start = (Button) findViewById( R.id.btnStart );
        start.setOnClickListener( this );

        stop = (Button) findViewById( R.id.btnStop );
        stop.setOnClickListener( this );
    }

    public void onClick(View view) {

        if(view == start){
            Toast.makeText(this, "START", Toast.LENGTH_LONG).show();
            startService(new Intent( this, PlayerService.class ));

        }  else if (view == stop){
            Toast.makeText(this, "STOP", Toast.LENGTH_LONG).show();
            stopService(new Intent( this, PlayerService.class ));
        }
    }
}
package com.example.fibonacci;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainActivity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void btnClick(View v){
        Toast.makeText(this, "Btn clicked!", Toast.LENGTH_LONG).show();

        EditText textInput = (EditText) findViewById(R.id.textInput);
        String text = textInput.getText().toString();
        Integer number = Integer.parseInt(text);

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("number", number);

        startActivity(intent);
        //finish();
    }
}
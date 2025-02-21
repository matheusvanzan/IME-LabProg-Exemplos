package com.example.labprog;

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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void btnClick(View v) {

        // get and check email password
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        String email = editTextEmail.getText().toString();

        // save email local
        DBController db = new DBController(this);
        String resultado = db.insert(email);
        Toast.makeText(this, resultado, Toast.LENGTH_LONG).show();

        // redirect
        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("email", email);
        startActivity(i);
    }
}
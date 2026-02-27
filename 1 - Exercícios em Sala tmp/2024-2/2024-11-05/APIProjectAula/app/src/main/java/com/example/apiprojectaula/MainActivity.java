package com.example.apiprojectaula;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

        Button btnLoad = (Button) findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        // Permitir request na mesma Thread da UI
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

    }


    @Override
    public void onClick(View v) {
        String url = "https://reqres.in/api/users";
        String response = makeGetRequest(url);
        Log.d("MYAPP", response);

        parseJson(response);
    }

    public String makeGetRequest(String url) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseString = response.body().string();
            Log.d("MYAPP", responseString);

            return responseString;
        } catch (Exception e) {
            // throw new RuntimeException(e);
            Log.d("MYAPP", e.toString());
        }

        return "";
    }

    public void parseJson(String jsonText) {
        LinearLayout contentLinearLayout = (LinearLayout) findViewById(R.id.content);

        try {
            JSONObject json = new JSONObject(jsonText);
            JSONArray data = json.getJSONArray("data");

            for(int i=0; i<data.length(); i++) {
                JSONObject el = data.getJSONObject(i);

                String email = el.getString("email");
                String name = el.getString("first_name");

                TextView newItem = new TextView(this);
                newItem.setTextSize(20);
                newItem.setText(name + " (" + email + ")");

                contentLinearLayout.addView(newItem);

                Log.d("MYAPP", email);
            }
        } catch (Exception e) {
            // throw new RuntimeException(e);
            Log.d("MYAPP", e.toString());
        }
    }
}
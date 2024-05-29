package com.example.labprog;

import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    Adapter adapter;
    private OkHttpClient client;

    ArrayList userItems = new ArrayList<>();
    // Arrays.asList(new UserItem("User 1", "user-1@gmail.com", "https://reqres.in/img/faces/6-image.jpg")));

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

        // Getting reference of recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Setting the layout as linear
        // layout for vertical orientation
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        // Sending reference and data to Adapter
        adapter = new Adapter(MainActivity.this, userItems);
        recyclerView.setAdapter(adapter);

        // Button listener
        Button btnGetData = (Button) findViewById(R.id.btnGetData);
        btnGetData.setOnClickListener( this );

        // Permitir request na mesma Thread da UI
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    private String makeGetRequest(String url) {
        client = new OkHttpClient();
        Request request = new Request.Builder()
            .url(url)
            .build();

        try {
            Response response = client.newCall(request).execute();
            //if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }

            String m = response.body().string();
            Log.d("", m);
            return m;

        } catch (Exception e) {
            //throw new RuntimeException(e);
            return e.toString();
        }
    }

    private void parseJson(String jsonText) {
        try {
            JSONObject json = new JSONObject(jsonText);
            JSONArray data = json.getJSONArray("data");

            for (int i=0; i<data.length(); i++) {
                JSONObject row = data.getJSONObject(i);
                String email = row.getString("email");
                String name = row.getString("first_name");

                String imgUrl = row.getString("avatar");

                Log.d("", email);
                int insertIndex = userItems.size();
                userItems.add(insertIndex, new UserItem(name, email, imgUrl));
                adapter.notifyItemInserted(insertIndex);

            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "onClick", Toast.LENGTH_LONG).show();

        String url = "https://reqres.in/api/users";
        String response = makeGetRequest(url);
        parseJson(response);

    }
}
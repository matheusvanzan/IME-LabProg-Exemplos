package com.example.labprog;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private Button btn;
    private RecyclerView recyclerView;
    private Adapter adapter;

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

        // Views
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);

        // Getting reference of recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Setting the layout as linear
        // layout for vertical orientation
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

    }

    // Permission Launcher genérico para várias permissões
    private ActivityResultLauncher<String> requestPermissionLauncher =
        registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {

        if (isGranted) {
            // Permissão concedida
            // Seguir o fluxo normal (da permissão)

            Log.d("DEBUG", "Permissão concedida");
        } else {
            // Usuário negou a permissão
            // Feedback explicando porque precisa da permissão

            Log.d("DEBUG", "Usuário negou a permissão");
        }
    });

    private ArrayList<String> getNumerosContato(String idContato) {
        ArrayList<String> numeros = new ArrayList<String>();
        Cursor cursor = this.getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                new String[] { idContato }, null);

        if (cursor.moveToFirst()) {
            do {
                int indexNumber = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String numero = cursor.getString(indexNumber);
                numeros.add(numero);
//                arrayNumero.put(numero);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return numeros;
    }


    public void readContacts() {

        // Contacts

        Cursor cursor = this.getContentResolver().query(
            ContactsContract.Contacts.CONTENT_URI,   // endereçamento do informação
            null,                                    // a lista de todas as colunas
            null,                                    // filtro dos registros
            null,                                    // para colocar ?
            ContactsContract.Contacts.DISPLAY_NAME);// critério de ordenação

        int colId = cursor.getColumnIndex(ContactsContract.Contacts._ID);
        int colHasTelefone = cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
        int colNome = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);

        Log.d("CONTACTS", "colId = " + Integer.toString(colId));
        Log.d("CONTACTS", "colHasTelefone = " + Integer.toString(colHasTelefone));
        Log.d("CONTACTS", "colNome = " + Integer.toString(colNome));

        Log.d("CONTACTS", "-");

        ArrayList<CustomContact> contactsList = new ArrayList<CustomContact>();
        CustomContact contact;

        while(cursor.moveToNext()) {
            String stringId = cursor.getString(colId);
            String stringHasTelefone = cursor.getString(colHasTelefone);
            String stringNome = cursor.getString(colNome);

            Log.d("CONTACTS", "stringId = " + stringId);
            Log.d("CONTACTS", "stringHasTelefone = " + stringHasTelefone);
            Log.d("CONTACTS", "stringNome = " + stringNome);

            contact = new CustomContact();
            contact.setId(cursor.getString(colId));
            contact.setNome(cursor.getString(colNome));

            if (Integer.parseInt(stringHasTelefone) > 0) {
                ArrayList<String> numeros = new ArrayList<String>();

                numeros = getNumerosContato(cursor.getString(colId));

                if ((numeros != null) && (numeros.size() > 0)) {
                    Log.d("CONTACT", String.valueOf(numeros));
                    contact.setTelefone(numeros.get(0));

                }
            }
            contactsList.add(contact);
        }
        cursor.close();

        // Sending reference and data to Adapter
        adapter = new Adapter(MainActivity.this, contactsList);
        recyclerView.setAdapter(adapter);
    }



    @Override
    public void onClick(View v) {
        Log.d("CLICK", "onClick");

        // Verifica as permissões para acesso aos contatos
        if (ContextCompat.checkSelfPermission(
                this, android.Manifest.permission.READ_CONTACTS) ==
                PackageManager.PERMISSION_GRANTED) {

            // Permissão já concedida (sempre)
            readContacts();

        } else if (ActivityCompat.shouldShowRequestPermissionRationale(
                this, android.Manifest.permission.READ_CONTACTS)) {

            // Permissão concedida mas deve perguntar ao usuário

        }
        else {
            // Caso contrário, pedir a permissão

            requestPermissionLauncher.launch(android.Manifest.permission.READ_CONTACTS);
        }
    }

}
package com.example.labprog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBController {
    private SQLiteDatabase db;
    private DBHelper banco;

    public DBController(Context context){
        banco = new DBHelper(context);
    }

    public String insert(String email){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DBHelper.EMAIL, email);

        resultado = db.insert(DBHelper.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public Cursor getAll(){
        Cursor cursor;
        String[] campos =  {banco.ID, banco.EMAIL};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

}

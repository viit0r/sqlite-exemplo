package com.vitor.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase sqLiteDatabase;
    private Banco banco;

    public BancoController(Context context){
        banco = new Banco(context);
    }

    public String inserir(String nome, String ra){

        ContentValues values;
        long resultado;

        sqLiteDatabase = banco.getReadableDatabase();
        values = new ContentValues();
        values.put(Banco.NOME, nome);
        values.put(Banco.RA, ra);

        resultado = sqLiteDatabase.insert(Banco.TABELA, null, values);
        sqLiteDatabase.close();

        if (resultado == -1){
            return "Erro ao inserir";
        }else{
            return "Registro inserido com sucesso!";
        }
    }

}

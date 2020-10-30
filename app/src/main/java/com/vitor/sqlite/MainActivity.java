package com.vitor.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nome, ra;
    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editNome);
        ra = findViewById(R.id.editRA);
        botao = findViewById(R.id.btnEnviar);

        BancoController bancoController = new BancoController(getApplicationContext());
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoNome = nome.getText().toString();
                String textoRA = ra.getText().toString();
                String resultado = bancoController.inserir(textoNome, textoRA);

                Toast.makeText(MainActivity.this, resultado, Toast.LENGTH_LONG).show();
                        
            }
        });
    }
}
package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btnSeguinte = findViewById(R.id.btnSeguinte);
        btnSeguinte.setOnClickListener(selecao);
    }

    private final View.OnClickListener selecao = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            RadioButton jurosSimples = findViewById(R.id.rbtnSimples);
            RadioButton jurosComposto = findViewById(R.id.rbtnComposto);
            RadioButton desconto = findViewById(R.id.rbtnDesconto);

            if (jurosSimples.isChecked()){
                Intent next = new Intent(Principal.this, jurosSimples.class);
                startActivity(next);
            }else if (jurosComposto.isChecked()){
                Intent next = new Intent(Principal.this, jurosComposto.class);
                startActivity(next);
            }else if(desconto.isChecked()){
                Intent next = new Intent(Principal.this, desconto.class);
                startActivity(next);
            }else {
                Toast.makeText(Principal.this, "Selecione uma opção!", Toast.LENGTH_LONG).show();
            }
        }
    };

}

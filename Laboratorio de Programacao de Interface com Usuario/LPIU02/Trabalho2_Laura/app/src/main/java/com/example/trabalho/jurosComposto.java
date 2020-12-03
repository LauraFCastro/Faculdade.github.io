package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class jurosComposto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juros_composto);

        Button calcular = findViewById(R.id.calcular);
        calcular.setOnClickListener(calcularJuros);
    }

    private final View.OnClickListener calcularJuros = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText capital = findViewById(R.id.capital);
            EditText taxa = findViewById(R.id.taxaJuros);
            EditText prazo = findViewById(R.id.antecipacao);

            RadioButton mes = findViewById(R.id.mes);
            RadioButton ano = findViewById(R.id.ano);
            String tempo = null;

            if (mes.isChecked()) {
                tempo = "ao mês";
            } else if (ano.isChecked()) {
                tempo = "ao ano";
            } else {
                Toast toast = Toast.makeText(jurosComposto.this, "É preciso selecionar uma opção!", Toast.LENGTH_LONG);
                toast.show();
            }

            Bundle bundle = new Bundle();
            bundle.putString("capital", String.valueOf(capital.getText()));
            bundle.putString("taxa", String.valueOf(taxa.getText()));
            bundle.putString("prazo", String.valueOf(prazo.getText()));
            bundle.putString("tempo", tempo);

            if (capital.getText().toString().equals("")) {
                Toast.makeText(jurosComposto.this, "Favor preencher o CAPITAL!", Toast.LENGTH_LONG).show();
            } else if (taxa.getText().toString().equals("")) {
                Toast.makeText(jurosComposto.this, "Favor preencher a TAXA!", Toast.LENGTH_LONG).show();
            } else if (prazo.getText().toString().equals("")) {
                Toast.makeText(jurosComposto.this, "Favor preencher o PRAZO!", Toast.LENGTH_LONG).show();
            }else if(tempo == null){
                Toast.makeText(jurosComposto.this, "Favor preencher o TEMPO da taxa!", Toast.LENGTH_LONG).show();
            } else {
                Intent next = new Intent(jurosComposto.this, resultadojComposto.class);
                next.putExtras(bundle);
                startActivity(next);
            }
        }
    };
}

package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.Toast;


public class desconto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desconto);

        Button calcularDesconto = findViewById(R.id.calcularDesconto);
        calcularDesconto.setOnClickListener(calcular);
    }

    private final View.OnClickListener calcular = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            EditText titulo = findViewById(R.id.capital);
            EditText taxaD = findViewById(R.id.taxaD);
            EditText antecipacao = findViewById(R.id.antecipacao);

            RadioButton mes = findViewById(R.id.mes);
            RadioButton ano = findViewById(R.id.ano);
            String tempo;

            if (mes.isChecked()) {
                tempo = "ao mês";
            } else if (ano.isChecked()) {
                tempo = "ao ano";
            } else {
                tempo = null;
            }

            Bundle bundle = new Bundle();
            bundle.putString("titulo", titulo.getText().toString());
            bundle.putString("taxa", taxaD.getText().toString());
            bundle.putString("antecipacao", antecipacao.getText().toString());
            bundle.putString("tempo", tempo);

            if (titulo.getText().toString().equals("")) {
                Toast toast = Toast.makeText(desconto.this, "Favor preencha o Valor do TÍTULO!", Toast.LENGTH_LONG);
                toast.show();
            }
            else if (taxaD.getText().toString().equals("")) {
                Toast.makeText(desconto.this, "Favor preencha a TAXA!", Toast.LENGTH_LONG).show();
            }
            else if (antecipacao.getText().toString().equals("")) {
                Toast.makeText(desconto.this, "Favor preencha o PRAZO da antecipação!", Toast.LENGTH_LONG).show();
            }else if (tempo == null) {
                Toast.makeText(desconto.this, "Selecione o TEMPO da taxa!", Toast.LENGTH_LONG).show();
            }else {
                Intent next = new Intent(desconto.this, resultadoDesconto.class);
                next.putExtras(bundle);
                startActivity(next);
            }
        }
    };
}

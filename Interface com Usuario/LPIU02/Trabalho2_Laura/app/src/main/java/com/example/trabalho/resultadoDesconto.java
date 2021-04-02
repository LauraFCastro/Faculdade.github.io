package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class resultadoDesconto extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_desconto);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        TextView desconto = findViewById(R.id.montante);
        TextView titulo = findViewById(R.id.capital);
        TextView taxa = findViewById(R.id.taxaD);
        TextView aoTempo = findViewById(R.id.aoTempo);
        TextView antecipacao = findViewById(R.id.antecipacao);

        titulo.setText(bundle.getString("titulo"));
        taxa.setText(bundle.getString("taxa"));
        aoTempo.setText(bundle.getString("tempo"));
        antecipacao.setText(bundle.getString("antecipacao"));

        double N = Double.parseDouble(titulo.getText().toString());
        double i = Double.parseDouble(taxa.getText().toString());
        double n = Double.parseDouble(antecipacao.getText().toString());

        double D = N * (i/100) * n;
        desconto.setText(Double.toString(D));

        FloatingActionButton btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(voltar);

    }

    private final View.OnClickListener voltar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent next = new Intent(resultadoDesconto.this, Principal.class);
            startActivity(next);
        }

    };
}

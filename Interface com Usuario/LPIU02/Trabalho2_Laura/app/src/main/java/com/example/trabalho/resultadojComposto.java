package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;

public class resultadojComposto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadoj_composto);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        TextView montante = findViewById(R.id.montante);
        TextView capital = findViewById(R.id.capital);
        TextView taxa = findViewById(R.id.taxaD);
        TextView aoTempo = findViewById(R.id.aoTempo);
        TextView prazo = findViewById(R.id.antecipacao);

        capital.setText(bundle.getString("capital"));
        taxa.setText(bundle.getString("taxa"));
        aoTempo.setText(bundle.getString("tempo"));
        prazo.setText(bundle.getString("prazo"));

        TextView mesAno = findViewById(R.id.mesAno);
        String variavelMesAno = null;

        if (bundle.getString("tempo").equals("ao ano")){
            variavelMesAno = "anos";
        }else if (bundle.getString("tempo").equals("ao mês")){
            variavelMesAno = "meses";
        }
        mesAno.setText(variavelMesAno);

        double C = Double.parseDouble(capital.getText().toString());
        double i = Double.parseDouble(taxa.getText().toString());
        int t = Integer.parseInt(prazo.getText().toString());

        DecimalFormat df = new DecimalFormat("##,###.000");

        TableLayout tabela = (TableLayout) findViewById(R.id.tabela);
        double Mont;
        for (int j=1; j <= t; j++){
            Mont = (C * Math.pow(1+(i/100), j));
            TextView mo = new TextView(this);
            mo.setText(df.format(Mont));
            tabela.addView(mo, (j-1));
        }

        double M = C * ( Math.pow((1+(i/100)),t) );
        montante.setText(df.format(M));

        FloatingActionButton btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(voltar);

    }

    private final View.OnClickListener voltar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent next = new Intent(resultadojComposto.this, Principal.class);
            startActivity(next);
        }

    };


}

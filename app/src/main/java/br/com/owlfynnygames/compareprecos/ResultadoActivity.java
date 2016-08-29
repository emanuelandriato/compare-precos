package br.com.owlfynnygames.compareprecos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Emanuel on 25/08/2016.
 */

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String resultado = extras.getString("resultadoComparacao");
            tvResultado.setText(resultado);
        }
    }


}

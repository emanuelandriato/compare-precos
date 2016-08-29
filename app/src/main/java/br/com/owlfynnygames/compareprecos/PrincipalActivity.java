package br.com.owlfynnygames.compareprecos;


import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PrincipalActivity extends AppCompatActivity {
    private EditText edtQtdeProd1;
    private EditText edtQtdeProd2;
    private EditText edtMLProd1;
    private EditText edtMLProd2;
    private EditText edtPrecoProd1;
    private EditText edtPrecoProd2;
    private Button buttonComparar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        edtQtdeProd1 = (EditText) findViewById(R.id.edtQtdeProd1);
        edtQtdeProd2 = (EditText) findViewById(R.id.edtQtdeProd2);
        edtMLProd1 = (EditText) findViewById(R.id.edtMLProd1);
        edtMLProd2 = (EditText) findViewById(R.id.edtMLProd2);
        edtPrecoProd1 = (EditText) findViewById(R.id.edtPrecoProd1);
        edtPrecoProd2 = (EditText) findViewById(R.id.edtPrecoProd2);
        buttonComparar = (Button) findViewById(R.id.btnComparar);

        buttonComparar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //intencao
                Intent intentComparar = new Intent(PrincipalActivity.this,ResultadoActivity.class);
                //enviar dados para actividade que sera aberta
                intentComparar.putExtra("resultadoComparacao",CompararPrecos());
                //iniciar intencao
                startActivity(intentComparar);
            }
        });

        }

    public String CompararPrecos(){
        int qtdeProd1 = Integer.parseInt(String.valueOf(edtQtdeProd1.getText()));
        int qtdeProd2 = Integer.parseInt(String.valueOf(edtQtdeProd2.getText()));
        double precoProd1 = Double.parseDouble(String.valueOf(edtPrecoProd1.getText()));
        double precoProd2 = Double.parseDouble(String.valueOf(edtPrecoProd2.getText()));
        double mlProd1 = Double.parseDouble(String.valueOf(edtMLProd1.getText()));
        double mlProd2 = Double.parseDouble(String.valueOf(edtMLProd2.getText()));
        double vrMlProd1 = precoProd1/(qtdeProd1*mlProd1);
        double vrMlProd2 = precoProd2/(qtdeProd2*mlProd2);
        double ganhoEstimado = (mlProd2-mlProd1)*(vrMlProd1-vrMlProd2);

        if(ganhoEstimado < 0){ganhoEstimado = ganhoEstimado*-1;}
        String retorno;

        if(vrMlProd1 < vrMlProd2){
            retorno = "A opção 1 está mais em conta.\n";
            retorno = retorno+" A opção 2 deveria custar R$"+ Double.toString(vrMlProd1*qtdeProd2*mlProd2)+"\n";
            retorno = retorno+"Um ganho estimado de R$"+Double.toString(ganhoEstimado)+" por unidade.";;
        }
        else if(vrMlProd1 > vrMlProd2){
            retorno = "A opção 2 está mais em conta.\n";
            retorno = retorno+" A opção 1 deveria custar R$"+ Double.toString((vrMlProd2)*qtdeProd1*mlProd1)+" a unidade.\n";
            retorno = retorno+"Um ganho estimado de R$"+Double.toString(ganhoEstimado)+" por unidade.";
        }
        else{retorno = "Ambas opções possuem os mesmos valores.";}

        return retorno;
    }


}

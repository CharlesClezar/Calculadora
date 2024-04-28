package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button botaoZero, botaoUm, botaoDois, botaoTres, botaoQuatro, botaoCinco, botaoSeis, botaoSete, botaoOito, botaoNove, botaoSomar, botaoSubtrair, botaoMultiplicar, botaoDividir, botaoIgual, botaoLimpar;
    private TextView conta, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Componentes();

        botaoZero.setOnClickListener(this);
        botaoUm.setOnClickListener(this);
        botaoDois.setOnClickListener(this);
        botaoTres.setOnClickListener(this);
        botaoQuatro.setOnClickListener(this);
        botaoCinco.setOnClickListener(this);
        botaoSeis.setOnClickListener(this);
        botaoSete.setOnClickListener(this);
        botaoOito.setOnClickListener(this);
        botaoNove.setOnClickListener(this);
        botaoSomar.setOnClickListener(this);
        botaoSubtrair.setOnClickListener(this);
        botaoMultiplicar.setOnClickListener(this);
        botaoDividir.setOnClickListener(this);

        botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                conta.setText("");
                resultado.setText("");
            }
        });

        botaoIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expression realizarConta = new ExpressionBuilder(conta.getText().toString()).build();
                double resultadoConta = realizarConta.evaluate();
                long resultadoLongo = (long) resultadoConta;

                if (resultadoConta == (double)resultadoLongo){
                    resultado.setText((CharSequence) String.valueOf(resultadoLongo));
                }else{
                    resultado.setText((CharSequence) String.valueOf(resultadoConta));
                }
            }
        });
    }

    private void Componentes(){
        botaoZero = findViewById(R.id.btn_0);
        botaoUm = findViewById(R.id.btn_1);
        botaoDois = findViewById(R.id.btn_2);
        botaoTres = findViewById(R.id.btn_3);
        botaoQuatro = findViewById(R.id.btn_4);
        botaoCinco = findViewById(R.id.btn_5);
        botaoSeis = findViewById(R.id.btn_6);
        botaoSete = findViewById(R.id.btn_7);
        botaoOito = findViewById(R.id.btn_8);
        botaoNove = findViewById(R.id.btn_9);
        botaoSomar = findViewById(R.id.btn_somar);
        botaoSubtrair = findViewById(R.id.btn_subtrair);
        botaoMultiplicar = findViewById(R.id.btn_multiplicar);
        botaoDividir = findViewById(R.id.btn_dividir);
        botaoIgual = findViewById(R.id.btn_igual);
        botaoLimpar = findViewById(R.id.btn_limpar);
        conta = findViewById(R.id.conta);
        resultado = findViewById(R.id.resultado);
    }

    public void ApresentarConta(String string, boolean limpar_conta){

        if (resultado.getText().equals("")){
            conta.setText(" ");
        }

        if(limpar_conta) {
            resultado.setText(" ");
            conta.append(string);
        }else {
            conta.append(resultado.getText());
            conta.append(string);
            resultado.setText(" ");
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_0) {
            ApresentarConta("0", true);
        }

        if (v.getId() == R.id.btn_1) {
            ApresentarConta("1", true);
        }

        if (v.getId() == R.id.btn_2) {
            ApresentarConta("2", true);
        }

        if (v.getId() == R.id.btn_3) {
            ApresentarConta("3", true);
        }

        if (v.getId() == R.id.btn_4) {
            ApresentarConta("4", true);
        }

        if (v.getId() == R.id.btn_5) {
            ApresentarConta("5", true);
        }

        if (v.getId() == R.id.btn_6) {
            ApresentarConta("6", true);
        }

        if (v.getId() == R.id.btn_7) {
            ApresentarConta("7", true);
        }

        if (v.getId() == R.id.btn_8) {
            ApresentarConta("8", true);
        }

        if (v.getId() == R.id.btn_9) {
            ApresentarConta("9", true);
        }

        if (v.getId() == R.id.btn_somar) {
            ApresentarConta("+ ", false);
        }

        if (v.getId() == R.id.btn_subtrair) {
            ApresentarConta("- ", false);
        }

        if (v.getId() == R.id.btn_multiplicar) {
            ApresentarConta("* ", false);
        }

        if (v.getId() == R.id.btn_dividir) {
            ApresentarConta("/ ", false);
        }

        if (v.getId() == R.id.btn_limpar) {
            ApresentarConta("0", true);
        }
    }
}
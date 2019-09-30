package com.example.dhfitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.dhfitness.CadastroActivity.ALTURA_KEY;
import static com.example.dhfitness.CadastroActivity.IDADE_KEY;
import static com.example.dhfitness.CadastroActivity.IMG_KEY;
import static com.example.dhfitness.CadastroActivity.NOME_KEY;
import static com.example.dhfitness.CadastroActivity.PESO_KEY;
import static com.example.dhfitness.CadastroActivity.PESSOA_KEY;

public class ExibicaoActivity extends AppCompatActivity {
    private TextView recebeNome;
    private TextView recebeIdade;
    private TextView recebePeso;
    private TextView recebeAltura;
    private ImageView recebeImagem;
    private Button btnCalcular;

    private String nome;
    private int idade;
    private double peso;
    private double altura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibicao);

        Intent intent = getIntent();

        initViews();

        Bundle bundle = intent.getExtras();

        nome = bundle.getString(NOME_KEY);
        idade = bundle.getInt(IDADE_KEY);
        peso = bundle.getDouble(PESO_KEY);
        altura = bundle.getDouble(ALTURA_KEY);
        final int imagem = bundle.getInt(IMG_KEY);

        recebeIdade.setText("Idade: " + idade);
        recebePeso.setText("Peso: " + peso);
        recebeAltura.setText("Altura: " + altura);

        Drawable drawable = getResources().getDrawable(imagem);

        recebeNome.setText(String.format("Seja bem-vindo, %s. Esse é um aplicativo que te ajuda a saber e calcular o seu índice de massa corporal.", nome));
        recebeImagem.setImageDrawable(drawable);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExibicaoActivity.this,ResultadoActivity.class);

                Bundle bundle = new Bundle();

                bundle.putString(NOME_KEY, nome);
                bundle.putInt(IDADE_KEY, idade);
                bundle.putDouble(PESO_KEY, peso);
                bundle.putDouble(ALTURA_KEY, altura);
                bundle.putInt(IMG_KEY, imagem);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }

    public void initViews(){
        recebeNome = findViewById(R.id.recebeNome);
        recebeIdade = findViewById(R.id.recebeIdade);
        recebePeso = findViewById(R.id.recebePeso);
        recebeAltura = findViewById(R.id.recebeAltura);
        recebeImagem = findViewById(R.id.recebeImgProfile);
        btnCalcular = findViewById(R.id.btnCalcularImc);
    }
}

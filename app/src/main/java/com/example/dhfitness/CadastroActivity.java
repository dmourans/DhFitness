package com.example.dhfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputLayout;

public class CadastroActivity extends AppCompatActivity {

    private TextInputLayout inputNome;
    private TextInputLayout inputIdade;
    private TextInputLayout inputAltura;
    private TextInputLayout inputPeso;
    private ImageView imgProfile;
    private Button btnComecar;

    public static final String NOME_KEY = "nome";
    public static final String IDADE_KEY = "idade";
    public static final String PESO_KEY = "peso";
    public static final String ALTURA_KEY = "altura";
    public static final String IMG_KEY = "imagem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        InitViews();

        Intent intent = new Intent(CadastroActivity.this, ExibicaoActivity.class);

        Bundle bundle = new Bundle();

        String nome = inputNome.getEditText().getText().toString();
        int idade = Integer.parseInt(inputNome.getEditText().getText().toString());
        double peso = Double.parseDouble(inputPeso.getEditText().getText().toString());
        double altura = Double.parseDouble(inputAltura.getEditText().getText().toString());
        int imagem = Integer.parseInt(String.valueOf(imgProfile.getId()));

        bundle.putString(NOME_KEY, nome);
        bundle.putInt(IDADE_KEY, idade);
        bundle.putDouble(PESO_KEY, peso);
        bundle.putDouble(ALTURA_KEY, altura);
        bundle.putInt(IMG_KEY, imagem);

        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void InitViews(){
        inputNome = findViewById(R.id.inputNome);
        inputIdade = findViewById(R.id.inputIdade);
        inputAltura = findViewById(R.id.inputAltura);
        inputPeso = findViewById(R.id.inputPeso);
        imgProfile = findViewById(R.id.imgProfile);
    }

}

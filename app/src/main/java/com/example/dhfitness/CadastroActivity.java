package com.example.dhfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CadastroActivity extends AppCompatActivity {

    private TextInputLayout inputNome;
    private TextInputLayout inputIdade;
    private TextInputLayout inputAltura;
    private TextInputLayout inputPeso;
    private TextInputEditText inputEditPeso;
    private ImageView imgProfile;
    private Button btnComecar;

    public static final String NOME_KEY = "nome";
    public static final String IDADE_KEY = "idade";
    public static final String PESO_KEY = "peso";
    public static final String ALTURA_KEY = "altura";
    public static final String IMG_KEY = "imagem";
    public static final String PESSOA_KEY = "pessoa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        InitViews();

        btnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, ExibicaoActivity.class);

                Bundle bundle = new Bundle();

                String nome = inputNome.getEditText().getText().toString();
                int idade = Integer.parseInt(inputIdade.getEditText().getText().toString());
                double peso = Double.parseDouble(inputPeso.getEditText().getText().toString());
                double altura = Double.parseDouble(inputAltura.getEditText().getText().toString());
                int imagem = R.id.imgProfile;
                //int imagem = Integer.parseInt(String.valueOf(imgProfile.getId()));

                //Pessoa pessoa = new Pessoa(nome, idade, peso, altura, imagem);

                bundle.putString(NOME_KEY, nome);
                bundle.putInt(IDADE_KEY, idade);
                bundle.putDouble(PESO_KEY, peso);
                bundle.putDouble(ALTURA_KEY, altura);
                bundle.putInt(IMG_KEY, imagem);
                //bundle.putParcelable(PESSOA_KEY, pessoa);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }

    public void InitViews(){
        inputNome = findViewById(R.id.inputNome);
        inputIdade = findViewById(R.id.inputIdade);
        inputAltura = findViewById(R.id.inputAltura);
        inputPeso = findViewById(R.id.inputPeso);
        imgProfile = findViewById(R.id.imgProfile);
        btnComecar = findViewById(R.id.btnComecar);
    }

}

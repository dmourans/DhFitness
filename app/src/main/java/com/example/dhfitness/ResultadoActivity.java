package com.example.dhfitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.dhfitness.CadastroActivity.ALTURA_KEY;
import static com.example.dhfitness.CadastroActivity.IDADE_KEY;
import static com.example.dhfitness.CadastroActivity.NOME_KEY;
import static com.example.dhfitness.CadastroActivity.PESO_KEY;
import static com.example.dhfitness.CadastroActivity.PESSOA_KEY;

public class ResultadoActivity extends AppCompatActivity implements Comunicador {

    private FloatingActionButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        replaceFragment(R.id.container_button, new BotaoFragment());

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        double peso = bundle.getDouble(PESO_KEY);
        double altura = bundle.getDouble(ALTURA_KEY);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ResultadoActivity.this, CadastroActivity.class);
                startActivity(intent1);
            }
        });



    }

    public void replaceFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    @Override
    public void recebeMensagem(Pessoa pessoa) {
        setBundleToFragment(pessoa, PESSOA_KEY);
    }

    public void setBundleToFragment(Pessoa pessoa, String CHAVE){
        Bundle bundle = new Bundle();

        bundle.putParcelable(CHAVE, Opcao);

        Fragment botaoFragment = new BotaoFragment();

        botaoFragment.setArguments(bundle);

        replaceFragment(R.id.container, botaoFragment);
    }




}

package com.example.dhfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class splashActivity extends AppCompatActivity {
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        },1000);

    }

    private void jump(){
        timer.cancel();
        startActivity(new Intent(splashActivity.this, CadastroActivity.class));
        finish();
    }

}

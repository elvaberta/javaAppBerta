package com.example.crudapi.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.crudapi.R;
import com.example.crudapi.ui.login.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private int waktu_loading=4000;
    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_splash_screen );
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langusng berpindah ke home activity

                Intent intent =new Intent( SplashScreenActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },waktu_loading);
    }
}
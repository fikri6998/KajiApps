package com.example.mobivision.kajiapps;

/**
 * Created by asus a456 on 25/02/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //MENAMPILKAN TOAST
        Toast toast = Toast.makeText(getApplicationContext(), "Selamat datang di KajiApps", Toast.LENGTH_SHORT);
        toast.show();


        //PINDAH KE SCREEN LOGIN
        final Intent intent;
        intent = new Intent(this, LoginActivity.class);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2500); // waktu untuk jeda
                    startActivity(intent); //mulai pindah ke screen berikutnya
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }
}

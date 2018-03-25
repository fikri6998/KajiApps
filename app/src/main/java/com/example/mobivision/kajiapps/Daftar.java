package com.example.mobivision.kajiapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.ustadz.mobivision.kajiapps.UstadzActivity;

public class Daftar extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);


    }
    public void aksiDaftar(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }


}

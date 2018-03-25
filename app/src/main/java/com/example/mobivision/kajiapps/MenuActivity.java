package com.example.mobivision.kajiapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.kajian.mobivision.kajiapps.KajianActivity;
import com.kajian.mobivision.kajiapps.MainMenuKajianActivity;
import com.ustadz.mobivision.kajiapps.UstadzActivity;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void aksiUstadz(View view) {
        Intent intent = new Intent(this, UstadzActivity.class);
        startActivity(intent);
    }

    public void aksiKajian(View view) {
        Intent intent = new Intent(this, MainMenuKajianActivity.class);
        startActivity(intent);
    }
}

package com.kajian.mobivision.kajiapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mobivision.kajiapps.R;

public class MainMenuKajianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_kajian);
    }

    public void aksiKajian(View view) {
        Intent intent = new Intent(this, KajianActivity.class);
        startActivity(intent);
    }
}

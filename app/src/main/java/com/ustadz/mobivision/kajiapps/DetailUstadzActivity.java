package com.ustadz.mobivision.kajiapps;

/**
 * Created by asus a456 on 25/02/2018.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobivision.kajiapps.R;

public class DetailUstadzActivity extends AppCompatActivity {
    //deklarasi variable
    ImageView gambar;
    TextView nama, detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ustadz);
        setTitle("Info Ustadz"); //set title bar

        //memanggil gambar, nama, detail, liter, baterai yang ada di layout
        gambar = findViewById(R.id.imgMerk);
        nama = findViewById(R.id.tvMerk);
        detail = findViewById(R.id.tvDeskripsi);

        //set gambar,nama dan detail item di dapat intent
        gambar.setImageDrawable(this.getResources().getDrawable(Integer.valueOf(getIntent().getStringExtra("foto"))));
        nama.setText(getIntent().getStringExtra("nama"));
        detail.setText(getIntent().getStringExtra("detail"));


    }


}

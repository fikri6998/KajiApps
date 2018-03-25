package com.kajian.mobivision.kajiapps;

/**
 * Created by asus a456 on 25/02/2018.
 */


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mobivision.kajiapps.R;

import java.util.ArrayList;
import java.util.List;

public class KajianActivity extends AppCompatActivity {
    //deklarasi variable
    RecyclerView rv;
    AdapterKajian adapter;
    List<Kajian> listmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kajian);

        //UNTUK JUDUL LAYAR
        setTitle("Daftar Info Kajian");


        //MEMBUAT ARRAYLIST
        listmenu = new ArrayList<>();
        rv = findViewById(R.id.listMenu);
        rv.setHasFixedSize(true);


        //UNTUK ORIENTASI LAYAR LANDSCAPE
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rv.setLayoutManager(new GridLayoutManager(KajianActivity.this, 2));
        } else {
            rv.setLayoutManager(new GridLayoutManager(KajianActivity.this, 1));
        }
        initdata(); //EKSEKUSI
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rv.setLayoutManager(new GridLayoutManager(KajianActivity.this, 2));
        } else {
            rv.setLayoutManager(new GridLayoutManager(KajianActivity.this, 1));
        }
    }

    private void initdata() {
        //masukkan data ke dalam array
        listmenu.add(new Kajian(R.drawable.masjid_1, "SHIFT WEEK END", "Kajian Rutin Setiap Sabtu-Minggu\nWaktu : 19:00 PM - 21:00 PM"));
        listmenu.add(new Kajian(R.drawable.masjid_2, "HOPE", "Kajian Rutin HOPE\nWaktu : 19:00 PM - 21:00 PM"));
        listmenu.add(new Kajian(R.drawable.masjid_3, "GO-SHIFT", "Kunjungan Kajian Rutin Setiap Kampus\nWaktu : 19:00 PM - 21:00 PM"));
        listmenu.add(new Kajian(R.drawable.masjid_4, "SHARING RABU", "Kajian Rutin Setiap Rabu\nWaktu : 19:00 PM - 21:00 PM"));

        //membuat adapter yang mengubungkan kelas ini dengan data yang ditampilkan
        adapter = new AdapterKajian(this, listmenu);

        //menghubungkan recyclerview dengan adapter
        rv.setAdapter(adapter);
    }
}


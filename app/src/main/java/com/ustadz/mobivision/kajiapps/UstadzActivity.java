package com.ustadz.mobivision.kajiapps;

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

public class UstadzActivity extends AppCompatActivity {
    //deklarasi variable
    RecyclerView rv;
    AdapterUstadz adapter;
    List<Ustadz> listmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustadz);

        //UNTUK JUDUL LAYAR
        setTitle("Daftar Info Ustadz");


        //MEMBUAT ARRAYLIST
        listmenu = new ArrayList<>();
        rv = findViewById(R.id.listMenu);
        rv.setHasFixedSize(true);


        //UNTUK ORIENTASI LAYAR LANDSCAPE
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rv.setLayoutManager(new GridLayoutManager(UstadzActivity.this, 3));
        } else {
            rv.setLayoutManager(new GridLayoutManager(UstadzActivity.this, 2));
        }
        initdata(); //EKSEKUSI
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rv.setLayoutManager(new GridLayoutManager(UstadzActivity.this, 2));
        } else {
            rv.setLayoutManager(new GridLayoutManager(UstadzActivity.this, 1));
        }
    }

    private void initdata() {
        //masukkan data ke dalam array
        listmenu.add(new Ustadz(R.drawable.ustadz_1, "Ust.Hanan A", "Bandung"));
        listmenu.add(new Ustadz(R.drawable.ustadz_2, "Ust.Adi H", "Bandung"));
        listmenu.add(new Ustadz(R.drawable.ustadz_3, "Ust.Imam N", "Bandung"));
        listmenu.add(new Ustadz(R.drawable.ustadz_4, "Ust.Evi E", "Bandung"));

        //membuat adapter yang mengubungkan kelas ini dengan data yang ditampilkan
        adapter = new AdapterUstadz(this, listmenu);

        //menghubungkan recyclerview dengan adapter
        rv.setAdapter(adapter);
    }
}


package com.kajian.mobivision.kajiapps;

/**
 * Created by asus a456 on 25/02/2018.
 */


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mobivision.kajiapps.R;

import java.util.List;

public class AdapterKajian extends RecyclerView.Adapter<AdapterKajian.menuholder> {
    //DEKLARASI VARIABEL
    CardView cd;
    private Context context;
    private List<Kajian> listmenu;

    //UNTUK LAYOUT DAFTAR ITEM
    public AdapterKajian(Context context, List<Kajian> listmenu){
        this.context = context;
        this.listmenu = listmenu;
    }

    @Override
    //MENAMPILKAN DATA KE VIEW
    public menuholder onCreateViewHolder(ViewGroup parent, int viewType) {
        //buat view baru
        View view = LayoutInflater.from(context).inflate(R.layout.activity_kajian_cardview, parent, false);
        menuholder holder = new menuholder(view);
        return holder;
    }

    @Override
    //MENGHUBUNGKAN DATA DENGAN POSISINYA
    public void onBindViewHolder (menuholder holder, int position) {
        Kajian data = listmenu.get(position);
        //SET GAMBAR TERLIHAT SEPERTI BACKGROUNDNYA
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            holder.rl.setBackground(holder.rl.getResources().getDrawable(data.getFoto()));
        }
        //MENGISI TAMPILAN DENGAN DATA
        holder.rl.setTag(data.getFoto());
        holder.nama.setText(data.getNama());
        holder.detail.setText(data.getDetail());
    }

    @Override
    //menghitung jumlah data yang akan ditampilkan
    public int getItemCount() {
        return listmenu.size();
    }

    class menuholder extends RecyclerView.ViewHolder{
        //deklarasi variable
        RelativeLayout rl;
        TextView nama, detail;

        public menuholder(View itemView){
            super(itemView);
            //GET ID DARI LAYOUT
            nama = itemView.findViewById(R.id.merk);
            detail = itemView.findViewById(R.id.deskripsi);
            rl = itemView.findViewById(R.id.layout1);

            //JIKA ITEM DIPILIH MAKA:
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //INTENT BARU
                    Intent i = new Intent(context, DetailActivity.class);
                    //NGASIH DAYA KE SCREEN YG DIINTENKAN

                    i.putExtra("nama", nama.getText());
                    i.putExtra("detail", detail.getText());
                    i.putExtra("foto", rl.getTag().toString());
                    //eksekusi intent
                    context.startActivity(i);
                }
            });
        }
    }
}


package mobivision.kajiapps;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class MainActivityKajian extends AppCompatActivity {


    private RecyclerView mKajianList;
    private DatabaseReference mDatabase;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_kajian);




        mDatabase = FirebaseDatabase.getInstance().getReference().child("Kajian");
        mDatabase.keepSynced(true);

        mKajianList = findViewById(R.id.myrecyclerviewkajian);
        mKajianList.setHasFixedSize(true);
        mKajianList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();


        FirebaseRecyclerAdapter<Kajian, KajianViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Kajian, KajianViewHolder>(Kajian.class, R.layout.kajian_row, KajianViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(KajianViewHolder viewHolder, final Kajian model, int position) {
                viewHolder.setJudulkajian(model.getJudulkajian());
                viewHolder.setPenceramahkajian(model.getPenceramahkajian());
                viewHolder.setLokasikajian(model.getLokasikajian());
                viewHolder.setWaktukajian(model.getWaktukajian());
                viewHolder.setPotokajian(getApplicationContext(), model.getPotokajian());
                viewHolder.setDeskripsikajian(model.getDeskripsikajian());



                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(MainActivityKajian.this, DetailActivity.class);

                        i.putExtra("judulkajian", model.getJudulkajian());
                        i.putExtra("penceramahkajian", model.getPenceramahkajian());
                        i.putExtra("lokasikajian", model.getLokasikajian());
                        i.putExtra("waktukajian", model.getWaktukajian());
                        i.putExtra("deskripsikajian", model.getDeskripsikajian());
                        i.putExtra("potokajian", model.getPotokajian());

                        startActivity(i);

                    }
                });




            }

        };




        mKajianList.setAdapter(firebaseRecyclerAdapter);


    }





    public static class KajianViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public KajianViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setJudulkajian(String judul) {
            TextView vjudul = (TextView) mView.findViewById(R.id.vnamakajian);
            vjudul.setText(judul);
        }

        public void setPenceramahkajian(String penceramah) {
            TextView vpenceramah = (TextView) mView.findViewById(R.id.vpenceramah);
            vpenceramah.setText(penceramah);
        }

        public void setLokasikajian(String lokasi) {
            TextView vlokasi = (TextView) mView.findViewById(R.id.vlokasikajian);
            vlokasi.setText(lokasi);
        }


        public void setWaktukajian(String waktu) {
            TextView vwaktu = (TextView) mView.findViewById(R.id.vwaktukajian);
            vwaktu.setText(waktu);
        }

        public void setDeskripsikajian(String deskripsi) {
            TextView vdeskripsi = (TextView) mView.findViewById(R.id.vdeskripsi);
            vdeskripsi.setText(deskripsi);
        }


        public void setPotokajian(Context context, String potokajian) {
            ImageView vpotokajian = (ImageView) mView.findViewById(R.id.vpotokajian);
            Picasso.with(context).load(potokajian).into(vpotokajian);
        }



    }
}
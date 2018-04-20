package mobivision.kajiapps;

import android.content.Context;
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

public class MainActivityUstadz extends AppCompatActivity {

    private RecyclerView mUstadzList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ustadz);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Ustadz");
        mDatabase.keepSynced(true);

        mUstadzList = findViewById(R.id.myrecyclerview);
        mUstadzList.setHasFixedSize(true);
        mUstadzList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Ustadz, UstadzViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Ustadz, UstadzViewHolder>(Ustadz.class, R.layout.ustadz_row, UstadzViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(UstadzViewHolder viewHolder, Ustadz model, int position) {
                viewHolder.setNama(model.getNama());
                viewHolder.setAsal(model.getAsal());
                viewHolder.setEmail(model.getEmail());
                viewHolder.setBio(model.getBio());
                viewHolder.setPoto(getApplicationContext(),model.getPoto());


            }
        };

        mUstadzList.setAdapter(firebaseRecyclerAdapter);


    }


    public static class UstadzViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public UstadzViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }
        public void setNama(String nama)
        {
            TextView vnama = (TextView)mView.findViewById(R.id.vnama);
            vnama.setText(nama);
        }

        public void setEmail(String email)
        {
            TextView vemail = (TextView)mView.findViewById(R.id.vemail);
            vemail.setText(email);
        }

        public void setAsal(String asal)
        {
            TextView vasal = (TextView)mView.findViewById(R.id.vasal);
            vasal.setText(asal);
        }


        public void setBio(String bio)
        {
            TextView vbio = (TextView)mView.findViewById(R.id.vbio);
            vbio.setText(bio);
        }


        public void setPoto(Context context, String poto)
        {
            ImageView vpoto = (ImageView)mView.findViewById(R.id.vpoto);
            Picasso.with(context).load(poto).into(vpoto);
        }




    }
}

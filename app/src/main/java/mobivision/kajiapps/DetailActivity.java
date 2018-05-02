package mobivision.kajiapps;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//public class DetailActivity extends AppCompatActivity {
//
//
//    ImageView mpotokajian;
//    TextView mjudulkajian,mpenceramahkajian,mlokasikajian,mwaktukajian;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail);
//
//        mpotokajian = findViewById(R.id.vpotokajian);
//        mjudulkajian =findViewById(R.id.vnamakajian);
//        mpenceramahkajian = findViewById(R.id.vpenceramah);
//        mlokasikajian = findViewById(R.id.vlokasikajian);
//        mwaktukajian = findViewById(R.id.vwaktukajian);
//
//
//        //GET INTENT
//        Intent i=this.getIntent();
//
//        //RECEIVE DATA
//        String judul=i.getExtras().getString("judulkajian");
//        String penceramah=i.getExtras().getString("penceramahkajian");
//        String lokasi=i.getExtras().getString("lokasikajian");
//        String waktu=i.getExtras().getString("waktukajian");
//        String poto=i.getExtras().getString("potokajian");
//
//        //BIND DATA
//        mjudulkajian.setText(judul);
//        mpenceramahkajian.setText(penceramah);
//        mlokasikajian.setText(lokasi);
//        mwaktukajian.setText(waktu);
//        mpotokajian.setImageResource(Integer.parseInt(poto));
//
//
//
//    }
//
//
//
//
//}


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;


public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {
    ImageView mpotokajian;
    TextView mjudulkajian, mpenceramahkajian, mlokasikajian, mwaktukajian;
    String judulkajian, penceramah, lokasi, waktu, poto;
    private GoogleMap mMap;

    Button mbtBagikan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        mpotokajian = findViewById(R.id.vpotokajian);
        mjudulkajian = findViewById(R.id.vnamakajian);
        mpenceramahkajian = findViewById(R.id.vpenceramah);
        mlokasikajian = findViewById(R.id.vlokasikajian);
        mwaktukajian = findViewById(R.id.vwaktukajian);

        //get data dari activity sebelumnya
        getBundle();

        //set ke textview
        mjudulkajian.setText(judulkajian);
        mpenceramahkajian.setText(penceramah);
        mlokasikajian.setText(lokasi);
        mwaktukajian.setText(waktu);
        Picasso.with(DetailActivity.this).load(poto).into(mpotokajian);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        //sharing
        mbtBagikan = findViewById(R.id.btBagikan);

        mbtBagikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Share text
                String getText =
                        "[INFO KAJIAN] " + "\n"+
                        "Judul Kajian : "+ mjudulkajian.getText().toString() + "\n"
                        +"Penceramah :"+mpenceramahkajian.getText().toString() + "\n"
                        +"Waktu : "+ mwaktukajian.getText().toString() + "\n"
                        +"Tempat : "+ mlokasikajian.getText().toString() + "\n"
                        +"sumber : kajiapps ";


                if (!getText.equals("") && getText.length() != 0) shareText(getText);
                else
                    Toast.makeText(DetailActivity.this, "Ketikkan sesuatu ...", Toast.LENGTH_SHORT).show();


            }
        });
    }

    //get data dari activity sebelumnya
    private void getBundle() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            judulkajian = extras.getString("judulkajian");
            penceramah = extras.getString("penceramahkajian");
            lokasi = extras.getString("lokasikajian");
            waktu = extras.getString("waktukajian");
            poto = extras.getString("potokajian");
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-6.9078961, 107.6275705);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Masjid Al Lathief - \n" + "Jl. Saninten No.2, Cihapit, Bandung Wetan, Kota Bandung, Jawa Barat 40114"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 45));
    }


    private void shareText(String text) {

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");// Plain format text

        // You can add subject also
        /*
		 * sharingIntent.putExtra( android.content.Intent.EXTRA_SUBJECT,
		 * "Subject Here");
		 */
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, text);
        startActivity(Intent.createChooser(sharingIntent, "Bagikan info kajian"));
    }


}
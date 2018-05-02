package mobivision.kajiapps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.appinvite.AppInviteInvitation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.text.TextUtils.isEmpty;

public class SedekahOnlineActivity extends AppCompatActivity {

    private DatabaseReference database;

    private Button mbt_lanjut;
    private EditText etEmail,etNominal, etKomentar, etBank;
    private RadioGroup mRadiogroup;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sedekah_online);

        etEmail = findViewById(R.id.et_email);
        etNominal = findViewById(R.id.et_nominal);
        etKomentar = findViewById(R.id.et_komentar);
        etBank = findViewById(R.id.et_bank);

        mbt_lanjut = findViewById(R.id.bt_lanjut);
        mRadiogroup = findViewById(R.id.rg_bank);




        // mengambil referensi ke Firebase Database
        database = FirebaseDatabase.getInstance().getReference();


        // kode yang dipanggil ketika tombol Submit diklik
        mbt_lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //untuk radiogroup
                int selectedRadioButtonID = mRadiogroup.getCheckedRadioButtonId();

                // If nothing is selected from Radio Group, then it return -1
                if (selectedRadioButtonID != -1) {

                    RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                    String selectedRadioButtonText = selectedRadioButton.getText().toString();

                    etBank.setText(selectedRadioButtonText);

                }
                else{
                    etBank.setText("");
                }

                //end radio group


                if(!isEmpty(etNominal.getText().toString()) && !isEmpty(etEmail.getText().toString()) )
                    submitSedekah(new Sedekah(etEmail.getText().toString(),etNominal.getText().toString(), etKomentar.getText().toString(), etBank.getText().toString()));
                else
                    Snackbar.make(findViewById(R.id.bt_lanjut), "Data sedekah tidak boleh kosong", Snackbar.LENGTH_LONG).show();

                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(
                        etNominal.getWindowToken(), 0);
            }
        });



    }

    private boolean isEmpty(String s) {
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }





    private void submitSedekah(Sedekah sedekah) {
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
         * ketika data berhasil ditambahkan
         */
        database.child("Sedekah").push().setValue(sedekah).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etEmail.setText("");
                etNominal.setText("");
                etKomentar.setText("");
                etBank.setText("");



                Snackbar.make(findViewById(R.id.bt_lanjut), "Sedekah berhasil tercatat", Snackbar.LENGTH_LONG).show();





            }
        });
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, SedekahOnlineActivity.class);
    }




}



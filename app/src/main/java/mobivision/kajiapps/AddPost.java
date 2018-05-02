package mobivision.kajiapps;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import mobivision.kajiapps.model.Post;
import mobivision.kajiapps.model.User;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.util.Calendar;


public class AddPost extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;

    EditText mTitlePost, mPost, mUstadzPengisi, mWaktu;
    Spinner mLokasi;
    ImageView imageView;
    Button mChooseImage;
    //our database reference object
    DatabaseReference databaseFood,databaseFood2;
    DatabaseReference databaseUstadz;
    FirebaseAuth mAuth;

    private Uri imageUri;

    private StorageReference mStorage, mStorage2;
    Query databaseUser;


    //Variabel untuk datepicker
    EditText date;
    DatePickerDialog datePickerDialog;

    //Spinner
    Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        imageUri = null;

        mAuth = FirebaseAuth.getInstance();

        mStorage = FirebaseStorage.getInstance().getReference().child("images");

        mStorage2 = FirebaseStorage.getInstance().getReference().child("Ustadz");

        databaseFood = FirebaseDatabase.getInstance().getReference(MainActivity.table1);

        databaseFood2 = FirebaseDatabase.getInstance().getReference("Kajian");

        databaseUser = FirebaseDatabase.getInstance().getReference(MainActivity.table3);


        //Referensi Inputan dari view
        mTitlePost = (EditText) findViewById(R.id.et_title_post);
        mPost = (EditText) findViewById(R.id.et_post); //deksripsi
        imageView = findViewById(R.id.img_post);
        mUstadzPengisi = findViewById(R.id.et_ustadz_post);
        mLokasi = findViewById(R.id.et_lokasi_post);
        //mWaktu = findViewById(R.id.et_waktu_post);


        //Referensi untuk datapicker
        date = (EditText) findViewById(R.id.date);

        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(AddPost.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);


                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        mChooseImage = findViewById(R.id.btn_choose_image);
        mChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });

        //adapter untuk spinner
        //set Adapter Spinner
        String itemSpinner[]    = {"Masjid Al Lathief","Masjid Habiburahman","Masjid Raya Kota Bandung","Masjid Al Irsyad"};

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner_item, itemSpinner);

        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mLokasi.setAdapter(spinnerArrayAdapter);

        mLokasi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mLokasi.setOnItemSelectedListener(this);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void add(View view) {

        databaseUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                FirebaseUser cur_user = mAuth.getCurrentUser();

                final User user = dataSnapshot.child(cur_user.getUid()).getValue(User.class);

                final String name = user.getUsername();

                final String title = mTitlePost.getText().toString();
                final String judulkajian = mTitlePost.getText().toString();

                final String postMessage = mPost.getText().toString();
                final String deskripsikajian = mPost.getText().toString();


                final String ustadzPengisi = mUstadzPengisi.getText().toString();
                final String penceramahkajian = mUstadzPengisi.getText().toString();


                final String lokasiKajian = mLokasi.getSelectedItem().toString();
                final String lokasikajian = mLokasi.getSelectedItem().toString();

                final String waktuKajian = date.getText().toString();
                final String waktukajian = date.getText().toString();


                final String id = databaseFood.push().getKey();
                final String userId = cur_user.getUid();
                final long timestamp = System.currentTimeMillis();


                if (imageUri != null && !TextUtils.isEmpty(name)) {

                    final StorageReference image = mStorage.child(id + ".jpg");

                    image.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> uploadTask) {

                            if (uploadTask.isSuccessful()) {

                                String download_url = uploadTask.getResult().getDownloadUrl().toString();
                                String potokajian = uploadTask.getResult().getDownloadUrl().toString();

//                                Post post = new Post(id, userId, name, download_url, title, postMessage, mUstadzPengisi, mLokasi, mWaktu, 0 - timestamp);
//                                databaseFood.child(id).setValue(post);

                                Post post = new Post(id, userId, name, download_url, title, postMessage, ustadzPengisi, lokasiKajian, waktuKajian, 0 - timestamp);
                                databaseFood.child(id).setValue(post);


                                Kajian kajian = new Kajian(potokajian,judulkajian, lokasikajian, penceramahkajian, deskripsikajian,waktukajian);
                                databaseFood2.child(id).setValue(kajian);

                            } else {
                                Toast.makeText(AddPost.this, "Error : " + uploadTask.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                    //displaying a success toast
                    Toast.makeText(AddPost.this, "Uploaded", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(AddPost.this, MainActivity.class);
                    startActivity(i);
                } else {
                    //if the value is not given displaying a toast
                    Toast.makeText(AddPost.this, "Please Fill the form and choose image", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }


}

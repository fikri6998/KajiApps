package mobivision.kajiapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Profil extends AppCompatActivity {
    TextView mtvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        mtvEmail = findViewById(R.id.tv_email);



        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in

            String email = user.getEmail();
            String uid = user.getUid();






            FirebaseDatabase database = FirebaseDatabase.getInstance();
            String key = database.getReference("users").push().getKey();

            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put( "uid", uid);
            childUpdates.put( "name", email);
            // other properties here

            mtvEmail.setText(email);


            database.getReference("users").updateChildren(childUpdates, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError == null) {

                    }
                }
            });
        }
    }
}

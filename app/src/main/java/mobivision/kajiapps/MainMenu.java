package mobivision.kajiapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    Button mbtKajian, mbtUstadz, mbtSedekah, mbtSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main_menu);

        mbtKajian = findViewById(R.id.bt_infokajian);
        mbtKajian = findViewById(R.id.bt_infoustadz);
        mbtSedekah = findViewById(R.id.bt_infosedekah);
        mbtSignin = findViewById(R.id.btlogin);
    }

    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_infokajian:
                //do ur code
                Toast.makeText(this, "Info Kajian", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivityKajian.class);
                startActivity(intent);
                break;

            case R.id.bt_infoustadz:
                intent = new Intent(this, MainActivityUstadz.class);
                startActivity(intent);
                break;
            case R.id.bt_infosedekah:
                intent = new Intent(this, SedekahOnlineActivity.class);
                startActivity(intent);

                break;
            case R.id.btlogin:
                //do ur code;
                intent = new Intent(this, Login.class);
                startActivity(intent);
                break;
            case R.id.btsignup:
                //do ur code;
                intent = new Intent(this, Login.class);
                startActivity(intent);
                break;
            default:
                //do ur code;
                intent = new Intent(this, MainMenu.class);
                startActivity(intent);
        }
    }
}

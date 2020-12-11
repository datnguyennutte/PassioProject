package datnguyen.lab.passioproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import datnguyen.lab.passioproject.R;

public class WelcomeActivity extends AppCompatActivity {
    Button btn_login_phone_107, btn_login_fb_107;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        btn_login_fb_107 = findViewById(R.id.btn_login_byfb_107);
        btn_login_phone_107 = findViewById(R.id.btn_login_byphone_107);
        btn_login_phone_107.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, PhoneLoginActivity.class));
                finish();
            }
        });
        btn_login_fb_107.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
                finish();
            }
        });
    }
}
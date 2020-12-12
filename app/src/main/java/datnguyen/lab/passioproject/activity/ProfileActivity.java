package datnguyen.lab.passioproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import datnguyen.lab.passioproject.R;

public class ProfileActivity extends AppCompatActivity {
    ImageView img_back_home_107;
    TextView tv_logout_107;
    LinearLayout layout_detail_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        img_back_home_107 = findViewById(R.id.img_back_107);
        tv_logout_107 = findViewById(R.id.tv_log_out_107);
        layout_detail_profile = findViewById(R.id.layout_profile_107);
        layout_detail_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, DetailProfileActivity.class));
            }
        });

        tv_logout_107.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finish();
            }
        });

        img_back_home_107.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
            }
        });
    }
}
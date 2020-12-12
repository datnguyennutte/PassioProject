package datnguyen.lab.passioproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import datnguyen.lab.passioproject.R;

public class DetailProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_profile);
    }

    public void back_homepage(View view) {
        DetailProfileActivity.super.onBackPressed();
    }
}
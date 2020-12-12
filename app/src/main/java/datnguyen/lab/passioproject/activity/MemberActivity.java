package datnguyen.lab.passioproject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import datnguyen.lab.passioproject.R;
import datnguyen.lab.passioproject.adapter.AdapterViewPagerLevel;

public class MemberActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mviewPager;
    private ImageView imgBackofTheTV;
    private TextView tvXemCoupon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        mviewPager = findViewById(R.id.view_pager_thetv);
        mTabLayout = findViewById(R.id.tab_layout_thetv);

        imgBackofTheTV = findViewById(R.id.img_back_of_thetv);
        imgBackofTheTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemberActivity.super.onBackPressed();
            }
        });

        tvXemCoupon = findViewById(R.id.tv_thetv_coupon);
        tvXemCoupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MemberActivity.this, GiftActivity.class);
                startActivity(i);
            }
        });

        AdapterViewPagerLevel adapterViewPagerLevel = new AdapterViewPagerLevel(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mviewPager.setAdapter(adapterViewPagerLevel);

        mTabLayout.setupWithViewPager(mviewPager);
    }
}

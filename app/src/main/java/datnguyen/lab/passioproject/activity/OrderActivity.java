package datnguyen.lab.passioproject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import datnguyen.lab.passioproject.R;
import datnguyen.lab.passioproject.adapter.ViewOrderAdapter;
import datnguyen.lab.passioproject.fragment.FreshEasyFragment;
import datnguyen.lab.passioproject.fragment.GreenxmasFragment;
import datnguyen.lab.passioproject.fragment.IceBlendedFragment;
import datnguyen.lab.passioproject.fragment.PassioCoffeeFragment;
import datnguyen.lab.passioproject.fragment.TeadSodaFragment;

public class OrderActivity extends AppCompatActivity {
    private TabLayout tabLayout_107;
    private ViewPager viewPager_107;
    private ViewOrderAdapter orderAdapter_107;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tabLayout_107 = findViewById(R.id.drink_tab_107);
        viewPager_107 = findViewById(R.id.viewPager_drink_item_107);

        orderAdapter_107 = new ViewOrderAdapter(getSupportFragmentManager());


        orderAdapter_107.AddFragment(new GreenxmasFragment(), "Green xmas");
        orderAdapter_107.AddFragment(new IceBlendedFragment(), "Ice blended");
        orderAdapter_107.AddFragment(new TeadSodaFragment(), "Tea/coffee");
        orderAdapter_107.AddFragment(new PassioCoffeeFragment(), "Passio coffee");
        orderAdapter_107.AddFragment(new FreshEasyFragment(), "Fresh & easy");

        viewPager_107.setAdapter(orderAdapter_107);
        tabLayout_107.setupWithViewPager(viewPager_107);
    }

    public void back_homepage(View view) {
        startActivity(new Intent(OrderActivity.this, HomeActivity.class));
        finish();
    }
}
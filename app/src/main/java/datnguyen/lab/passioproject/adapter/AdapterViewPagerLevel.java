package datnguyen.lab.passioproject.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import datnguyen.lab.passioproject.fragment.GoldMemberFragment;
import datnguyen.lab.passioproject.fragment.PlatinumMemberFragment;
import datnguyen.lab.passioproject.fragment.SilverMemberFragment;

public class AdapterViewPagerLevel extends FragmentStatePagerAdapter {
    public AdapterViewPagerLevel(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SilverMemberFragment();
            case 1:
                return new GoldMemberFragment();
            case 2:
                return new PlatinumMemberFragment();
            default:
                return new SilverMemberFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Sliver";
                break;
            case 1:
                title = "Gold";
                break;
            case 2:
                title = "Platinum";
                break;
        }
        return title;
    }
}
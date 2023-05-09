package com.ataide.viewpage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ataide.viewpage.fragments.HomeFragment;
import com.ataide.viewpage.fragments.SettingsFragment;
import com.ataide.viewpage.fragments.UserFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    //Construtor para o view pageAdapter
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        //Permite a troca de fragments no viewpage
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new UserFragment();
            case 2:
                return new SettingsFragment();
            default:
                return new HomeFragment();
        }
    }

    //numero de fragmentos
    @Override
    public int getItemCount() {
        return 3;
    }
}

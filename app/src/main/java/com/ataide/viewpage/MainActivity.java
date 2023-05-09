package com.ataide.viewpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.ataide.viewpage.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    //binding e objecto da classe adapter
    private ActivityMainBinding mainBinding;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        //Instanciar objecto viewPageAdapter
        adapter = new ViewPagerAdapter(this);

        //Set adapter ao ViewPage do Activity main
        mainBinding.viewPage.setAdapter(adapter);

        //Event Listner ao selecionar um item do tabLayout
        mainBinding.tabLayout.addOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        //Devolve o item selecionado
                        mainBinding.viewPage.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {}
                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {}
                }
        );

        //Adicionar um pageSelected Callback metodo
        mainBinding.viewPage.registerOnPageChangeCallback(
                new ViewPager2.OnPageChangeCallback() {
                    @Override
                    public void onPageSelected(int position) {
                        super.onPageSelected(position);

                        //vamos fazer o set da posição no tab layout
                        mainBinding.tabLayout.getTabAt(position).select();
                    }
                }
        );
    }
}
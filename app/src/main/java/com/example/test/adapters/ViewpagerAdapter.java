package com.example.test.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.test.fragments.FragmentNames;
import com.example.test.fragments.NameDescription;

import java.util.ArrayList;

public class ViewpagerAdapter extends FragmentStateAdapter {
public ViewpagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle){

    super(fragmentManager, lifecycle);
}


    @NonNull
    @Override
    public Fragment createFragment(int position) {
      switch (position){
          case 0:
              return new FragmentNames();

          case 1:
              return new NameDescription();




      }



        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

package com.sunlightfoundation.congressinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ganmanisekar on 11/16/16.
 */
public class CommTabFragment extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3 ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View x =  inflater.inflate(R.layout.comm_tab_layout,null);
        tabLayout = (TabLayout) x.findViewById(R.id.comm_tabs);
        viewPager = (ViewPager) x.findViewById(R.id.comm_viewpager);


        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));



        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return x;

    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {

            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new Committee();
                case 1 : return new CommitteeSenate();
                case 2 : return new CommitteeJoint();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "House";
                case 1 :
                    return "Senate";
                case 2 :
                    return "Joint";
            }
            return null;
        }
    }
}

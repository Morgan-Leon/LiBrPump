package lyn.librpump.adapter;

/**
 * Created by lyn on 16/4/17.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import lyn.librpump.fragment.CalCOPFragment;
import lyn.librpump.fragment.CalLiBrFragment;
import lyn.librpump.fragment.PumpFragment;
import lyn.librpump.fragment.TabFragment;

public class TabAdapter extends FragmentPagerAdapter
{
//    CalCOPFragment calCOPFragment;
//    CalLiBrFragment calLiBrFragment;
//    PumpFragment pumpFragment;
    private List<Fragment> fragmentList;


    public static String[] TITLES = new String[]
            { "计算", "热泵", "溴化锂" ,"item"};

    public TabAdapter(FragmentManager fm, List<Fragment> fragmentList)
    {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int arg0)
    {
        return fragmentList.get(arg0);
    }

    @Override
    public int getCount()
    {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return TITLES[position];
    }

}

package sv.com.lyckan.cuentameuncuento;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sv.com.lyckan.cuentameuncuento.adapter.ReadPageAdapter;

public class ReadFragmentActivity extends FragmentActivity {

    int numPages = 1;
    ReadPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_fragment);
        numPages = getIntent().getIntExtra("chapters", 0);
        List<Fragment> fragments = getFragments();
        pageAdapter = new ReadPageAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(pageAdapter);
    }

    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(ScreenSlidePageFragment.newInstance("Fragment 1"));
        fList.add(ScreenSlidePageFragment.newInstance("Fragment 2"));
        fList.add(ScreenSlidePageFragment.newInstance("Fragment 3"));
        return fList;
    }


}

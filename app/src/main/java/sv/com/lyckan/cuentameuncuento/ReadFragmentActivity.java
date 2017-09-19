package sv.com.lyckan.cuentameuncuento;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sv.com.lyckan.cuentameuncuento.adapter.ReadPageAdapter;
import sv.com.lyckan.cuentameuncuento.pojos.Chapter;
import sv.com.lyckan.cuentameuncuento.pojos.SelectHistory;
import sv.com.lyckan.cuentameuncuento.webservice.ApiController;

public class ReadFragmentActivity extends FragmentActivity {

    ReadPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_fragment);
        getData();
    }

    private List<Fragment> getFragments(List<Chapter> chapters) {
        List<Fragment> fList = new ArrayList<Fragment>();
        int pos = 1;
        for(Chapter chapter: chapters){
            String txt = pos+"/"+ chapters.size() ;
            fList.add(ScreenSlidePageFragment.newInstance(chapter.getImage(), chapter.getBody(), txt));
            pos++;
        }

        return fList;
    }

    private void getData(){

        ApiController ctr = new ApiController();
        ApiController.Controller controller = ctr.getHistorySelected("");

        controller.getHistory().enqueue(new Callback<SelectHistory>() {
            @Override
            public void onResponse(Call<SelectHistory> call, Response<SelectHistory> response) {
                List<Fragment> fragments = getFragments(response.body().getChapters());
                pageAdapter = new ReadPageAdapter(getSupportFragmentManager(), fragments);
                ViewPager pager = (ViewPager)findViewById(R.id.pager);
                pager.setAdapter(pageAdapter);
            }

            @Override
            public void onFailure(Call<SelectHistory> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


}

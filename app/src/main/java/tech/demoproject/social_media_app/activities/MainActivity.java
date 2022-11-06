package tech.demoproject.social_media_app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import tech.demoproject.social_media_app.R;
import tech.demoproject.social_media_app.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setup();
    }
    private void init() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

    }
    private void setup() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);
        //set up for Tab Layout
        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> {
            switch (position){
                case 0:
                    // fragment home
                    tab.setIcon(R.drawable.ic_home_50);
                    break;
                case 1:
                    // fragment profile
                    tab.setIcon(R.drawable.ic_user);
                    break;
                case 2:
                    // fragment search
                    tab.setIcon(R.drawable.ic_search_50);
                    break;
                case 3:
                    // fragment setting
                    tab.setIcon(R.drawable.ic_setting);
                    break;
            }
        })).attach();
    }
}
package com.honeysha_tech.vrihad;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class activity_intro extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    ImageView btnNext,btnGetStarted;
    int position = 0;
    TextView tvSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     /*   if (restorePrefData()) {
            Intent mainActivity = new Intent(getApplicationContext(),interested_topics.class );
            startActivity(mainActivity);
            finish();
        }*/
        setContentView(R.layout.activity_intro);
        Window window = activity_intro.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(activity_intro.this, R.color.bg_color));
        // ini views
        btnNext = findViewById(R.id.next);
        btnGetStarted = findViewById(R.id.getstarted);
        tabIndicator = findViewById(R.id.tab_indicator);
        tvSkip = findViewById(R.id.tv_skip);

        //upar bar same color


        // fill list screen
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("EXPLORE", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ", R.drawable.ic_welcome));
        mList.add(new ScreenItem("WIN PRIZES", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ", R.drawable.ic_treasure));
        mList.add(new ScreenItem("LEARN", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ", R.drawable.ic_welcome));
        // setup viewpager
        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);
        // setup tablayout with viewpager
        tabIndicator.setupWithViewPager(screenPager);


        // next button click Listner
        btnNext.setOnClickListener(v -> {

            position = screenPager.getCurrentItem();
            if (position < mList.size()) {
                position++;
                screenPager.setCurrentItem(position);
            }
            if (position == mList.size() - 1) { // when we rech to the last screen
                // TODO : show the GETSTARTED Button and hide the indicator and the next button
                loaddLastScreen();
            }
        });
        // tablayout add change listener
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size() - 1) {
                    loaddLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        // skip button click listener
        tvSkip.setOnClickListener(v -> {
            screenPager.setCurrentItem(mList.size());
            //savePrefsData();
            //hkk
        });
        btnGetStarted.setOnClickListener(v -> {
            screenPager.setCurrentItem(mList.size());
            //savePrefsData();
            Intent intent = new Intent(activity_intro.this,LoginScreen.class);
            startActivity(intent);
            finish();
        });

    }


   /* private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        return pref.getBoolean("isIntroOpnend", false);
    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend", true);
        editor.apply();
    }*/

    // show the GETSTARTED Button and hide the indicator and the next button
    private void loaddLastScreen() {
        btnNext.setVisibility(View.GONE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tvSkip.setVisibility(View.INVISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        // TODO : ADD an animation the getstarted button
        // setup animation
        //btnGetStarted.setAnimation(btnAnim);
    }

}
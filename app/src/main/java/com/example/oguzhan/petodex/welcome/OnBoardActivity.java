package com.example.oguzhan.petodex.welcome;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.oguzhan.petodex.R;

import adapter.SlideAdapter;

public class OnBoardActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private SlideAdapter slideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        initComponents();
        slideAdapter = new SlideAdapter(this);
        mSlideViewPager.setAdapter(slideAdapter);
        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);


    }

    private void addDotsIndicator(int position) {

        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));//bullet html code
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorWelcome));
            mDotLayout.addView(mDots[i]);


        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorAccent));


        }


    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private void initComponents() {

        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dotsLayout);

    }










}

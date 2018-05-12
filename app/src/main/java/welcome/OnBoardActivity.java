package welcome;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.oguzhan.petodex.R;

import adapter.SlideAdapter;
import user.LoginActivity;

public class OnBoardActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private SlideAdapter slideAdapter;
    private Button mButtonNext;
    private Button mButtonPre;
    private int currentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        initComponents();
        registerEventHandlers();
        slideAdapter = new SlideAdapter(this);
        mSlideViewPager.setAdapter(slideAdapter);
        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);


    }

    private void registerEventHandlers() {
        mButtonPre_onClick();
        mButtonNext_onClick();

    }

    private void mButtonNext_onClick() {

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mButtonNext.getText().toString() == getString(R.string.finish)) {

// new activity to do anything

                    Intent intent = new Intent(OnBoardActivity.this, LoginActivity.class);
                    startActivity(intent);

                }

                mSlideViewPager.setCurrentItem(currentPage + 1);


            }
        });

    }

    private void mButtonPre_onClick() {
        mButtonPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSlideViewPager.setCurrentItem(currentPage - 1);

            }
        });


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
            currentPage = i;

            if (i == 0) {


                mButtonNext.setEnabled(true);
                mButtonPre.setEnabled(false);
                mButtonPre.setVisibility(View.INVISIBLE);

                mButtonNext.setText(R.string.next);
                mButtonPre.setText("");
            } else if (i == mDots.length - 1) {

                mButtonNext.setEnabled(false);
                mButtonPre.setEnabled(true);
                mButtonPre.setVisibility(View.VISIBLE);

                mButtonNext.setText(R.string.finish);
                mButtonPre.setText(R.string.pre);


            } else {

                mButtonNext.setEnabled(true);
                mButtonPre.setEnabled(true);
                mButtonPre.setVisibility(View.VISIBLE);

                mButtonNext.setText(R.string.next);
                mButtonPre.setText(R.string.pre);

            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void initComponents() {

        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dotsLayout);
        mButtonNext = findViewById(R.id.nextButton);
        mButtonPre = findViewById(R.id.preButton);

    }


}

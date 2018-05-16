package com.example.oguzhan.petodex.welcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oguzhan.petodex.R;

public class SplashActivity extends AppCompatActivity {

    private TextView splashTextApp;
    private ImageView splashImageView;
    private TextView splashTextTour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initComponents();
        registerEventHandlers();
        Animation anim = new AnimationUtils().loadAnimation(this, R.anim.splashscreentransition);
        splashImageView.startAnimation(anim);
        splashTextApp.startAnimation(anim);
    }


    private void registerEventHandlers() {
        textViewSplashTour_onClick();
    }

    private void initComponents() {
        splashTextApp = findViewById(R.id.textViewSplash);
        splashImageView = findViewById(R.id.imageViewSplash);
        splashTextTour =findViewById(R.id.textViewSplashTour);
    }

    private void textViewSplashTour_onClick() {
        splashTextTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SplashActivity.this, OnBoardActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }
}

package com.arif.wifilist.Util;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.arif.wifilist.MainList;
import com.arif.wifilist.R;

import static android.view.View.VISIBLE;

public class SplashScreen extends AppCompatActivity {

    private ImageView splash2_imageView;
    private TextView splash2_textView_hosgeldin, splash2_textView_hosgeldin_aciklama;
    private Button splash2_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity___splash_screen2);

        //
        splash2_imageView = (ImageView)findViewById(R.id.splash2_imageView);
        splash2_textView_hosgeldin = (TextView)findViewById(R.id.splash2_textView_hosgeldin);
        splash2_textView_hosgeldin_aciklama = (TextView)findViewById(R.id.splash2_textView_hosgeldin_aciklama);
        splash2_button = (Button)findViewById(R.id.splash2_button);
        //

        splash2_textView_hosgeldin.setVisibility(View.INVISIBLE);

        //Hide action bar for splash
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Animations
        moveLogo();
        moveText();
        moveButton();

        splash2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashScreen.this, MainList.class));
            }
        });
    }

    public void moveLogo(){

        Animation logoAnimation = new TranslateAnimation(0, 0, -900,160);
        logoAnimation.setDuration(800);
        logoAnimation.setFillAfter(true);

        splash2_imageView.startAnimation(logoAnimation);

    }

    public void moveText(){

        AlphaAnimation animation1 = new AlphaAnimation(0.2f, 1.0f);
        animation1.setDuration(800);
        splash2_textView_hosgeldin.setAlpha(1f);
        splash2_textView_hosgeldin.startAnimation(animation1);
        splash2_textView_hosgeldin.setVisibility(VISIBLE);

    }

    public void moveButton(){
        Animation buttonAnimation = new TranslateAnimation(0, 0, 700,50);
        buttonAnimation.setDuration(800);
        buttonAnimation.setFillAfter(true);
        splash2_button.startAnimation(buttonAnimation);
    }

    public void moveText_leftToRight(){
        Animation textSideAnimation = new TranslateAnimation(-1300, 0, 0,0);
        textSideAnimation.setDuration(800);
        textSideAnimation.setFillAfter(true);

        splash2_textView_hosgeldin.startAnimation(textSideAnimation);

    }

    public void moveText_rightToLeft(){
        Animation textSideAnimation = new TranslateAnimation(1300, 0, 0,0);
        textSideAnimation.setDuration(800);
        textSideAnimation.setFillAfter(true);

        splash2_textView_hosgeldin_aciklama.startAnimation(textSideAnimation);

    }

}

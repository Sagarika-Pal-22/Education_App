package com.example.education_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash_Activity extends AppCompatActivity {

    ImageView img_app_logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        img_app_logo =findViewById(R.id.img_app_logo);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        img_app_logo.startAnimation(animation);

        Thread timer = new Thread(){

            @Override
            public void run() {

                try {
                    sleep(7000);
                    startActivity(new Intent(Splash_Activity.this,Login_Activity.class));
                    finish();
                    super.run();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        };
        timer.start();
    }
}
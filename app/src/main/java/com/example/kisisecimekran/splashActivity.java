package com.example.kisisecimekran;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread titleAnimation =new Thread(){
            @Override
            public void run(){
                TextView logo=findViewById(R.id.labelTitle);
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_intro_author);
                logo.startAnimation(animation);
            }
        };
        titleAnimation.start();
        Thread authorAnimation=new Thread(){
            @Override
            public void run(){
                TextView author=findViewById(R.id.labelAuthor);
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_intro_author);
                author.startAnimation(animation);
            }
        };
        authorAnimation.start();
        Thread redirect=new Thread(){
            @Override
            public void run(){
                try{
                    sleep(2000);
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                    super.run();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        redirect.start();
    }
}
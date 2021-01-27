package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Context context = this;
    MediaPlayer mp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button buttonz;
        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);

        buttonz = (Button) findViewById(R.id.button3);


        buttonz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp2 = MediaPlayer.create(context, R.raw.padoru);
                try{
                    if (mp2.isPlaying()){
                        mp2.stop();
                        mp2.release();
                        mp2 = MediaPlayer.create(context, R.raw.padoru);
                    }
                    mp2.start();
                }
                catch (Exception e){e.printStackTrace();}

                buttonz.startAnimation(animRotate);
            }
        });


    }
}
/*
buttonk = (Button)  findViewById(R.id.back);

        buttonk.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent intent2 = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent2);
        }
        });
        */
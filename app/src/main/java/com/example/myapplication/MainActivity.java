package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int mCounter = 0 ;
    Context context = this;
    MediaPlayer mp ;
    Button buttonx;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonv;
        TextView textViewv;
        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);


        buttonv = (Button) findViewById(R.id.button);
        textViewv = (TextView) findViewById(R.id.textView);
        buttonx = (Button) findViewById(R.id.button2);


        buttonx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);

            }
        });

        buttonv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences prefs = getSharedPreferences("mCounter", 0);
                int value = prefs.getInt("mCounter", 0);
                prefs.edit().putInt("mCounter", (value+1)).apply();

                prefs.edit().putInt("mCounter", (value+1)).apply();
                int refreshedValue = prefs.getInt("mCounter", 0);


                textViewv.setText( String.valueOf(refreshedValue));



                //textViewv.setText(Integer.toString(mCounter));
                mp = MediaPlayer.create(context, R.raw.tuturu);

                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context, R.raw.tuturu);
                    }
                    mp.start();
                }
                catch(Exception e){e.printStackTrace();}

                buttonv.startAnimation(animShake);


            }
        });


    }
}
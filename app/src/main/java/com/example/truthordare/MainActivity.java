package com.example.truthordare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button myButton;
    private ImageView myImage;
    Random myRandom = new Random();
    private int lastDirection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = findViewById(R.id.button);
        myImage = findViewById(R.id.imageView);
    }

    public void spinTheBottle(View view)
    {

        int newDirection = myRandom.nextInt(3600); //36000 for spinning with speed like crazy!
        float pivotX = myImage.getWidth()/2;
        float pivotY = myImage.getWidth()/3;
        Animation spin = new RotateAnimation(lastDirection, newDirection, pivotX, pivotX);


        spin.setDuration(4000);
        spin.setFillAfter(true);

        spin.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                myButton.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                myButton.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        lastDirection = newDirection;
        myImage.startAnimation(spin);
    }
}
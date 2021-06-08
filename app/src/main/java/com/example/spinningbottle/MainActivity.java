package com.example.spinningbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView bottle;
    private Random random = new Random();
    private int lastDir;

  private Boolean Spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle = findViewById(R.id.I1);
        Spinning = false;
        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Spinning) {
                    int newDir = random.nextInt(3000);
                    float pivotX = bottle.getWidth() / 2;
                    float pivotY = bottle.getHeight() / 2;
                    Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
                    rotate.setDuration(5000);
                    rotate.setFillAfter(true);
                    rotate.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            Spinning = true;
                        }
                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Spinning = false;
                        }
                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    lastDir = newDir;
                    bottle.startAnimation(rotate);
                }
            }

        });
    }
}


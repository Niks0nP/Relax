package ru.com.relax;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Relaxing_activity extends AppCompatActivity implements View.OnClickListener{

    ImageView button_back, green_circle, red_circle, orange_circle, blue_circle, yellow_circle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relaxing_activity);

        Window g = getWindow();
        g.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        button_back = findViewById(R.id.back_relaxing);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Relaxing_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        green_circle = findViewById(R.id.green_button);
        green_circle.setOnClickListener(this);
        red_circle = findViewById(R.id.red_button);
        red_circle.setOnClickListener(this);
        orange_circle = findViewById(R.id.orange_button);
        orange_circle.setOnClickListener(this);
        blue_circle = findViewById(R.id.blue_button);
        blue_circle.setOnClickListener(this);
        yellow_circle = findViewById(R.id.yellow_button);
        yellow_circle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.button_animation);
        switch(id) {
            case R.id.green_button:
                ButtonInterpolator interpolator1 = new ButtonInterpolator(0.5, 20);
                animation.setInterpolator(interpolator1);
                green_circle.startAnimation(animation);
                green_circle.setColorFilter(Color.argb(255, (int) (Math.random() * ((255) + 1)),
                    (int) (Math.random() * ((255) + 1)), (int) (Math.random() * ((255) + 1))));
            break;
            case R.id.red_button:
                ButtonInterpolator interpolator2 = new ButtonInterpolator(0.2, 10);
                animation.setInterpolator(interpolator2);
                red_circle.startAnimation(animation);
                red_circle.setColorFilter(Color.argb(255, (int) (Math.random() * ((255) + 1)),
                    (int) (Math.random() * ((255) + 1)), (int) (Math.random() * ((255) + 1))));
            break;
            case R.id.blue_button:
                ButtonInterpolator interpolator3 = new ButtonInterpolator(0.4, 30);
                animation.setInterpolator(interpolator3);
                blue_circle.startAnimation(animation);
                blue_circle.setColorFilter(Color.argb(255, (int) (Math.random() * ((255) + 1)),
                    (int) (Math.random() * ((255) + 1)), (int) (Math.random() * ((255) + 1))));
            break;
            case R.id.yellow_button:
                ButtonInterpolator interpolator4 = new ButtonInterpolator(0.7, 10);
                animation.setInterpolator(interpolator4);
                yellow_circle.startAnimation(animation);
                yellow_circle.setColorFilter(Color.argb(255, (int) (Math.random() * ((255) + 1)),
                    (int) (Math.random() * ((255) + 1)), (int) (Math.random() * ((255) + 1))));
            break;
            case R.id.orange_button:
                ButtonInterpolator interpolator5 = new ButtonInterpolator(0.6, 15);
                animation.setInterpolator(interpolator5);
                orange_circle.startAnimation(animation);
                orange_circle.setColorFilter(Color.argb(255, (int) (Math.random() * ((255) + 1)),
                    (int) (Math.random() * ((255) + 1)), (int) (Math.random() * ((255) + 1))));
            break;
        }
    }
}

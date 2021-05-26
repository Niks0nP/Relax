package ru.com.relax;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
=======
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
>>>>>>> main

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
<<<<<<< HEAD
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private long BackPressedTime;
    ImageView imageView, gameButton;
=======

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;
>>>>>>> main

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView = findViewById(R.id.guide_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Guide_activity.class);
                startActivity(intent);
            }
        });

        imageView = findViewById(R.id.circles_on_water);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Relaxing_activity.class);
=======
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        button = findViewById(R.id.button_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setClickable(false);
            }
        });

        imageView = findViewById(R.id.guide_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Guide_activity.class);
>>>>>>> main
                startActivity(intent);
            }
        });

<<<<<<< HEAD
        gameButton = findViewById(R.id.gamebutton1);
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
=======
        imageView = findViewById(R.id.circles_on_water);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Relaxing_activity.class);
>>>>>>> main
                startActivity(intent);
            }
        });
    }
<<<<<<< HEAD

    @Override
    public void onBackPressed() {
        if(BackPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else{
            Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT).show();
        }
        BackPressedTime = System.currentTimeMillis();
    }
=======
>>>>>>> main
}
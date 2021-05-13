package ru.com.relax;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Relaxing_activity extends AppCompatActivity {

ImageView imageView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relaxing_activity);

        Window g = getWindow();
        g.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView = findViewById(R.id.back_relaxing);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Relaxing_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}

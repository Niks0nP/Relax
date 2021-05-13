package ru.com.relax;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Guide_activity extends AppCompatActivity {

    RecyclerView recyclerView;
    String arr1[], arr2[];
    ImageView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);

        Window g = getWindow();
        g.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        arr1 = getResources().getStringArray(R.array.numbers);
        arr2 = getResources().getStringArray(R.array.guide_text);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerAdaptor recyclerAdaptor = new RecyclerAdaptor(this, arr1, arr2);
        recyclerView.setAdapter(recyclerAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button = findViewById(R.id.button_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guide_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

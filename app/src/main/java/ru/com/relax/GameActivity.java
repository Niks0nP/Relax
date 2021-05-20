package ru.com.relax;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class GameActivity extends AppCompatActivity implements View.OnTouchListener{

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private Chronometer mChronometer;
    ImageView backGame;
    public static boolean isLeftPressed = false;
    public static boolean isRightPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);


        backGame = findViewById(R.id.back_game);
        backGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        GameView gameView = new GameView(this); // создаём gameView

        LinearLayout gameLayout =  findViewById(R.id.gameLayout); // находим gameLayout
        gameLayout.addView(gameView); // и добавляем в него gameView

        Button leftButton = findViewById(R.id.leftButton); // находим кнопки
        Button rightButton =  findViewById(R.id.rightButton);

        leftButton.setOnTouchListener(this);
        rightButton.setOnTouchListener(this);

        mChronometer = findViewById(R.id.simpleChronometer);
        doStart();
    }

    public void showInfo(long Milliseconds){
        long secon = Milliseconds / 1000;
        long hours = secon / 3600;
        long minutes = (secon % 3600) / 60;
        long seconds = secon / 60;
    }

    public void doStart()  {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mChronometer.setBase(SystemClock.elapsedRealtime());
        this.mChronometer.start();
        this.showInfo(elapsedRealtime);
    }

    /*public void doStopGame() {
        mChronometer.stop();
    }*/

    public void doResetBaseTime()  {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mChronometer.setBase(elapsedRealtime);
        this.showInfo(elapsedRealtime);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(v.getId()) { // определяем какая кнопка
            case R.id.leftButton:
                switch (event.getAction()) { // определяем нажата или отпущена кнопка
                    case MotionEvent.ACTION_DOWN:
                        isLeftPressed = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        isLeftPressed = false;
                        break;
                }
                break;
            case R.id.rightButton:
                switch (event.getAction()) { // определяем нажата или отпущена кнопка
                    case MotionEvent.ACTION_DOWN:
                        isRightPressed = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        isRightPressed = false;
                        break;
                }
                break;
        }
        return true;
    }

}

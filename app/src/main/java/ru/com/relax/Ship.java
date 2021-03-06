package ru.com.relax;

import android.content.Context;

public class Ship extends SpaceBody {

    public Ship(Context context) {
        bitmapId = R.drawable.ship;// определяем начальные параметры
        size = 5;
        x = 7;
        y = GameView.maxY - size - 1;////
        speed = (float) 0.9;

        init(context); // инициализируем корабль
    }

    @Override
    public void update() { // перемещаем корабль в зависимости от нажатой кнопки
        if(GameActivity.isLeftPressed && x >= 0){
            x -= speed;
        }
        if(GameActivity.isRightPressed && x <= GameView.maxX - 5){
            x += speed;
        }
    }

}

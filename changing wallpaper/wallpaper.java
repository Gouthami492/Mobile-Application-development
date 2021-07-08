package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b;
    boolean r;
    int[] imgarr=new int[]{R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(!r) {
            new Timer().schedule(new MyTimer(), 0, 3000);
            r=true;
        }
    }

    private class MyTimer extends TimerTask {
        @Override
        public void run() {
            try{
                 WallpaperManager wallpaper=WallpaperManager.getInstance(getBaseContext());
                 Random random=new Random();
                 wallpaper.setBitmap(BitmapFactory.decodeResource(getResources(),imgarr[random.nextInt(5)]));
            }
            catch(Exception ex)
            {

            }
        }
    }
}

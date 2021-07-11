package com.example.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewOnReceiveContentListener;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     Button start;
     Button stop;
     TextView counter1;
     public boolean r=false;
     public int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.start);
        start.setOnClickListener(this);
        stop=(Button)findViewById(R.id.stop);
        stop.setOnClickListener(this);
        counter1=(TextView)findViewById(R.id.counter);

    }

    @Override
    public void onClick(View v) {
        if(v.equals(start))
        {
            counterstart();
        }
        else if(v.equals(stop))
        {
            counterstop();
        }
    }

    private void counterstop() {
        this.r=false;
        start.setEnabled(true);
        stop.setEnabled(false);
    }

    private void counterstart() {
        c=0;
        new MyCounter().start();
        this.r=true;
        start.setEnabled(false);
        stop.setEnabled(true);
    }
    Handler handler=new Handler(Looper.getMainLooper())
    {
        public void handleMessage(@NonNull Message msg)
        {
            counter1.setText(String.valueOf(msg.what));
        }
    };
    private class MyCounter extends Thread {
        public void run()
        {
            while(r)
            {
                c++;
                handler.sendEmptyMessage(c);
                try {
                    Thread.sleep(1000);

                }catch(InterruptedException e)
                {

                }

            }
        }

    }
}

package com.honeysha_tech.vrihad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Objects;

public class QAndA extends AppCompatActivity {

    TextView next;
    ProgressBar progressBar;
    TextView textCounter;
    MyCountDownTimer myCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qand);

        Window window = QAndA.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(QAndA.this, R.color.bg_color));

        next = findViewById(R.id.continue_1);
        progressBar = (ProgressBar) findViewById(R.id.p_Bar);
        textCounter = (TextView) findViewById(R.id.textView7);

        progressBar.setProgressTintList(ColorStateList.valueOf(0xff00DCCC));

        progressBar.setProgress(100);
        myCountDownTimer = new MyCountDownTimer(10000, 500);
        myCountDownTimer.start();

        next.setOnClickListener(v->{
            //dialog calling for true and false answer
            QAndA.this.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contain_question, new Result())
                    .commit();

        });

    }
    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            int progress = (int) (millisUntilFinished / 100);
            int progress_txt = (int) (millisUntilFinished / 1000);
            textCounter.setText(String.valueOf(progress_txt + " Seconds"));
            progressBar.setProgress(progress);
        }

        @Override
        public void onFinish() {
            textCounter.setText("Time Over");
            progressBar.setProgress(0);
        }

    }
}
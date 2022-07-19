package com.honeysha_tech.vrihad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OtpVerification extends AppCompatActivity {

    TextView textView;
    TextView verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        textView = findViewById(R.id.content);
        verify = findViewById(R.id.verify);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        textView.setText("Enter the OTP sent to +91 "+ str);

        verify.setOnClickListener(v->{
            Intent intent1 = new Intent(OtpVerification.this,MainActivity.class);
            startActivity(intent1);
            finishAffinity();
        });


    }
}
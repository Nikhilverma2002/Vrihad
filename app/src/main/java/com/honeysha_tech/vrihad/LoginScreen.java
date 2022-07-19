package com.honeysha_tech.vrihad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class LoginScreen extends AppCompatActivity {

    TextView getOtp;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        getOtp = findViewById(R.id.get_otp);
        editText = findViewById(R.id.editText);

        getOtp.setOnClickListener(v->{
            Intent intent = new Intent(LoginScreen.this , OtpVerification.class);
            String str = editText.getText().toString();
            intent.putExtra("message", str);
            startActivity(intent);
        });
    }
}
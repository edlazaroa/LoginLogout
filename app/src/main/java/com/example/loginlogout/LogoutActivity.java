package com.example.loginlogout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LogoutActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        String username = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            username = extras.getString("username", "");
        }

        TextView tvGoodbye = findViewById(R.id.tvGoodbye);
        tvGoodbye.setText(getString(R.string.goodbye_message) + " " + username + "! "
                + getString(R.string.goodbye_suffix));

        Button btnBackLogin = findViewById(R.id.btnBackLogin);
        btnBackLogin.setOnClickListener(v -> {
            Intent intent = new Intent(LogoutActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
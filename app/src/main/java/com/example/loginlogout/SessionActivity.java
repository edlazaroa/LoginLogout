package com.example.loginlogout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SessionActivity extends AppCompatActivity {

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        // Recuperamos el nombre enviado con putExtra()
        username = getIntent().getStringExtra("username");
        if (username == null) {
            username = "";
        }

        TextView tvWelcome = findViewById(R.id.tvWelcome);
        tvWelcome.setText(getString(R.string.welcome_message) + " " + username + "!");

        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> logout());
    }

    private void logout() {
        // Datos empaquetados en un Bundle
        Bundle bundle = new Bundle();
        bundle.putString("username", username);

        // Intent explícito + putExtras(Bundle)
        Intent intent = new Intent(SessionActivity.this, LogoutActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

        finish();
    }
}
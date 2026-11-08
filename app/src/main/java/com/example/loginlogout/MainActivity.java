package com.example.loginlogout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> attemptLogin());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void attemptLogin() {
        String username = etUser.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        boolean valid = true;

        if (username.isEmpty()) {
            etUser.setError(getString(R.string.error_user));
            valid = false;
        }
        if (password.isEmpty()) {
            etPassword.setError(getString(R.string.error_password));
            valid = false;
        }

        if (!valid) {
            Toast.makeText(this, R.string.toast_fill_fields, Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(MainActivity.this, SessionActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);

        finish();
    }
}
//package com.example.studentms_crudsql;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//
//
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//public class LoginActivity extends AppCompatActivity {
//    private EditText usernameEditText, passwordEditText;
//    private Button loginButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        // Initialize views
//        usernameEditText = findViewById(R.id.usernameEditText);
//        passwordEditText = findViewById(R.id.passwordEditText);
//        loginButton = findViewById(R.id.loginButton);
//
//        // Set click listener for login button
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Retrieve entered username and password
//                String username = usernameEditText.getText().toString().trim();
//                String password = passwordEditText.getText().toString().trim();
//
//                // Perform authentication
//                if (DatabaseHelper.authenticateUser(username, password)) {
//                    // Login successful, navigate to the profile activity
//                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
//                    intent.putExtra("username", username);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    // Login failed, display error message
//                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
//
//}
//
//

package com.example.studentms_crudsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        // Initialize database helper
        databaseHelper = new DatabaseHelper(this);

        // Set click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve entered username and
                // Retrieve entered username and password
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Perform authentication
                if (databaseHelper.authenticateUser(username, password)) {
                    // Login successful, navigate to the profile activity
                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                    finish();
                } else {
                    // Login failed, display error message
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

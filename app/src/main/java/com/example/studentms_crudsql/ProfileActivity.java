//package com.example.studentms_crudsql;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//import android.widget.TextView;
//
//public class ProfileActivity extends AppCompatActivity {
//    private TextView nameTextView, emailTextView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile);
//
//        // Initialize views
//        nameTextView = findViewById(R.id.nameTextView);
//        emailTextView = findViewById(R.id.emailTextView);
//
//        // Retrieve user's information from the database
//        String username = "admin"; // Assume the logged-in user's username
//        User user = getUserFromDatabase(username);
//
//        // Set user's information in the TextViews
//        if (user != null) {
//            nameTextView.setText(user.getName());
//            emailTextView.setText(user.getEmail());
//        }
//    }
//
//    // Method to retrieve user's information from the database
//    private User getUserFromDatabase(String username) {
//        // Implement your database retrieval logic here
//        // Retrieve the user's information based on the provided username
//        // You can use SQLiteOpenHelper, Room, or any other database framework
//
//        // For demo purposes, let's create a dummy user
//        User user = new User("John Doe", "johndoe@example.com");
//        return user;
//    }
//}

package com.example.studentms_crudsql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView nameTextView, emailTextView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);

        // Initialize DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Retrieve logged-in user's username from the intent
        String username = getIntent().getStringExtra("username");

        // Retrieve user's information from the database
        User user = databaseHelper.getUser(username);

        // Set user's information in the TextViews
        if (user != null) {
            nameTextView.setText(user.getName());
            emailTextView.setText(user.getEmail());
        }
    }
}

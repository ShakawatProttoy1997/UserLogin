package com.example.myapplication.Supportive;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class LogIn extends AppCompatActivity {
    EditText userId,password;
    ArrayList<Users> UsersList;
    Users users;
    private boolean keyId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);
        users = new Users();
        UsersList = new ArrayList<>();
    }

    public void LogIn(View view) {
        String UserID = userId.getText().toString();
        String Password = password.getText().toString();
        getDataFromFirebase();

    }
    public void getDataFromFirebase() {
    }
}

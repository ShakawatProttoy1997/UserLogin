package com.example.myapplication.Supportive;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

//import com.nsu.classinsight.R;

public class SignUp extends AppCompatActivity {

    private EditText userId,email,password;
    private boolean keyEmail = false;
    private User users;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.signup);
        userId = findViewById(R.id.userId);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

    }

    public void SignUp(View view) {
        AuthenticateEmail();
        if(keyEmail == false){
            email.setError("Invalid mail address...");
        }
        String UserId = userId.getText().toString();
        String Email = email.getText().toString();
        String Password = password.getText().toString();
        users = new User(UserId,Email,Password);
        Intent intent = new Intent(SignUp.this, LogIn.class);
        startActivity (intent);
        SignUp.this.finish ();
    }

    private void AuthenticateEmail() {
        String Email = email.getText().toString();
        if(Email.endsWith("@nothsouth.edu")){
            keyEmail = true;
        }
        else{
            keyEmail = false;
        }
    }

}


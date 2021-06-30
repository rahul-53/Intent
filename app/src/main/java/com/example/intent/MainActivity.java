package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEtUsername;
    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private String emailValidation = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmailValid() && isPasswordValid() && isUsernameValid()){
                    Intent intent = new Intent(MainActivity.this,showDetails.class);
                    intent.putExtra("username",mEtUsername.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private void initView(){
        mEtUsername=findViewById(R.id.etUsername);
        mEtEmail =findViewById(R.id.etEmail);
        mEtPassword =findViewById(R.id.etPassword);
        mBtnLogin = findViewById(R.id.etLogin);
    }
    private boolean isEmailValid(){
        if (mEtEmail.getText().toString().length()>=1 && mEtEmail.getText().toString().matches(emailValidation)){
            return true;
        }
        else {
            mEtEmail.setError("invalid email");
            return false;
        }
    }
    private boolean isPasswordValid(){
        if(mEtPassword.getText().toString().length()>=6){
            return true;
        }else{
            mEtPassword.setError("Invalid password");
            return false;
        }

    }
    private boolean isUsernameValid(){
        if (mEtUsername.getText().toString().trim().length()>=3){
            return true;
        }
        else{
            mEtUsername.setError("Invalid Username");
            return false;
        }
    }
}
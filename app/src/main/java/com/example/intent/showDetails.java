package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class showDetails extends AppCompatActivity {
    private TextView mTvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        mTvUsername =findViewById(R.id.tvTextView);
        Intent intent = getIntent();
        String userName=intent.getStringExtra("username");
        mTvUsername.setText(userName);


    }
}
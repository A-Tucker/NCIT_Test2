package com.example.ncit_test2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button login,create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        login =  findViewById(R.id.signin);
        create =  findViewById(R.id.signup);


        login.setOnClickListener(this);
        create.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
        if (view == login)
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        if (view == create)
            startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
        finish();

    }
}

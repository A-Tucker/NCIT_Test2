package com.example.ncit_test2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ProfileActivity extends AppCompatActivity {


    private TextView name;
    Button btn_logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.name);
        btn_logout = findViewById(R.id.btn_logout);
        Intent intent = getIntent();
        String extraName = intent.getStringExtra("name");
   name.setText(extraName);

   btn_logout.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           startActivity(new Intent(getApplicationContext(), MainActivity.class));
           finish();
       }
   });

    }
}

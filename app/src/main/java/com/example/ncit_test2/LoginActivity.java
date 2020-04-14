package com.example.ncit_test2;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button btn_login;
    private static String URL_Login= "http://alnafizah.com/Khalid_POS.com/V1/test/login.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btn_login = findViewById(R.id.buttonLogin);
        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);


}
        public void login(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_Login,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String error_id = jsonObject.getString("error_id");
                            if (error_id.equals("-1")){
                                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));                            }

                        }catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this,"Invalid username or password" + e.toString(),Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,"Invalid username or password" + error.toString(),Toast.LENGTH_LONG).show();


                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String> params = new HashMap<>();
                params.put("user_name",username.getText().toString());
                params.put("user_pass",password.getText().toString());
                return  params;
            }
        };
            Volley.newRequestQueue(this).add(stringRequest);
        }


}

package com.example.ncit_test2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {


    private EditText Username, Password , ConfirmPassword;
    private Button buttonRegister;
    private ProgressDialog progressDialog;
    private static String URL_REGIST= "http://alnafizah.com/Khalid_POS.com/V1/test/signup.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



      Username = findViewById(R.id.editTextUsername);
      Password = findViewById(R.id.editTextPassword);
      ConfirmPassword = findViewById(R.id.editTextConfirmPassword);


        buttonRegister =  findViewById(R.id.buttonRegister);

        progressDialog = new ProgressDialog(this);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regist();
            }
        });
    }
   private void Regist(){
        final String Username = this.Username.getText().toString().trim();
       final String Password = this.Password.getText().toString().trim();

       StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
               new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {
                       try {
                           JSONObject jsonObject = new JSONObject(response);
                           String error_id = jsonObject.getString("error_id");
                           if (error_id.equals("-1")){
                               Toast.makeText(SignUpActivity.this,"user inserted with user name :" +Username,Toast.LENGTH_LONG).show();
                           }

                       }catch (JSONException e){
                           e.printStackTrace();
                           Toast.makeText(SignUpActivity.this,"could not insert user , maybe user not unique" + e.toString(),Toast.LENGTH_LONG).show();
                       }

                   }
               },
               new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {
                       Toast.makeText(SignUpActivity.this,"could not insert user , maybe user not unique" + error.toString(),Toast.LENGTH_LONG).show();

                   }
               })
       {
           @Override
           protected Map<String, String> getParams() throws AuthFailureError {
               Map<String,String> params = new HashMap<>();
               params.put("user_name",Username);
               params.put("user_pass",Password);
            return  params;
           }
       };
       RequestQueue requestQueue = Volley.newRequestQueue(this);
       requestQueue.add(stringRequest);
   }

    }


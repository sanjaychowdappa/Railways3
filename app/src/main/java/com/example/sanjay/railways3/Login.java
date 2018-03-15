package com.example.sanjay.railways3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Database database =new Database(this);
EditText email,password;
   public static String uname;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=(EditText) findViewById(R.id.username);
        password=(EditText)findViewById(R.id.gg);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass=database.search(email.getText().toString().trim());
                uname=email.getText().toString();
                if(password.getText().toString().equals(pass)){
                    Toast.makeText(getApplicationContext(),uname,Toast.LENGTH_LONG).show();
                    SharedPreferences sf=getSharedPreferences("myfile", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit=sf.edit();
                    edit.putString("name",uname);
                    edit.commit();
                Intent i=new Intent(Login.this,MainActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"WRONG USERNAME OR PASSWORD",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void login(View view) {
        startActivity(new Intent(Login.this,register.class));
    }

}

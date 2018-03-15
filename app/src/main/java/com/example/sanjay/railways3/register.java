package com.example.sanjay.railways3;

import android.content.Intent;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class register extends AppCompatActivity{
    Database database=new Database(this);
Button register,clear;
    Spinner s1;
EditText name,mobile,email,age,docid,pass,cpass;
    RadioButton male,female;int i,j;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        male=(RadioButton)findViewById(R.id.radioButton);
        female=(RadioButton)findViewById(R.id.female);
        register=(Button)findViewById(R.id.register);
        name=(EditText)findViewById(R.id.name);
        mobile=(EditText)findViewById(R.id.mobile);
        email=(EditText)findViewById(R.id.email);
        age=(EditText)findViewById(R.id.age);
        pass=(EditText)findViewById(R.id.pass);
        cpass=(EditText)findViewById(R.id.cpass);
        clear=(Button)findViewById(R.id.clear);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=Integer.parseInt(age.getText().toString());
                if( i>100 || i<10)Toast.makeText(getApplicationContext(), "INVALID AGE", Toast.LENGTH_LONG).show();
                if(mobile.getText().toString().length()==10){
                    if (name != null && mobile != null && email != null && age != null  && pass != null && cpass != null) {
                    information in=new information();
                    in.setName(name.getText().toString());
                    in.setEmail(email.getText().toString());
                    in.setPass(pass.getText().toString());
                    in.setUname(email.getText().toString());
                    in.setAge(i);
                    in.setMobile(mobile.getText().toString());
                    database.insertValues(in);
                    Toast.makeText(getApplicationContext(), "SUCCESSFULLY REGISTERED", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(register.this, MainActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(), "ENETER FIELDS", Toast.LENGTH_LONG).show();
                }
                }else Toast.makeText(getApplicationContext(), "ENTER VALID Mobile NUMBER", Toast.LENGTH_LONG).show();

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             name.setText(null);mobile.setText(null);email.setText(null);age.setText(null);docid.setText(null);pass.setText(null);cpass.setText(null);
            }
        });

    }



}

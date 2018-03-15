package com.example.sanjay.railways3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.sanjay.railways3.Login.*;
public class profile extends AppCompatActivity {
    Database database=new Database(this);

    Button save;
    EditText name,mobile,email,age,docid,pass,cpass;
    RadioButton male,female;int i,j;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        male=(RadioButton)findViewById(R.id.radioButton);
        female=(RadioButton)findViewById(R.id.female);
        save=(Button)findViewById(R.id.save);
        name=(EditText)findViewById(R.id.name);
        mobile=(EditText)findViewById(R.id.mobile);
        email=(EditText)findViewById(R.id.email);
        age=(EditText)findViewById(R.id.age);
        pass=(EditText)findViewById(R.id.pass);
        cpass=(EditText)findViewById(R.id.cpass);
        Toast.makeText(getApplicationContext(),Login.uname, Toast.LENGTH_LONG).show();
        SharedPreferences sf=getSharedPreferences("myfile", Context.MODE_PRIVATE);
        String uname=sf.getString("name","NA");
        Toast.makeText(getApplicationContext(),uname, Toast.LENGTH_LONG).show();
        Cursor c=database.profile(uname);
        name.setText(c.getString(1));
        email.setText(c.getString(2));
        age.setText(c.getString(3));
        pass.setText(c.getString(4));
        cpass.setText(c.getString(4));
        mobile.setText(c.getString(6));
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=Integer.parseInt(age.getText().toString());
               if( i>100 || i<10) Toast.makeText(getApplicationContext(), "INVALID AGE", Toast.LENGTH_LONG).show();
                if(mobile.getText().toString().length()==10){
                     if(pass.getText().toString()==cpass.getText().toString()) {
                         if (name != null && mobile != null && email != null && age != null && docid != null && pass != null && cpass != null) {
                             information in = new information();
                             in.setName(name.getText().toString());
                             in.setEmail(email.getText().toString());
                             in.setPass(pass.getText().toString());
                             in.setUname(email.getText().toString());
                             in.setAge(i);
                             in.setMobile(mobile.getText().toString());
                             database.insertValues(in);
                             Toast.makeText(getApplicationContext(), "SUCCESSFULLY REGISTERED", Toast.LENGTH_LONG).show();
                             startActivity(new Intent(profile.this, MainActivity.class));
                         } else {
                             Toast.makeText(getApplicationContext(), "ENETER FIELDS", Toast.LENGTH_LONG).show();
                         }
                     }
                     else { Toast.makeText(getApplicationContext(), "PASSWORD DO NOT MATCH", Toast.LENGTH_LONG).show();}
                    }else Toast.makeText(getApplicationContext(), "ENTER VALID Mobile NUMBER", Toast.LENGTH_LONG).show();
                }


        });

    }


}

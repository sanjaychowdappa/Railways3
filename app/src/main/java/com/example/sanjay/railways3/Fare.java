package com.example.sanjay.railways3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Fare extends AppCompatActivity {
EditText source,destination,number;
    Button get;
    TextView fare;
    RadioButton train,route,first,second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare);
        get=(Button)findViewById(R.id.get);
        source=(EditText) findViewById(R.id.sour);
        destination=(EditText)findViewById(R.id.des);
        first=(RadioButton)findViewById(R.id.first);
        second=(RadioButton)findViewById(R.id.sec);
        fare=(TextView)findViewById(R.id.fares);
        number=(EditText)findViewById(R.id.number);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((!train.isChecked() || !route.isChecked()) && (!first.isChecked() || !second.isChecked())){
                    Toast.makeText(getApplicationContext(),"PLEASE SELECT ALL FIELDS",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

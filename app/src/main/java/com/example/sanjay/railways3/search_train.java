package com.example.sanjay.railways3;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class search_train extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
EditText source,destination,date;
    Button search;
    ImageButton exchange,calender;
    RadioButton sec,fir;
    Switch sclass;
DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_train);
        search=(Button)findViewById(R.id.search);
        date=(EditText)findViewById(R.id.date);
        sclass=(Switch)findViewById(R.id.swi);
        sec=(RadioButton)findViewById(R.id.sec);
        fir=(RadioButton)findViewById(R.id.fir);
        source=(EditText)findViewById(R.id.source);
        destination=(EditText)findViewById(R.id.destination);
        exchange=(ImageButton)findViewById(R.id.exchange);
        calender=(ImageButton)findViewById(R.id.calender);
        sclass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    fir.setVisibility(View.VISIBLE);
                    sec.setVisibility(View.VISIBLE);
                } else {
                    fir.setVisibility(View.INVISIBLE);
                    sec.setVisibility(View.INVISIBLE);
                }
            }
        });
        exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (source.toString() == null || destination.toString() == null) {
                    Toast.makeText(getApplicationContext(),"ENTER FIELDS",Toast.LENGTH_LONG).show();
                }else { String s = source.getText().toString(), d = destination.getText().toString();
                    source.setText(d);
                    destination.setText(s);}
            }
        });
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"reached",Toast.LENGTH_LONG).show();
                Calendar cal=Calendar.getInstance();
                int year=cal.get(cal.YEAR);
                int day=cal.get(cal.DAY_OF_MONTH);
                int month=cal.get(cal.MONTH);
                datePickerDialog=new DatePickerDialog(search_train.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date.setText(
                                new StringBuilder()
                                        .append(dayOfMonth).append("/")
                                        .append(monthOfYear + 1).append("/")
                                        .append(year).append(" "));
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Results",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked == true) {
            fir.setVisibility(View.VISIBLE);
            sec.setVisibility(View.VISIBLE);
        } else {
            fir.setVisibility(View.INVISIBLE);
            sec.setVisibility(View.INVISIBLE);
        }
    }
}

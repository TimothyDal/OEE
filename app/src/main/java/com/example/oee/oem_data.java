package com.example.oee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class oem_data extends AppCompatActivity {
    private Button back_button;
    private TextView S_Control_Time;
    private TextView Idle_Time;
    private TextView Total_non_util_Time;
    private TextView Available_Time;
    private TextView Availability;
    private TextView Total_OP;
    private TextView STD_OP;
    private TextView Perform_Eff;
    private TextView OK_Output;
    private TextView Scrap;
    private TextView Total_OP_11th;
    private TextView Quality_Rate;
    private TextView OEE;
    private TextView First_hr_OP;
    private TextView First_hr_OP_Percent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oem_data);

        S_Control_Time = (TextView) findViewById(R.id.dt1);
        Idle_Time = (TextView) findViewById(R.id.dt2);
        Total_non_util_Time = (TextView) findViewById(R.id.dt3);
        Available_Time = (TextView) findViewById(R.id.dt4);
        Availability = (TextView) findViewById(R.id.dt5);
        Total_OP = (TextView) findViewById(R.id.dt6);
        STD_OP = (TextView) findViewById(R.id.dt7);
        Perform_Eff = (TextView) findViewById(R.id.dt8);
        OK_Output = (TextView) findViewById(R.id.dt9);
        Scrap = (TextView) findViewById(R.id.dt10);
        Total_OP_11th = (TextView) findViewById(R.id.dt11);
        Quality_Rate = (TextView) findViewById(R.id.dt12);
        OEE = (TextView) findViewById(R.id.dt13);
        First_hr_OP= (TextView) findViewById(R.id.dt14);
        First_hr_OP_Percent = (TextView) findViewById(R.id.dt15);



        back_button = (Button) findViewById(R.id.btnBk);

        String Entry_one = getIntent().getStringExtra("control time");
        String Entry_two = getIntent().getStringExtra("idle time");
        String Entry_six = getIntent().getStringExtra("total output");
        String Entry_ten = getIntent().getStringExtra("scrap");
        String Entry_fifteen = getIntent().getStringExtra("First hr op percent");
        String Entry_four = getIntent().getStringExtra("Available time");
        String Entry_five = getIntent().getStringExtra("availability");
        String Entry_seven = getIntent().getStringExtra("std op");
        String Entry_eight = getIntent().getStringExtra("perf eff");
        String Entry_nine = getIntent().getStringExtra("Ok op");
        String Entry_twelve = getIntent().getStringExtra("Quality rate");
        String Entry_thirteen = getIntent().getStringExtra("oee");
        String Entry_fourteen = getIntent().getStringExtra("first hr op");

        S_Control_Time.setText(Entry_one);
        Idle_Time.setText(Entry_two);
        Total_non_util_Time.setText(Entry_two);
        Total_OP.setText(Entry_six);
        Scrap.setText(Entry_ten);
        First_hr_OP_Percent.setText(Entry_fifteen);
        Available_Time.setText(Entry_four);
        Availability.setText(Entry_five);
        Total_OP_11th.setText(Entry_six);
        STD_OP.setText(Entry_seven);
        Perform_Eff.setText(Entry_eight);
        OK_Output.setText(Entry_nine);
        Quality_Rate.setText(Entry_twelve);
        OEE.setText(Entry_thirteen);
        First_hr_OP.setText(Entry_fourteen);


        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();

            }
        });

    }
    public void openMainActivity(){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }

}
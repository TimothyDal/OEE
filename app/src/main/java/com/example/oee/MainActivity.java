




package com.example.oee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView Shift_Time;
    private TextView Control_Time;
    private TextView Idle_Time;
    private TextView Total_OP;
    private TextView Scrap;
    private TextView First_hr_op_percent;
    //private TextView num0;
    private EditText num1;
    private EditText num2;
    private EditText num3;
    private EditText num4;
    private EditText num5;
    private EditText num6;
    private TextView num7;
    private Button Radio;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        num1 = (EditText)findViewById(R.id.etNum1);
       //num0 = (TextView)findViewById(R.id.etNum0);
        num2 = (EditText)findViewById(R.id.etNum2);
        num3 = (EditText)findViewById(R.id.etNum3);
        num4 = (EditText)findViewById(R.id.etNum4);
        num5 = (EditText)findViewById(R.id.etNum5);
        num6 = (EditText)findViewById(R.id.etNum6);
        num7 = (TextView)findViewById(R.id.etNumM);
        Shift_Time = (TextView)findViewById(R.id.et1);
        Control_Time = (TextView)findViewById(R.id.et2);
        Idle_Time = (TextView)findViewById(R.id.et3);
        Total_OP = (TextView)findViewById(R.id.et4);
        Scrap = (TextView)findViewById(R.id.et5);
        First_hr_op_percent = (TextView)findViewById(R.id.et6);
        button = (Button) findViewById(R.id.btn);

        Radio = (Button) findViewById(R.id.radioButton);

        button.setEnabled(false);




        num1.addTextChangedListener(submit_text_watcher);
        num2.addTextChangedListener(submit_text_watcher);
        num3.addTextChangedListener(submit_text_watcher);
        num4.addTextChangedListener(submit_text_watcher);
        num5.addTextChangedListener(submit_text_watcher);
        num6.addTextChangedListener(submit_text_watcher);
        Radio.addTextChangedListener(Radio_button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float Z = Float.parseFloat(num1.getText().toString());
                float A = Float.parseFloat(num2.getText().toString());
                float B = Float.parseFloat(num3.getText().toString());
                float C = Float.parseFloat(num4.getText().toString());
                float D = Float.parseFloat(num5.getText().toString());
                float R = Float.parseFloat(num6.getText().toString());

                //float Y = Z / 60;
                float H = Z - B;
                float O = H / Z;
                float I = H /A;
                float K = C /I;
                float J = C - D;
                float P = J / C;
                float Q = (A * (C - D) * 100) /Z;
                float E = ((R * 60)/A) / 100;



                //String Shift_time = String.valueOf(Y);
                String Available_time = String.valueOf(H);
                String Availability = String.valueOf(O);
                String Std_op = String.valueOf(I);
                String Perf_eff = String.valueOf(K);
                String OK_op = String.valueOf(J);
                String Quality_rate = String.valueOf(P);
                String OEE = String.valueOf(Q);
                String First_hr_op = String.valueOf(E);


                //String Entry_one = num1.getText().toString();
                String Entry_two = num2.getText().toString();
                String Entry_three = num3.getText().toString();
                String Entry_four = num4.getText().toString();
                String Entry_five = num5.getText().toString();
                String Entry_six = num6.getText().toString();






                Intent intent = new Intent(MainActivity.this, oem_data.class);
                //intent.putExtra("shift time", Entry_one);
                intent.putExtra("control time", Entry_two);
                intent.putExtra("idle time", Entry_three);
                intent.putExtra("total output", Entry_four);
                intent.putExtra("scrap", Entry_five);
                intent.putExtra("First hr op percent", Entry_six);
                intent.putExtra("Available time", Available_time);
                intent.putExtra("availability", Availability);
                intent.putExtra("std op", Std_op);
                intent.putExtra("perf eff", Perf_eff);
                intent.putExtra("Ok op", OK_op);
                intent.putExtra("Quality rate", Quality_rate);
                intent.putExtra("oee", OEE);
                intent.putExtra("first hr op", First_hr_op);

                startActivity(intent);


            }
        });
        Radio.setEnabled(false);
        num1.addTextChangedListener(Radio_button);
        num2.addTextChangedListener(Radio_button);
        num4.addTextChangedListener(Radio_button);

        Radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float Z = Float.parseFloat(num1.getText().toString());
                float A = Float.parseFloat(num2.getText().toString());
                float C = Float.parseFloat(num4.getText().toString());

                float X = Z - (A * C);
                String Max_idle_time = String.valueOf(X);
                num7.setText(Max_idle_time);
            }
        });


    }
    private TextWatcher submit_text_watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String Shift_time = num1.getText().toString();
            String Control_Time = num2.getText().toString();
            String Idle_time = num3.getText().toString();
            String Total_OP = num4.getText().toString();
            String Scrap = num5.getText().toString();
            String First_hr_op = num6.getText().toString();

            if (!Shift_time.isEmpty() && !Control_Time.isEmpty() && !Idle_time.isEmpty() && !Total_OP.isEmpty() && !Scrap.isEmpty() && !First_hr_op.isEmpty()){
                button.setEnabled(true);
            }else {
                button.setEnabled(false);
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private TextWatcher Radio_button = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String Shift = num1.getText().toString();
            String Control = num2.getText().toString();
            String Total = num4.getText().toString();

            if (!Shift.isEmpty() && !Control.isEmpty() && !Total.isEmpty()){
                Radio.setEnabled(true);
            }else {
                Radio.setEnabled(false);
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
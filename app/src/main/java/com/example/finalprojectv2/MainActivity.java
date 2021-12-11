package com.example.finalprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    TextView newCalculatorTitle;
    TextView numberView;
    EditText inputFirstNumber;
    EditText inputSecondNumber;
    Button buttonCalculate;
    Button buttonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
        newCalculatorTitle = findViewById(R.id.newCalculatorTitle);
        numberView = findViewById(R.id.numberView);
        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonSettings = findViewById(R.id.buttonSettings);



        initCalculate();
        initSettingsActivity();
    }

    private void initCalculate(){
        Button calculate = findViewById(R.id.buttonCalculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num = Float.parseFloat(inputFirstNumber.getText().toString());
                float num2 = Float.parseFloat(inputSecondNumber.getText().toString());
                float total = ((num) - (num2));
                numberView.setText(total+" is the total");
            }
        });

    }

    private void initSettingsActivity(){
        Button buttonSettings = findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));

            }
        });
    }



    public void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getSharedPreferences("MySettingPreferences", Context.MODE_PRIVATE);
        String changeColor = sharedPref.getString("color", "name");


        if (changeColor.equals("default")) {
            layout.setBackgroundColor(0xFF2B2A2A);
            newCalculatorTitle.setTextColor(0xFFFFFFFF);
            buttonCalculate.setBackgroundColor(0xFFFFFFFF);
            buttonCalculate.setTextColor(0x802B2A2A);
            buttonSettings.setBackgroundColor(0xFFFFFFFF);
            buttonSettings.setTextColor(0x802B2A2A);
        } else if (changeColor.equals("white")) {
            layout.setBackgroundColor(0xFFFFFFFF);
            newCalculatorTitle.setTextColor(0x802B2A2A);
            buttonCalculate.setBackgroundColor(0x802B2A2A);
            buttonCalculate.setTextColor(0xFFFFFFFF);
            buttonSettings.setBackgroundColor(0x802B2A2A);
            buttonSettings.setTextColor(0xFFFFFFFF);
        } else {
            layout.setBackgroundColor(0xFFFFEACB);
            newCalculatorTitle.setTextColor(0xFF4e350e);
            buttonCalculate.setBackgroundColor(0x804e350e);
            buttonCalculate.setTextColor(0x80FFEACB);
            buttonSettings.setBackgroundColor(0x804e350e);
            buttonSettings.setTextColor(0x80FFEACB);

        }
    }
}
package com.example.smeredith.sumcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

    //create an instance var
    private TextView textView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //get a reference to the text view
        textView3 = (TextView) findViewById(R.id.textView3);

        //get values from the other activty
        Bundle bundle = getIntent().getExtras();
        int num1 = bundle.getInt("num1");
        int num2 = bundle.getInt("num2");

        //add the values
        int sum = num1 + num2;

        //output the sum
        textView3.setText(Integer.toString(sum));

    }
}

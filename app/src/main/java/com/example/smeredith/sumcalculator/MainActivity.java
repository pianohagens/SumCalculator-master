package com.example.smeredith.sumcalculator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity  {

    //define variables for the widgets
    private EditText editTextNum1;
    private EditText editTextNum2;
    private Button button;
    private TextView textViewSum;

    //define the shared pref object
    private SharedPreferences savedValues;



    //define variables to be saved
    private int num1 = 0;
    private int num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to the widgets
        editTextNum1 = (EditText) findViewById(R.id.editTextNum1);
        editTextNum2 = (EditText) findViewById(R.id.editTextNum2);
        button = (Button) findViewById(R.id.button);
        textViewSum = (TextView) findViewById(R.id.textViewSum);


        //get SharedPreferences object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }
    // Get A8_SettingAcitivity
    public void displayMySetting(View view){
        //start the setting activity
        startActivity(new Intent(this, A8_SettingsActivity.class));
    }
    public void readMySetting(View view){
        //read the value where stored in a key value pai
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String settingMine = prefs.getString("example_text", "Piano Hagens");
        Toast.makeText(this,settingMine, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPause(){

        //save the instance variablea
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putInt("num1", num1);
        editor.putInt("num2", num2);
        editor.commit();
        super.onPause();
    }

    @Override
    public void onResume(){

        //get the instance vars

        super.onResume();
        num1 = savedValues.getInt("num1", 0 );
        num2 = savedValues.getInt("num2", 0);

    }

    public void sendMessage(View view){
        //set an intent that you are going to invoke the second activity from the first activity
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        //get values for the numbers to be added
        num1 = Integer.parseInt(editTextNum1.getText().toString());
        num2 = Integer.parseInt(editTextNum2.getText().toString());

        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);

        startActivity(intent);

    }

}

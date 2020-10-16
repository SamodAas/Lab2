package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import static android.view.View.FOCUS_DOWN;

public class MainActivity extends AppCompatActivity {

    private Spinner optionSpinner;
   private TextView resultText;
   private TextView wordResult;
   private TextView charResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.resultText= findViewById(R.id.calcResult);
        this.resultText.setVisibility(View.GONE);
        //this.charResult.setVisibility(View.GONE);
        //this.wordResult.setVisibility(View.GONE);
        this.optionSpinner = findViewById(R.id.optionSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.optionsForSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        optionSpinner.setAdapter(adapter);
    }
   /* protected void onStart(){
        super.onStart();

       this.resultText.setVisibility(View.GONE);
       this.charResult.setVisibility(View.GONE);
       this.wordResult.setVisibility(View.GONE);

    }*/
    public void calculation(View view) {
        String choice = optionSpinner.getSelectedItem().toString();
        String words = "words";
        String functionToString = Integer.toString(Calculations.calcByWords());


        if (choice.equalsIgnoreCase(words)){
            //this.resultText.setText(functionToString);
            //this.resultText.setVisibility(View.VISIBLE);

        } else
            Calculations.calcByChars();
    }
}
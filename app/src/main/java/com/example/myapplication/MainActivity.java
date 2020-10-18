package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Spinner optionSpinner;
    private TextView resultText;
    private TextView wordResult;
    private TextView charResult;
    private TextView enteredText;
    private TextView warningtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.resultText= findViewById(R.id.calcResult);
        this.resultText.setVisibility(View.GONE);
        this.charResult = findViewById(R.id.charCountText);
        this.charResult.setVisibility(View.GONE);
        this.wordResult = findViewById(R.id.wordCountText);
        this.wordResult.setVisibility(View.GONE);
        this.optionSpinner = findViewById(R.id.optionSpinner);
        this.enteredText = findViewById(R.id.textForCalc);
        this.warningtext = findViewById(R.id.warningText);
        this.warningtext.setVisibility(View.GONE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.optionsForSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        optionSpinner.setAdapter(adapter);
    }


    public void calculation(View view) {

        String choice = optionSpinner.getSelectedItem().toString();
        String words = "By words";
        String text = this.enteredText.getText().toString();

        if(text.equals("")){

            this.warningtext.setVisibility(View.VISIBLE);
            this.charResult.setVisibility(View.GONE);
            this.wordResult.setVisibility(View.GONE);

        } else {

            InputMethodManager manager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            this.warningtext.setVisibility(View.GONE);

            if (choice.equals(words)) {

                this.charResult.setVisibility(View.GONE);
                String functionToString = Integer.toString(Calculations.calcByWords(text));
                this.resultText.setText(functionToString);
                this.resultText.setVisibility(View.VISIBLE);
                this.wordResult.setVisibility(View.VISIBLE);

            } else {

                this.wordResult.setVisibility(View.GONE);
                String functionToString = Integer.toString(Calculations.calcByChars(text));
                this.resultText.setText(functionToString);
                this.resultText.setVisibility(View.VISIBLE);
                this.charResult.setVisibility(View.VISIBLE);

            }
        }
    }
}
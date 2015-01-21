package com.example.ehi.mycalculator;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorActivity extends FragmentActivity {

    private CalculatorModel calculator = new CalculatorModel();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    //region BUTTON PRESS METHODS
    public void numberPressed(View view){
        String number = view.getTag().toString();
        calculator.addNumberToCalculation(number);
        sendStringToDisplayFragment(calculator.getCalculationString());
    }

    public void characterPressed(View view){
        String character = view.getTag().toString();
        calculator.addCharacterToCalculation(character);
        sendStringToDisplayFragment(calculator.getCalculationString());
    }

    public void deleteLastCharacter(View view){
        calculator.deleteLastCharacter();
        sendStringToDisplayFragment(calculator.getCalculationString());
    }

    public void clearInput(View view){
        calculator.clearInput();
        sendStringToDisplayFragment(calculator.getCalculationString());
    }

    public void equalsPressed(View view){
        calculator.equalsPressed();
        sendStringToDisplayFragment(calculator.getCalculationString());
        calculator.clearInput();
    }
    //endregion

    //region FRAGMENT METHODS
    public void sendStringToDisplayFragment(String string){
        ScreenFragment screenFragment = (ScreenFragment) getFragmentManager().findFragmentById(R.id.fragment_screen);
        screenFragment.setDisplayText(string);
    }
    //endregion
}

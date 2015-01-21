package com.example.ehi.mycalculator;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by EHI on 1/21/15.
 */
public class CalculatorModel {

    String calculationString = "";

    public String getCalculationString(){
        return calculationString;
    }

    public void addNumberToCalculation(String number){
        calculationString = calculationString + number;
    }

    public void addCharacterToCalculation(String character){
        if (!operandIsPresent() && !TextUtils.isEmpty(calculationString)){
            calculationString = calculationString + character;
        }
    }

    public void deleteLastCharacter(){
        if (!TextUtils.isEmpty(calculationString)) {
            calculationString = calculationString.substring(0, calculationString.length() - 1);
        }
    }
    public void clearInput(){
        calculationString = "";
    }

    public void equalsPressed(){
        if(operandIsPresent()) {
            processForSymbol("+");
            processForSymbol("-");
            processForSymbol("*");
            processForSymbol("/");
        }
    }

    public void processForSymbol(String symbol){
        symbol = "\\" + symbol;
        String[] numbers = calculationString.split(symbol);
        if (numbers.length > 1){
            calculationString = performOperation(symbol, numbers);
        }
    }

    public String performOperation(String symbol, String[] numbers){
        int numberOne = Integer.parseInt(numbers[0]);
        int numberTwo = Integer.parseInt(numbers[1]);
        if (symbol.equals("\\+")){
            return String.valueOf(numberOne + numberTwo);
        }
        if (symbol.equals("\\-")){
            return String.valueOf(numberOne - numberTwo);
        }
        if (symbol.equals("\\*")){
            return String.valueOf(numberOne * numberTwo);
        }
        if (symbol.equals("\\/")){
            return String.valueOf(numberOne / numberTwo);
        }
        return "ERROR";
    }

    public boolean operandIsPresent(){
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(calculationString);
        return matcher.find();
    }
}

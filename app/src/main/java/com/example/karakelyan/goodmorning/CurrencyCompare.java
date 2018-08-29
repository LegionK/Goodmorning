package com.example.karakelyan.goodmorning;

import android.widget.TextView;

import java.util.LinkedList;

public class CurrencyCompare {
    String FirstCurrency;
    String SecondCurrency;
    String Proportional;
    TextView textView;
    public static LinkedList<CurrencyCompare> CurList= new LinkedList<>();


    public  CurrencyCompare (String firstCurrency, String secondCurrency, String proportional){
        FirstCurrency=firstCurrency;
        SecondCurrency=secondCurrency;
        Proportional=proportional;
        CurList.add(this);

    }




}

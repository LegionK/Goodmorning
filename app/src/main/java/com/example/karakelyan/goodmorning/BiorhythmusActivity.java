package com.example.karakelyan.goodmorning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.DatePicker;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BiorhythmusActivity extends AppCompatActivity {

    EditText edDate;
//    int Day;
//    int Month;
//    int Year;
    TextView twEmotional;
    TextView twIntellectual;
    TextView twPhysics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biorhythmus);

        edDate = (EditText)findViewById(R.id.edDate);
        twEmotional = (TextView)findViewById(R.id.twEmotional);
        twIntellectual = (TextView)findViewById(R.id.twIntellectual);
        twPhysics = (TextView)findViewById(R.id.twPhysics);
    }

    public  void onCalculateBiorhytmusClick(View view) {
        String a = edDate.getText().toString();
//        String[] dates = new String[3];
//        dates = a.split(".");
//        Day = Integer.parseInt(dates[0]);
//        Month = Integer.parseInt(dates[1]);
//        Year = Integer.parseInt(dates[2]);
        int days = calcDiff(a);
        double physical=(Math.sin(2*Math.PI*days/23))*100;
        double emo=(Math.sin(2*Math.PI*days/28))*100;
        double intel=(Math.sin(2*Math.PI*days/33))*100;
        int physical2=(int)physical;
        int emo2=(int)emo;
        int intel2=(int)intel;
        twPhysics.setText(String.valueOf(physical2)+"%");
        twEmotional.setText(String.valueOf(emo2)+"%");
        twIntellectual.setText(String.valueOf(intel2)+"%");


    }

    public  int calcDiff (String a){
        Calendar calendar =Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
        String currentTime=dateformat.format(calendar.getTime());
        Date date1=null;
        Date date2=null;
        try {
            date1 = dateformat.parse(a);
            date2 = dateformat.parse(currentTime);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        long diff=date2.getTime()-date1.getTime();
        long days=diff/(24*60*60*1000);
        int d=(int)days+1;
        return d;
    }
}

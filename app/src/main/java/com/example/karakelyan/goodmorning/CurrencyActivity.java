package com.example.karakelyan.goodmorning;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;

public class CurrencyActivity extends AppCompatActivity {

    MyBasicAdapter adapter;
    ListView listView;
    public Elements content;
    LinkedList<CurrencyCompare> list = new LinkedList<>();
    String Frst="RUB";
    String Scnd="CZK";
    String c;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        listView = findViewById(R.id.listView);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);

//
        new NewThread().execute();
        adapter = new MyBasicAdapter(this, list);
    }

    public class NewThread extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... args) {
            progressBar.setVisibility(ProgressBar.VISIBLE);
            Document doc;
            String url1 = "https://www.xe.com/currencyconverter/convert/?Amount=1&From=" +Frst + "&To=" +Scnd;
            try {
                doc = Jsoup.connect("https://ru.investing.com/currencies/rub-czk").get();
                content=doc.select("#last_last");
                for (Element contents: content){
                    c=content.text()
                    ;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return c;
        }

        @Override
        protected void onPostExecute(String result) {
            progressBar.setVisibility(ProgressBar.INVISIBLE);
            list.add(new CurrencyCompare(Frst,Scnd,result));
            listView.setAdapter(adapter);
        }
    }
}

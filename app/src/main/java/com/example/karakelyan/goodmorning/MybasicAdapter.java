package com.example.karakelyan.goodmorning;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.karakelyan.goodmorning.CurrencyCompare;

import java.util.LinkedList;
import java.util.List;



class MyBasicAdapter extends BaseAdapter{

    Context context;
    LinkedList<CurrencyCompare> rowItems;


    public MyBasicAdapter (Context context, LinkedList<CurrencyCompare> items) {
        this.context = context;
        this.rowItems = items;
    }

    //класс для показа одной строчки
    private class ViewHolder {
        TextView textView;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder hld = null;
        LayoutInflater lInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            convertView = lInflater.inflate(R.layout.item_row, null);
            CurrencyCompare item = (CurrencyCompare) getItem(position);
            ((TextView)convertView.findViewById(R.id.item_row_name)).setText(item.FirstCurrency+'/'+item.SecondCurrency);
            ((TextView)convertView.findViewById(R.id.item_row_value)).setText((String.valueOf(item.Proportional)));
//            hld1= new ViewHolder();
//            hld1.textView = convertView.findViewById(R.id.item_row_name);
//            hld1.textView = convertView.findViewById(R.id.item_row_value);

            convertView.setTag(position);
//            convertView.setTag(hld);
        }
        else {
            hld = (ViewHolder) convertView.getTag();
        }




        return convertView;
    }


    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

}

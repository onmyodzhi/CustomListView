package com.example.customlistview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<CountryModelClass> {
    private ArrayList<CountryModelClass> countryArrayList;
    Context context;

    public CustomAdapter(ArrayList<CountryModelClass> data, Context context){
        super(context, R.layout.item_list_layout,data);
        this.context = context;
        this.countryArrayList = data;
    }

    private static class ViewHolder{
        TextView textCountry, cupWins;
        ImageView flagImg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CountryModelClass dataModel = getItem(position);
        ViewHolder viewHolder;
        final View result;


        if(convertView == null){
            viewHolder = new ViewHolder();

          convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_list_layout,
                            parent, false);

          viewHolder.textCountry = (TextView) convertView.findViewById(R.id.countryName);
          viewHolder.cupWins = (TextView) convertView.findViewById(R.id.cupWinDesc);
          viewHolder.flagImg = (ImageView) convertView.findViewById(R.id.flagCountry);

          result = convertView;
          convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.textCountry.setText(dataModel.getCountry_name());
        viewHolder.cupWins.setText(dataModel.getCup_win_count());
        viewHolder.flagImg.setImageResource(dataModel.getFlag_img());

        return convertView;
    }
}

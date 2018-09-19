package com.example.bcs.fundmytra;

import android.content.Context;
import android.graphics.Movie;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<DataModel> {

    private Context mContext;
    private List<DataModel> moviesList = new ArrayList<>();

    public CustomAdapter(@NonNull Context context,  ArrayList<DataModel> list) {
        super(context, 0 , list);
        mContext = context;
        moviesList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_listview,parent,false);

        DataModel details = moviesList.get(position);

        ImageView image = (ImageView)listItem.findViewById(R.id.product);
        image.setImageResource(details.getPrdouct());

        TextView name = (TextView) listItem.findViewById(R.id.product_name);
        name.setText(details.getName());

        TextView release = (TextView) listItem.findViewById(R.id.search);
        release.setText(details.getSearched_on());

        TextView time = (TextView) listItem.findViewById(R.id.time);
        time.setText(details.getTime_date());

        return listItem;
    }
}

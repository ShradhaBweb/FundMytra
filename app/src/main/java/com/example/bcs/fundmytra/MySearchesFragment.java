package com.example.bcs.fundmytra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MySearchesFragment extends Fragment {
   // ListView simpleList;
   // String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};
    private ListView listView;
    private CustomAdapter mAdapter;
    public MySearchesFragment() {
// Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        RelativeLayout relativeLayout=(RelativeLayout) inflater.inflate(R.layout.fragment_mysearches, container, false);
        listView = (ListView)relativeLayout.findViewById(R.id.simpleListView);
        ArrayList<DataModel> moviesList = new ArrayList<>();
        moviesList.add(new DataModel(R.drawable.car, "Car Loan" , "searched on","10-10-2018 at 03:45PM"));
        moviesList.add(new DataModel(R.drawable.house, "House Loan" , "searched on","10-10-2018 at 03:45PM"));
        moviesList.add(new DataModel(R.drawable.credit, "Credit Card" , "searched on","10-10-2018 at 03:45PM"));
        moviesList.add(new DataModel(R.drawable.top_up, "Top up Car loan" , "searched on","10-10-2018 at 03:45PM"));
        mAdapter = new CustomAdapter(getContext(),moviesList);
        listView.setAdapter(mAdapter);
        return relativeLayout;
    }

}
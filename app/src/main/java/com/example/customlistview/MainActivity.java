package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static CustomAdapter adapter;
    ArrayList<CountryModelClass> dataModels;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        dataModels = new ArrayList<>();

        dataModels.add(new CountryModelClass("Germany", "3",
                R.drawable.germany));
        dataModels.add(new CountryModelClass("France","0",
                R.drawable.france));
        dataModels.add(new CountryModelClass("Brazil", "5",
               R.drawable.brazil));
        dataModels.add(new CountryModelClass("Saudi Arabia", "0",
                R.drawable.saudi_arabia));
        dataModels.add(new CountryModelClass("Spain", "4",
                R.drawable.spain));
        dataModels.add(new CountryModelClass("United Kingdom", "1",
                R.drawable.uk));
        dataModels.add(new CountryModelClass("USA", "13",
                R.drawable.usa));

        adapter = new CustomAdapter(dataModels, getApplicationContext());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Country"
                                +
                                Objects.requireNonNull(adapter.getItem(position)).getCountry_name()
                        +
                        "\n"
                        +
                        "World Cups wins: "
                                +
                                Objects.requireNonNull(adapter.getItem(position)).getCup_win_count(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
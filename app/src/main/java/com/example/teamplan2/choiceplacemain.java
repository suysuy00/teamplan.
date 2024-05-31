package com.example.teamplan2;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class choiceplacemain extends AppCompatActivity implements MyAdapter.ItemClickListener{
    RecyclerView rview;
    MyAdapter adapter;

    String[] places = {
            "용화사",
            "슬램덩크 전시회",
            "광안리",
            "버터맨션",
            "떡볶이농장",
            "장소이름",
            "장소이름",
            "장소이름",
            "장소이름",
            "장소이름"
    };

    Integer[] images = {
            R.drawable._11,
            R.drawable.kakaotalk_20240508_215831656_1,
            R.drawable.kakaotalk_20240508_215750978_1,
            R.drawable.kakaotalk_20240508_215845669_1,
            R.drawable.kakaotalk_20240508_215831656_01_1,
            R.drawable._11,
            R.drawable._11,
            R.drawable._11,
            R.drawable._11,
            R.drawable._11
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.choiceplace);



        RecyclerView recyclerView = findViewById(R.id.rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this, images, places);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(choiceplacemain.this, places[+position], Toast.LENGTH_SHORT).show();
    }
}
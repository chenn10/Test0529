package com.example.test0508;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<StuData> stuDataList;
    private StuDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMyData);

        stuDataList = new ArrayList<>();

        stuDataList.add(new StuData("https://cdn-icons-png.flaticon.com/128/2769/2769833.png", "John", "180"));
        stuDataList.add(new StuData("https://cdn-icons-png.flaticon.com/128/2769/2769833.png", "Tom", "175"));
        stuDataList.add(new StuData("https://www.cjcu.edu.tw/images/logo_story/logo-xl.jpg", "Jerry", "170"));
        stuDataList.add(new StuData("https://cdn-icons-png.flaticon.com/128/2769/2769833.png", "Mike", "165"));
        stuDataList.add(new StuData("https://cdn-icons-png.flaticon.com/128/2769/2769833.png", "Jack", "160"));
        stuDataList.add(new StuData("https://www.cjcu.edu.tw/images/logo_story/logo-s2.jpg", "Rose", "155"));
        stuDataList.add(new StuData("https://cdn-icons-png.flaticon.com/128/2769/2769833.png", "Lily", "150"));
        stuDataList.add(new StuData("https://cdn-icons-png.flaticon.com/128/2769/2769833.png", "Lucy", "145"));
        stuDataList.add(new StuData("https://cdn-icons-png.flaticon.com/128/2769/2769833.png", "Linda", "140"));
        stuDataList.add(new StuData("https://cdn-icons-png.flaticon.com/128/2769/2769833.png", "Marry", "135"));
        adapter = new StuDataAdapter(stuDataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addData(View view) {
        Intent intent = new Intent(this, AddDataActivity.class);
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            String height = data.getStringExtra("height");
            String url = data.getStringExtra("url");
            stuDataList.add(new StuData(url, name, height));
            adapter.notifyDataSetChanged();
    }
}
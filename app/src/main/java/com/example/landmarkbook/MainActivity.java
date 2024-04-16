package com.example.landmarkbook;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.landmarkbook.databinding.ActivityDetailsBinding;
import com.example.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); //INFLATE LAYOUT ILE KODUN BAGLANMASINI SAGLAR
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList = new ArrayList<>();

        Landmark pisa = new Landmark("Pisa", "Italy", R.drawable.pisa);
        Landmark londonBridge = new Landmark("London Bridge", "UK", R.drawable.london);
        Landmark eiffel = new Landmark("Eiffel", "France", R.drawable.eyfel);
        Landmark collosseum = new Landmark("Collosseum", "Italy",R.drawable.collesium);

        landmarkArrayList.add(pisa);
        landmarkArrayList.add(londonBridge);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(collosseum);

        //bitmap: kaynaklari decode edip gorsele cevirebilir
        //Bitmap pisaBitMap = BitmapFactory.decodeResource(getResources(), R.drawable.pisa);
        //Bitmap ler intentle alip yollanamaz intentlerin siniri var singleton buyuk verileri de yollayabilir

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);


        /*
        // Listview ile birlikte ArrayAdapter kullanimi verimsiz ama daha kolaydir
        //Mapping
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList()));
        binding.listView.setAdapter(arrayAdapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, landmarkArrayList.get(position).name, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("landmark", landmarkArrayList.get(position));
                startActivity(intent);
            }
        });*/


    }
}
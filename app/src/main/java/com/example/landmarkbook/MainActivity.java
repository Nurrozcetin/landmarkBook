package com.example.landmarkbook;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.landmarkbook.databinding.ActivityDetailsBinding;
import com.example.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;

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

        // Listview ile birlikte ArrayAdapter kullanimi verimsiz ama daha kolaydir
    }
}
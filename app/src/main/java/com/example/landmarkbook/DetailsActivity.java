package com.example.landmarkbook;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.landmarkbook.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater()); //INFLATE LAYOUT ILE KODUN BAGLANMASINI SAGLAR
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        //Landmark selected = (Landmark) intent.getSerializableExtra("landmark"); //casting dogru yapilmazsa app coker ayrica () icindeki degerden eminim cevir diyoruz
        Singleton singleton = Singleton.getInstance();
        Landmark selected = singleton.getSentLandmark();
        binding.txtName.setText(selected.name);
        binding.txtCountry.setText(selected.country);
        binding.imgDetails.setImageResource(selected.image);
    }
}
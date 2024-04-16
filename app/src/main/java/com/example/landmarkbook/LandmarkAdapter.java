package com.example.landmarkbook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.landmarkbook.databinding.ActivityMainBinding;
import com.example.landmarkbook.databinding.RecycleRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {
    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //xml baglama
        RecycleRowBinding recycleRowBinding = RecycleRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false); // parent ile alinacak view belli zaten
        return new LandmarkHolder(recycleRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.txtRecyclerView.setText(landmarkArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                //intent.putExtra("landmark", landmarkArrayList.get(position));
                Singleton singleton = Singleton.getInstance();
                singleton.setSentLandmark(landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() { //kac item varsa
        return landmarkArrayList.size();
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder{
        private RecycleRowBinding binding;
        public LandmarkHolder(RecycleRowBinding binding) { //bir seyi tanimladik ancak initiliaze etmedik null halde durur
            super(binding.getRoot()); //itemView ile saglanan gorunumu bindingle bu sekilde verirsin
            this.binding = binding;
        }

    }

}

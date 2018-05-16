package com.example.oguzhan.petodex.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oguzhan.petodex.R;
import com.example.oguzhan.petodex.pets.Pet;

import java.util.List;


public class PetRecyclerViewAdapter extends RecyclerView.Adapter<PetRecyclerViewAdapter.MyViewHolder> {

    private List<Pet> listPets;

    class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView petImage;
        public TextView petName;
        public TextView petType;
        public TextView petStrain;
        public TextView petAge;


        MyViewHolder(View view) {
            super(view);
            petImage = view.findViewById(R.id.petImage);
            petName = view.findViewById(R.id.petName);
            petType = view.findViewById(R.id.petType);
            petStrain = view.findViewById(R.id.petStrain);
            petAge = view.findViewById(R.id.petAge);
        }
    }

    public PetRecyclerViewAdapter(List<Pet> listPets) {
        this.listPets = listPets;
    }

    @Override
    public PetRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.elements_pets, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PetRecyclerViewAdapter.MyViewHolder holder, int position) {
        Pet pets = listPets.get(position);
        holder.petName.setText(pets.getName());
        holder.petType.setText(pets.getPetType());
        holder.petStrain.setText(pets.getStrain());
        holder.petAge.setText(pets.getAge().toString());
    }

    @Override
    public int getItemCount() {
        return listPets.size();
    }

    public Pet getItemAt(int position) {
        return listPets.get(position);
    }

}
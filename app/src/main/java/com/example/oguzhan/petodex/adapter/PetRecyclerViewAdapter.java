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

import co.dift.ui.SwipeToAction;


public class PetRecyclerViewAdapter extends RecyclerView.Adapter<PetRecyclerViewAdapter.MyViewHolder> {

    private List<Pet> listPets;

    class MyViewHolder extends SwipeToAction.ViewHolder {


        public TextView petName;
        public TextView petType;
        public TextView petStrain;
        public TextView petAge;


        MyViewHolder(View view) {
            super(view);

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
        Pet pet = listPets.get(position);
        holder.petName.setText(pet.getName());
        holder.petType.setText(pet.getPetType());
        holder.petStrain.setText(pet.getStrain());
        holder.petAge.setText(pet.getAge().toString());
        holder.data = pet;
    }

    @Override
    public int getItemCount() {
        return listPets.size();
    }

    public Pet getItemAt(int position) {
        return listPets.get(position);
    }

}
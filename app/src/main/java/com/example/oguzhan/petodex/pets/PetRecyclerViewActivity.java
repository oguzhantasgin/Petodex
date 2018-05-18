package com.example.oguzhan.petodex.pets;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.oguzhan.petodex.R;
import com.example.oguzhan.petodex.RecyclerItemClickListener;
import com.example.oguzhan.petodex.adapter.PetRecyclerViewAdapter;
import com.example.oguzhan.petodex.dao.IPetDAO;
import com.example.oguzhan.petodex.database.AppDatabase;

import java.util.ArrayList;
import java.util.List;

import co.dift.ui.SwipeToAction;

public class PetRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeToAction swipeToAction;
    private FloatingActionButton faButton;
    private IPetDAO dao;

    private static final int REQUEST_UPDATE_PET = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_recycler_view);
        initComponents();
        registerEventHandlers();
        bindData();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_UPDATE_PET) {
            if (resultCode == Activity.RESULT_OK) {
                bindData();
                Toast.makeText(PetRecyclerViewActivity.this, "Başarılı bir şekilde kaydedildi.", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void registerEventHandlers() {
        faButton_onClick();
    }

    private void bindData() {

        List<Pet> petList = dao.loadAllPets();
        ArrayList<Pet> pets = new ArrayList<>(petList);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        recyclerView.setLayoutParams(params);
        recyclerView.setHasFixedSize(true);

        final PetRecyclerViewAdapter adapter = new PetRecyclerViewAdapter(pets);

        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Pet pet = adapter.getItemAt(position);
                Intent intent = new Intent(PetRecyclerViewActivity.this, AddPetActivity.class);
                intent.putExtra("petId", pet.getId());
                startActivityForResult(intent, REQUEST_UPDATE_PET);
            }

            @Override
            public void onLongItemClick(View view, int position) {
            }
        }));

        swipeToAction = new SwipeToAction(recyclerView, new SwipeToAction.SwipeListener<Pet>() {

            @Override
            public boolean swipeLeft(Pet pet) {
                dao.deletePet(pet);
                finish();
                startActivity(getIntent());
                return false;
            }


            @Override
            public boolean swipeRight(Pet itemData) {
                return false;
            }

            @Override
            public void onClick(Pet pet) {


            }

            @Override
            public void onLongClick(Pet itemData) {

            }
        });
    }

    private void faButton_onClick() {

        faButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PetRecyclerViewActivity.this,AddPetActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private void initComponents() {
        recyclerView = findViewById(R.id.recyclerView);
        faButton = findViewById(R.id.floatingActionButton);
        AppDatabase appDatabase = AppDatabase.getAppDatabase(this);
        dao = appDatabase.getPetDAO();
    }

}

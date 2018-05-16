package com.example.oguzhan.petodex.pets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.oguzhan.petodex.R;
import com.example.oguzhan.petodex.RecyclerItemClickListener;
import com.example.oguzhan.petodex.adapter.PetRecyclerViewAdapter;
import com.example.oguzhan.petodex.dao.IPetDAO;
import com.example.oguzhan.petodex.database.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class PetRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private IPetDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_recycler_view);

        initComponents();
        bindData();
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
//                Pet pet = adapter.getItemAt(position);
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("petId", pet.getId());
//                setResult(RESULT_OK, returnIntent);
//                finish();
            }

            @Override
            public void onLongItemClick(View view, int position) {
            }
        }));
    }

    private void initComponents() {
        recyclerView = findViewById(R.id.recyclerView);

        AppDatabase appDatabase = AppDatabase.getAppDatabase(this);
        dao = appDatabase.getPetDAO();
    }

}

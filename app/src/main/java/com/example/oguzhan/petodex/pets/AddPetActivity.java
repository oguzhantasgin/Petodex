package com.example.oguzhan.petodex.pets;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.oguzhan.petodex.R;
import com.example.oguzhan.petodex.dao.IPetDAO;
import com.example.oguzhan.petodex.database.AppDatabase;

public class AddPetActivity extends AppCompatActivity {

    private EditText petName, petStrain, petAge, petType;
    private Button addButton;
    private IPetDAO dao;
    private int petId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);
        initComponents();
        registerEventHandlers();


    }

    private void registerEventHandlers() {

        addButton_onClick();
    }

    private void addButton_onClick() {

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = petName.getText().toString();
                String strain = petStrain.getText().toString();
                String type = petType.getText().toString();
                Integer age = Integer.parseInt(petAge.getText().toString());

                Pet pet = new Pet(name, strain, type, age);

                if (petId == -1) {
                    dao.insertPet(pet);
                } else {
                    pet.setId(petId);
                    dao.updatePet(pet);
                }

               /* Intent returnIntent = new Intent();
                setResult(RESULT_OK, returnIntent);
                finish();*/


               Intent intent = new Intent(AddPetActivity.this,PetRecyclerViewActivity.class);
               startActivity(intent);
               finish();

            }
        });

    }

    private void initComponents() {

        petName = findViewById(R.id.petAddNameEdit);
        petStrain = findViewById(R.id.petAddStrainEdit);
        petAge = findViewById(R.id.petAddAgeEdit);
        petType = findViewById(R.id.petAddTypeEdit);
        addButton = findViewById(R.id.addPet);

        AppDatabase appDatabase = AppDatabase.getAppDatabase(this);
        dao = appDatabase.getPetDAO();



//Güncelleme ya da ekleme

        Intent i = getIntent();
        petId = i.getIntExtra("petId", -1);
        if (petId != -1) {
            Pet pet = dao.loadPetById(petId);
            petName.setText(pet.getName());
            petStrain.setText(pet.getStrain());
            petAge.setText(pet.getAge());
            petType.setText(pet.getPetType());
        }


    }



    //Object method


   /* private Pet loadPet(Pet pet) {
        pet.setName(petName.getText().toString());
        pet.setAge(Integer.parseInt(petAge.getText().toString()));
        pet.setPetType(petType.getText().toString());
        pet.setStrain(petStrain.getText().toString());
        return pet;
    }*/
}

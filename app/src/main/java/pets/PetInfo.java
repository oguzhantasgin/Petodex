package pets;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.oguzhan.petodex.R;

public class PetInfo extends AppCompatActivity {

    private RecyclerView recyclerViewPet;
    private FloatingActionButton floatingActionButtonAddPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_info);
        initComponents();
    }


    private void initComponents() {

        recyclerViewPet = findViewById(R.id.recyclerViewPet);

    }


}

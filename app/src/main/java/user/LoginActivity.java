package user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.oguzhan.petodex.R;

import pets.PetInfo;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();
        registerEventHandlers();
    }

    private void registerEventHandlers() {

        loginButton_onClick();


    }


    private void initComponents() {
        loginButton = findViewById(R.id.button_signin);
    }

    private void loginButton_onClick() {

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, PetInfo.class);
                startActivity(intent);
            }
        });
    }
}

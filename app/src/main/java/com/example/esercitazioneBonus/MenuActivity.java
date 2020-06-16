//Alessandro Picchetti 65524


package com.example.esercitazioneBonus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.esercitazioneBonus.model.User;



public class MenuActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        SingletonArray singletonArray = SingletonArray.getInstance();
        User user = singletonArray.getCurrentUser();



        TextView userWelcome = findViewById(R.id.welcomeMessage);
        TextView userShow = findViewById(R.id.username_show);
        TextView passShow = findViewById(R.id.password_show);

        TextView cityShow = findViewById(R.id.city_show);
        TextView dateShow = findViewById(R.id.date_show);

        userWelcome.setText(getString(R.string.welcomeString, user.getUsername()));
        passShow.setText(getString(R.string.passwordShowString, user.getPassword()));
        cityShow.setText(getString(R.string.cityShowString, user.getCity()));
        userShow.setText(getString(R.string.usernameShowString, user.getUsername()));
        dateShow.setText(getString(R.string.dateShowString, user.getDate()));



        Button logoutButton = findViewById(R.id.logout_button);
        Button updatePassword = findViewById(R.id.modify_password_button);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
            }
        });

        updatePassword.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                startActivity(new Intent(MenuActivity.this, SettingsActivity.class));
            }
        });

    }
}
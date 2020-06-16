//Alessandro Picchetti 65524

package com.example.esercitazioneBonus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.esercitazioneBonus.model.User;

public class SettingsActivity extends AppCompatActivity {


    private User user;
    private SingletonArray singletonArray;
    private String newPass;
    private TextView passShow;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        singletonArray = SingletonArray.getInstance();
        user = singletonArray.getCurrentUser();

        TextView userShow = findViewById(R.id.username_show);
        passShow = findViewById(R.id.password_show);

        userShow.setText(getString(R.string.usernameShowString, user.getUsername()));
        passShow.setText(getString(R.string.passwordShowString, user.getPassword()));




        Button updatePassButton = findViewById(R.id.update_password);
        Button homeButton = findViewById(R.id.home_button);

        updatePassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText newPassEdit = findViewById(R.id.new_pass_input);
                EditText newPassSecondEdit= findViewById(R.id.new_pass_input_repeat);

                newPass = newPassEdit.getText().toString();
                String newPassSecond = newPassSecondEdit.getText().toString();

                if (newPass.equals(newPassSecond)){
                    user.setPassword(newPass);
                    singletonArray.findAndUpdateUser(user, newPass);
                    singletonArray.setCurrentUser(user);        //Aggiorna just in case
                    Toast t;
                    t = Toast.makeText(SettingsActivity.this, "Password aggiornata",   Toast.LENGTH_SHORT);
                    t.show();
                    passShow.setText(getString(R.string.passwordShowString, user.getPassword()));

                }

                else{
                    Toast t;
                    t = Toast.makeText(SettingsActivity.this, "Le nuove password non coincidono.",   Toast.LENGTH_SHORT);
                    t.show();                }
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this, MenuActivity.class));
            }
        });




    }


}
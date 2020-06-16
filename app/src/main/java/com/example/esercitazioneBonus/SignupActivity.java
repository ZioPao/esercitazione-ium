//Alessandro Picchetti 65524


package com.example.esercitazioneBonus;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.esercitazioneBonus.model.User;


import java.util.Calendar;



public class SignupActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{


    private Button loginButton;
    private Button registerButton;

    private EditText dateChoice;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_signup);


        loginButton = findViewById(R.id.login_button_from_register);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(SignupActivity.this, MainActivity.class));
            }
        });

        dateChoice = findViewById(R.id.date_choice);
        dateChoice.setFocusable(false);     //non è più editabile direttamente
        dateChoice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                showDatePicker();
            }

        });


        //Show toast stuff
        registerButton = findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseHeader.RegisterStatus status = createNewUser();

                if (status.equals(BaseHeader.RegisterStatus.OK)){
                    Toast t;
                    t = Toast.makeText(SignupActivity.this, "Registrazione effettuata con successo",   Toast.LENGTH_SHORT);
                    t.show();
                    goToLogin();

                }

                else{
                    Toast t;
                    t = Toast.makeText(SignupActivity.this, "Le password non coincidono!",   Toast.LENGTH_SHORT);
                    t.show();
                }

            }
        });





    }
    public BaseHeader.RegisterStatus createNewUser(){
        SingletonArray singleton = SingletonArray.getInstance();
        EditText editUsername = findViewById(R.id.username_register);
        EditText editPassword = findViewById(R.id.password_register);
        EditText editPasswordRepeat = findViewById(R.id.password_repeat);
        EditText editCity = findViewById(R.id.city_register);

        //Controlal che le pass siano uguali

        String password, passwordRepeat;

        password = editPassword.getText().toString();
        passwordRepeat = editPasswordRepeat.getText().toString();

        if (password.equals(passwordRepeat)){
            //Recupera altri dati e salva

            String username = editUsername.getText().toString();
            String city = editCity.getText().toString();
            String data = dateChoice.getText().toString();

            singleton.addUser(new User(username, password, city, data));

        }
        else{
            return BaseHeader.RegisterStatus.ERR_PASS;
        }
        return BaseHeader.RegisterStatus.OK;
    }
    public void goToLogin() {

        //singleton.addNames();
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putStringArrayListExtra("testArray",usernames);
       // Log.d("TEST", Integer.toString(singleton.usernames.size()));


        startActivity(intent);

    }


    private void showDatePicker(){
        DatePickerDialog dpd = new DatePickerDialog(this, this, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        dpd.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){

        dateChoice.setText(dayOfMonth + "/" + month + "/" + year);
    }
}


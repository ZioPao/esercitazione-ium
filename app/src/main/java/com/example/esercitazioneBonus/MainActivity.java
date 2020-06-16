//Alessandro Picchetti 65524

package com.example.esercitazioneBonus;

import com.example.esercitazioneBonus.BaseHeader.LoginStatus;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity{

   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       SingletonArray arrayTmp = new SingletonArray();      //La crea all'inizio dell'esecuzione
       setContentView(R.layout.activity_main);

       findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               login();
           }
       });

       findViewById(R.id.register_button).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               signup();
           }
       });
   }

    public void login() {
        SingletonArray singleton = SingletonArray.getInstance();

        EditText editUsername = findViewById(R.id.username);
        EditText editPassword = findViewById(R.id.password);

        String textUsername = editUsername.getText().toString();
        String textPassword = editPassword.getText().toString();
        LoginStatus check = singleton.checkLogin(textUsername, textPassword);
        Context context = getApplicationContext();

        Toast toast;

        switch(check){
            case OK:
                Intent intent =  new Intent(this, MenuActivity.class);
                startActivity(intent);
                break;
            case ERR_PASS:

                toast = Toast.makeText(context, "Password errata",   Toast.LENGTH_SHORT);
                toast.show();
                break;

            case ERR_USERNAME:
                toast = Toast.makeText(context, "Utente inesistente",   Toast.LENGTH_SHORT);
                toast.show();
                break;


        }
    }

    public void signup() {
        startActivity(new Intent(this, SignupActivity.class));


    }
}

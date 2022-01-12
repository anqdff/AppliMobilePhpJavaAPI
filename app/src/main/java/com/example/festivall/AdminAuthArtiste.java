package com.example.festivall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminAuthArtiste extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_auth_artiste);
        EditText PassAdmin= findViewById(R.id.editTextTextPassword11);
        Button ButtonValider = findViewById(R.id.Adminverifyy);

        ButtonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PassAdmin.getText().toString().equals("PassAdmin")){
                    Intent intent = new Intent(AdminAuthArtiste.this,AddArtiste.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Mot de passe incorrect Veuillez lire la doc le mot de passe se trouve là bas",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
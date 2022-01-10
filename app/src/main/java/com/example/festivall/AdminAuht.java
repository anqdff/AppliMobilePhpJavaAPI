package com.example.festivall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminAuht extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_auht);
        EditText PassAdmin= findViewById(R.id.editTextTextPassword1);
        Button ButtonValider = findViewById(R.id.Adminverify);

            ButtonValider.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (PassAdmin.getText().toString().equals("PassAdmin")){
                        Intent intent = new Intent(AdminAuht.this,CRUD.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Mot de passe incorrect",Toast.LENGTH_LONG).show();
                    }
                }
            });

    }



}
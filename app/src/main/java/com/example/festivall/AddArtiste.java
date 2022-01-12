package com.example.festivall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddArtiste extends AppCompatActivity {

    EditText nomA,PrenomA,NomARt,Age,Sexe,style,photo;
    String url="http://192.168.1.33/xampp/GestionFest/Android/InsertA.php";
    Button button, update,delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_artiste);
        nomA=findViewById(R.id.editTextTextPersonName2);
        PrenomA=findViewById(R.id.editTextTextPersonName3);
        NomARt=findViewById(R.id.editTextTextPersonName5);
        Age=findViewById(R.id.editTextTextPersonName6);
        Sexe=findViewById(R.id.editTextTextPersonName7);
        style=findViewById(R.id.editTextTextPersonName8);
        photo=findViewById(R.id.editTextTextPersonName9);
        button=findViewById(R.id.buttonAddArti);
        update=findViewById(R.id.ModifierArtis);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(AddArtiste.this,UpdateArtiste.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nom = nomA.getText().toString();
                String Prenom = PrenomA.getText().toString();
                String nomArtiste = NomARt.getText().toString();
                String age = Age.getText().toString();
                String sexe = Sexe.getText().toString();
                String styl = style.getText().toString();
                String phot = photo.getText().toString();
                if (nom.equals("") || Prenom.equals("") || nomArtiste.equals("") || age.equals("") || sexe.equals("") || styl.equals("") || phot.equals("") && button.isPressed()) {
                    Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs :( !", Toast.LENGTH_LONG).show();
                } else{
                    StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            nomA.setText("");
                            PrenomA.setText("");
                            NomARt.setText("");
                            Age.setText("");
                            Sexe.setText("");
                            style.setText("");
                            photo.setText("");

                            Toast.makeText(getApplicationContext(), "Artiste Ajouté !!", Toast.LENGTH_LONG).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> param = new HashMap<String, String>();
                            param.put("nom", nom);
                            param.put("prenom", Prenom);
                            param.put("nomArtiste", nomArtiste);
                            param.put("age", age);
                            param.put("sexe", sexe);
                            param.put("style", styl);
                            param.put("photo", phot);

                            return param;
                        }
                    };
                RequestQueue requestQueue = Volley.newRequestQueue(AddArtiste.this);
                requestQueue.add(request);
            }
            }
        });
    }
}
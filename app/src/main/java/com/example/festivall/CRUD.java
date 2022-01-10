package com.example.festivall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class CRUD extends AppCompatActivity {

    EditText nomET;
    EditText LieuET;
    EditText DatededebutET;
    EditText DescriptionET;
    EditText photoET;
    String Url="http://192.168.1.33/xampp/GestionFest/Android/InsertE.php";
    Button button;
    TextView tv ;
    TextView tv15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_r_u_d);
        nomET=findViewById(R.id.editTextTextPersonName);
        LieuET= findViewById(R.id.editTextTextlieu);
        DatededebutET= findViewById(R.id.editTextDate);
        DescriptionET = findViewById(R.id.editTextTextDescription);
        photoET= findViewById(R.id.editTextTextPersonName4);
        button= findViewById(R.id.button);
        tv=findViewById(R.id.textView14);
        tv15=findViewById(R.id.textView15);
        tv15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(CRUD.this,DeleteE.class);
                startActivity(intent1);
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(CRUD.this,UpdateE.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom=nomET.getText().toString();
                String lieu=LieuET.getText().toString();
                String datedebut=DatededebutET.getText().toString();
                String Description=DescriptionET.getText().toString();
                String photo= photoET.getText().toString();
                StringRequest request= new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        nomET.setText("");
                        LieuET.setText("");
                        DatededebutET.setText("");
                        DescriptionET.setText("");
                        photoET.setText("");
                        Toast.makeText(getApplicationContext(),"Evènement Ajouté dans la BDD",Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> param= new HashMap<String, String>();
                        param.put("nom", nom);
                        param.put("lieu",lieu);
                        param.put("datedebut",datedebut);
                        param.put("Description",Description);
                        param.put("photo",photo);

                        return param;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(CRUD.this);
                requestQueue.add(request);
            }
        });

    }
}
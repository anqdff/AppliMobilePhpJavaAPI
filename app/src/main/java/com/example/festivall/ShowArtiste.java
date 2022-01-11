package com.example.festivall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShowArtiste extends AppCompatActivity {
    RecyclerView recyclerView;
    String url="http://192.168.1.33/xampp/GestionFest/CRUD-METHODS/GetArtisteImage.php";
    List<ModelArtiste> imagelist;
    ModelArtiste modelArtiste;
    LinearLayoutManager linearLayoutManager;
    AdapterArtiste adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_artiste);
        recyclerView = findViewById(R.id.rg);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        imagelist= new ArrayList<>();
        adapter = new AdapterArtiste(this,imagelist);
        recyclerView.setAdapter(adapter);

        getimages();
    }
    public void getimages(){
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                imagelist.clear();
                try{
                    JSONObject jsonObjectb = new JSONObject(response);
                    String success=jsonObjectb.getString("success");
                    JSONArray jsonArray = jsonObjectb.getJSONArray("data");
                    if(success.equals("1")){
                        for (int i= 0;i<jsonArray.length();i++){
                            JSONObject object=jsonArray.getJSONObject(i);

                            String nom= "Nom:  "+object.getString("nom");
                            String prenom="Prenom:  "+ object.getString("prenom");
                            String nomArtiste= "Nom d'Artiste: "+object.getString("nomArtiste");
                            String age="Age:  "+ object.getString("age")+" ans";
                            String sexe= "Sexe:  "+object.getString("sexe");
                            String style= "Style:  "+object.getString("style");
                            String url2= object.getString("photo");
                            String urlimage="http://192.168.1.33/xampp/GestionFest/ImagesArtistes/"+url2;


                            modelArtiste= new ModelArtiste(nom,prenom,nomArtiste,age,sexe,style,urlimage);
                            imagelist.add(modelArtiste);
                            adapter.notifyDataSetChanged();

                        }
                    }
                }catch(Exception e){

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ShowArtiste.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(ShowArtiste.this);
        requestQueue.add(request);
    }
}
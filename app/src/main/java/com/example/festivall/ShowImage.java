package com.example.festivall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Display;
import android.widget.LinearLayout;
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


public class ShowImage extends AppCompatActivity {
    RecyclerView recyclerView;
    String url="http://192.168.1.33/xampp/GestionFest/CRUD-METHODS/GetImage.php";
    List<Model> imagelist;
    Model model;
    LinearLayoutManager linearLayoutManager;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        recyclerView = findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        imagelist= new ArrayList<>();
        adapter = new Adapter(this,imagelist);
        recyclerView.setAdapter(adapter);

        getimages();




    }

    private void getimages() {

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

                            String nom= object.getString("nom");
                            String lieu= object.getString("lieu");
                            String datedebut= object.getString("datedebut");
                            String Description= object.getString("Description");
                            String url2= object.getString("photo");
                            String urlimage="http://192.168.1.33/xampp/GestionFest/Images/"+url2;


                            model= new Model(nom,lieu,datedebut,Description,urlimage);
                            imagelist.add(model);
                            adapter.notifyDataSetChanged();

                        }
                    }
                }catch(Exception e){

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ShowImage.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(ShowImage.this);
        requestQueue.add(request);
    }
}
package com.example.festivall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Showdata extends AppCompatActivity {
    ListView listView;
    Myadapter myadapter;
    dataclass dataclass;
    String Url="http://192.168.1.33/xampp/GestionFest/CRUD-METHODS/ReadEvent.php";
    public static ArrayList<dataclass>dataclassArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);

        listView=findViewById(R.id.listview);
        myadapter=new Myadapter(this,dataclassArrayList);
        listView.setAdapter(myadapter);
        getData();

    }

    private void getData() {
        StringRequest request = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                dataclassArrayList.clear();
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
                            String photo= object.getString("photo");
                            dataclass= new dataclass(nom,lieu,datedebut,Description,photo);
                            dataclassArrayList.add(dataclass);
                            myadapter.notifyDataSetChanged();

                        }
                    }
                }catch(Exception e){

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Showdata.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(Showdata.this);
        requestQueue.add(request);
    }
}
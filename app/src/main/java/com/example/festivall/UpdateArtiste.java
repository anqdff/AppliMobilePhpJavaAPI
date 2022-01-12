package com.example.festivall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UpdateArtiste extends AppCompatActivity {

    EditText nomA,prenomA,nomArtisteA,ageA,SexeA,styleA,photoA,idA;
    Button button;
    TextView g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_artiste);
        nomA=findViewById(R.id.editTextTextPersonName22);
        prenomA=findViewById(R.id.editTextTextPersonName33);
        nomArtisteA=findViewById(R.id.editTextTextPersonName55);
        ageA=findViewById(R.id.editTextTextPersonName66);
        SexeA=findViewById(R.id.editTextTextPersonName77);
        styleA=findViewById(R.id.editTextTextPersonName88);
        photoA=findViewById(R.id.editTextTextPersonName99);
        idA=findViewById(R.id.editTextTextPersonName100);
        button=findViewById(R.id.ModifierArtiss);
        g=findViewById(R.id.gg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);

                    OkHttpClient client = new OkHttpClient();

                    HttpUrl.Builder urlBuilder = HttpUrl.parse("http://192.168.1.33/xampp/GestionFest/Android/UpdateA.php").newBuilder();
                    urlBuilder.addQueryParameter("id", idA.getText().toString());
                    urlBuilder.addQueryParameter("nom", nomA.getText().toString());
                    urlBuilder.addQueryParameter("prenom", prenomA.getText().toString());
                    urlBuilder.addQueryParameter("nomArtiste", nomArtisteA.getText().toString());
                    urlBuilder.addQueryParameter("age", ageA.getText().toString());
                    urlBuilder.addQueryParameter("sexe", SexeA.getText().toString());
                    urlBuilder.addQueryParameter("style", styleA.getText().toString());
                    urlBuilder.addQueryParameter("photo", photoA.getText().toString());



                    String url = urlBuilder.build().toString();

                    Request request = new Request.Builder()
                            .url(url)
                            .build();

                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, final Response response) throws IOException {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    try {
                                        g.setText(response.body().string());
                                        Toast.makeText(getApplicationContext(), "Artiste Modifié !!", Toast.LENGTH_LONG).show();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                }
                            });
                        }

                        ;
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
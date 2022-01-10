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
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UpdateE extends AppCompatActivity {

    EditText nomETup;
    EditText LieuETup;
    EditText DatededebutETup;
    EditText DescriptionETup;
    EditText photoETup;
    EditText idup;
    Button buttonu;
    TextView updatetex;
    //String Url="http://192.168.1.33/xampp/GestionFest/Android/UpdateE.php ";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_e);
        nomETup=findViewById(R.id.upname);
        LieuETup= findViewById(R.id.uplieu);
        DatededebutETup=findViewById(R.id.update);
        DescriptionETup=findViewById(R.id.updescription);
        photoETup= findViewById(R.id.editTex);
        idup= findViewById(R.id.editTextTextidup);
        buttonu= findViewById(R.id.buttonup);
        updatetex=findViewById(R.id.UpdateText);
        buttonu.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                try {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);

                    OkHttpClient client = new OkHttpClient();

                    HttpUrl.Builder urlBuilder = HttpUrl.parse("http://192.168.1.33/xampp/GestionFest/Android/UpdateE.php").newBuilder();
                    urlBuilder.addQueryParameter("id", idup.getText().toString());
                    urlBuilder.addQueryParameter("nom", nomETup.getText().toString());
                    urlBuilder.addQueryParameter("lieu", LieuETup.getText().toString());
                    urlBuilder.addQueryParameter("datedebut", DatededebutETup.getText().toString());
                    urlBuilder.addQueryParameter("Description", DescriptionETup.getText().toString());
                    urlBuilder.addQueryParameter("photo", photoETup.getText().toString());



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
                                        updatetex.setText(response.body().string());
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
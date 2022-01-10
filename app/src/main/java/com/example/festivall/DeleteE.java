package com.example.festivall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DeleteE extends AppCompatActivity {
    EditText idEventAsupprimer;
    Button SuprimerEvent;
    TextView Etatsuppression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_e);
        Etatsuppression=findViewById(R.id.EtatSuppressionn);
        idEventAsupprimer= findViewById(R.id.DeleteEventEditext);
        SuprimerEvent= findViewById(R.id.deleteButtonEv);
        SuprimerEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);

                    OkHttpClient client = new OkHttpClient();

                    HttpUrl.Builder urlBuilder = HttpUrl.parse("http://192.168.1.33/xampp/GestionFest/Android/DeleteE.php").newBuilder();
                    urlBuilder.addQueryParameter("id", idEventAsupprimer.getText().toString());

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
                                        Etatsuppression.setText(response.body().string());
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
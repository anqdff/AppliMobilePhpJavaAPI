package com.example.festivall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class Myadapter extends ArrayAdapter<dataclass> {


    Context context;
    List<dataclass> dataclassList;


    public Myadapter(@NonNull Context context,List<dataclass>dataclasses) {
        super(context,R.layout.data_item,dataclasses);
        this.context=context;
        this.dataclassList=dataclasses;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item,null,true);
        TextView nom=view.findViewById(R.id.nom);
        TextView lieu=view.findViewById(R.id.lieu);
        TextView datedebut=view.findViewById(R.id.datedebut);
        TextView Description=view.findViewById(R.id.Description);
        TextView photo = view.findViewById(R.id.photo);
        nom.setText(dataclassList.get(position).getNom());
        lieu.setText(dataclassList.get(position).getLieu());
        datedebut.setText(dataclassList.get(position).getDatedebut());
        Description.setText(dataclassList.get(position).getDescription());
        photo.setText(dataclassList.get(position).getPhoto());


        return view;
    }
}

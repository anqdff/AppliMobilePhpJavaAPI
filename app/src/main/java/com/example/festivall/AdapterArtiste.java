package com.example.festivall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterArtiste extends  RecyclerView.Adapter<ImageViewHolderr> {
    private Context contextt;
    private List<ModelArtiste> imagelistt;

    public AdapterArtiste(Context contextt, List<ModelArtiste> imagelistt) {
        this.contextt = contextt;
        this.imagelistt = imagelistt;
    }


    @NonNull
    @Override
    public ImageViewHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artiste_image_show,parent,false);
        return new ImageViewHolderr(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolderr holderr, int position) {

        Glide.with(contextt).load(imagelistt.get(position).getPhoto()).into(holderr.imageViewww);
        holderr.nom.setText(imagelistt.get(position).getNom());
        holderr.prenom.setText(imagelistt.get(position).getPrenom());
        holderr.nomArtiste.setText(imagelistt.get(position).getNomArtiste());
        holderr.age.setText(imagelistt.get(position).getAge());
        holderr.sexe.setText(imagelistt.get(position).getSexe());
        holderr.style.setText(imagelistt.get(position).getStyle());

    }

    @Override
    public int getItemCount() {

        return imagelistt.size();
    }
}
class ImageViewHolderr extends RecyclerView.ViewHolder{
    TextView nom,prenom,nomArtiste,age,sexe,style;
    ImageView imageViewww;

    public ImageViewHolderr(@NonNull View itemVieww) {
        super(itemVieww);
        imageViewww= itemVieww.findViewById(R.id.iv_retrievee);
        nom=itemVieww.findViewById(R.id.nomss);
        prenom=itemVieww.findViewById(R.id.prenommmm);
        nomArtiste=itemVieww.findViewById(R.id.nomArtisteee);
        age=itemVieww.findViewById(R.id.ageee);
        sexe=itemVieww.findViewById(R.id.sexeee);
        style=itemVieww.findViewById(R.id.styleee);

    }
}


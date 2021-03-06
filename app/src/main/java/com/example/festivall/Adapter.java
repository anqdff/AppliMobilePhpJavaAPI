package com.example.festivall;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ImageViewHolder> {

    private Context context;
    private List<Model> imagelist;

    public Adapter(Context context, List<Model> imagelist) {
        this.context = context;
        this.imagelist = imagelist;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_iv,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {


        Glide.with(context).load(imagelist.get(position).getImage()).into(holder.imageView);
        holder.nom.setText(imagelist.get(position).getNom());
        holder.lieu.setText(imagelist.get(position).getLieu());
        holder.datedebut.setText(imagelist.get(position).getDatedebut());
        holder.description.setText(imagelist.get(position).getDescription());
    }

    @Override
    public int getItemCount() {

        return imagelist.size();
    }
}
class ImageViewHolder extends RecyclerView.ViewHolder{
    TextView nom,lieu,datedebut,description;
    ImageView imageView;

    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView= itemView.findViewById(R.id.iv_retrieve);
        nom=itemView.findViewById(R.id.noms);
        lieu=itemView.findViewById(R.id.lieux);
        datedebut=itemView.findViewById(R.id.datesdebut);
        description=itemView.findViewById(R.id.descriptions);

    }
}

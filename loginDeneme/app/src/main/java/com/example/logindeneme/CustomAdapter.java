package com.example.logindeneme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList paylasim_id, paylasim_konu, paylasim_durum, paylasim_sayi;

    CustomAdapter(Activity activity, Context context, ArrayList paylasim_id, ArrayList paylasim_konu, ArrayList paylasim_durum,
                  ArrayList paylasim_sayi){
        this.activity = activity;
        this.context = context;
        this.paylasim_id = paylasim_id;
        this.paylasim_konu =paylasim_konu;
        this.paylasim_durum = paylasim_durum;
        this.paylasim_sayi = paylasim_sayi;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.paylasim_id_txt.setText(String.valueOf(paylasim_id.get(position)));
        holder.paylasim_konu_txt.setText(String.valueOf(paylasim_konu.get(position)));
        holder.paylasim_durum_txt.setText(String.valueOf(paylasim_durum.get(position)));
        holder.paylasim_sayi_txt.setText(String.valueOf(paylasim_sayi.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(paylasim_id.get(position)));
                intent.putExtra("konu", String.valueOf(paylasim_konu.get(position)));
                intent.putExtra("durum", String.valueOf(paylasim_durum.get(position)));
                intent.putExtra("sayi", String.valueOf(paylasim_sayi.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return paylasim_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView paylasim_id_txt, paylasim_konu_txt, paylasim_durum_txt, paylasim_sayi_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
           paylasim_id_txt = itemView.findViewById(R.id.paylasim_id_txt);
            paylasim_konu_txt = itemView.findViewById(R.id.paylasim_konu_txt);
            paylasim_durum_txt= itemView.findViewById(R.id.paylasim_durum_txt);
            paylasim_sayi_txt = itemView.findViewById(R.id.paylasim_sayi_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
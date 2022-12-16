package com.example.odevdeneme;

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
    private ArrayList durum_id, durum_konu, durum_durum, durum_sayi;

    CustomAdapter(Activity activity, Context context, ArrayList durum_id, ArrayList durum_konu, ArrayList durum_durum,
                  ArrayList book_pages){
        this.activity = activity;
        this.context = context;
        this.durum_id = durum_id;
        this.durum_konu = durum_konu;
        this.durum_durum = durum_durum;
        this.durum_sayi = durum_sayi;
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
        holder.durum_id_txt.setText(String.valueOf(durum_id.get(position)));
        holder.durum_konu_txt.setText(String.valueOf(durum_konu.get(position)));
        holder.durum_durum_txt.setText(String.valueOf(durum_durum.get(position)));
        holder.durum_sayi_txt.setText(String.valueOf(durum_sayi.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(durum_id.get(position)));
                intent.putExtra("konu", String.valueOf(durum_konu.get(position)));
                intent.putExtra("durum", String.valueOf(durum_durum.get(position)));
                intent.putExtra("sayi", String.valueOf(durum_sayi.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return durum_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView durum_id_txt, durum_konu_txt, durum_durum_txt, durum_sayi_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            durum_id_txt = itemView.findViewById(R.id.durum_id_txt);
            durum_konu_txt = itemView.findViewById(R.id.durum_konu_txt);
            durum_durum_txt = itemView.findViewById(R.id.durum_durum_txt);
            durum_sayi_txt = itemView.findViewById(R.id.durum_sayi_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
package com.example.spiderproj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;

import java.util.List;

public class heroes_recycler_adapter extends RecyclerView.Adapter<heroes_recycler_adapter.MyViewHolder>{
    Context context;
    List<heroesDetails> heroes;

    public heroes_recycler_adapter(Context ctx, List<heroesDetails> data){
        this.context = ctx;
        this.heroes = data;
    }
    @NonNull
    @Override
    public heroes_recycler_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View recycledItems = inflater.inflate(R.layout.recycler_product,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(recycledItems);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull heroes_recycler_adapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context)
                .asBitmap()
                .load(heroes.get(position).getImg())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(BitmapTransitionOptions.withCrossFade())
                .into(holder.imageView);

      holder.Name.setText(heroes.get(position).getName());
        holder.realName.setText(heroes.get(position).getRaelname());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Detaile.class);
                intent.putExtra("name",heroes.get(position).getName());
                intent.putExtra("realname",heroes.get(position).getRaelname());
                intent.putExtra("bio",heroes.get(position).getBio());
                intent.putExtra("team",heroes.get(position).getTeam());
                intent.putExtra("Imageurl",heroes.get(position).getImg());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView realName;
        public TextView Name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView=itemView.findViewById(R.id.img);
            this.realName = itemView.findViewById(R.id.RealName);
            this. Name= itemView.findViewById(R.id.name);
        }
    }
}

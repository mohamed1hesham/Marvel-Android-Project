package com.example.spiderproj;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;

public class PageDetailed extends AppCompatActivity {
    TextView name,realname,desc,team;
    String HeroName,RealName,Desc,Team,image;
    ImageView imge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i=getIntent();
        setContentView(R.layout.detailed_page);
        name=findViewById(R.id.name);
        realname=findViewById(R.id.real_name);

        desc=findViewById(R.id.desc);
        team=findViewById(R.id.team);
        imge=findViewById(R.id.img);



        HeroName=i.getStringExtra("name");
        RealName=i.getStringExtra("realname");
        Desc=i.getStringExtra("bio");
        image=i.getStringExtra("imageurl");
        Team=i.getStringExtra("team");

        name.setText(HeroName);
        realname.setText(RealName);

        desc.setText(Desc);
        team.setText(Team);

        Glide.with(this)
                .asBitmap()
                .load(image)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(BitmapTransitionOptions.withCrossFade())
                .into(imge);






    }
}

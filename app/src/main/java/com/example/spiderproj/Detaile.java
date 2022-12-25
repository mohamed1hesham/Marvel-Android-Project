package com.example.spiderproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;

public class Detaile extends AppCompatActivity {
    TextView name,realname,desc,team;
    String Hero_Name,RealName,Desc,Team,image;
    ImageView imge;
    ImageButton imgbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaile);
        name=findViewById(R.id.name);
        realname=findViewById(R.id.real_name);
        desc=findViewById(R.id.desc);
        team=findViewById(R.id.team);
        imge=findViewById(R.id.immm1);
        imgbtn=findViewById(R.id.img_btn);
        Intent i=getIntent();
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Hero_Name=i.getStringExtra("name");
        RealName=i.getStringExtra("realname");
        Desc=i.getStringExtra("bio");
        Team=i.getStringExtra("team");
        image=i.getStringExtra("Imageurl");
        name.setText(Hero_Name);
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
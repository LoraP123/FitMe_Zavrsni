package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class LegsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);

        ImageView gifImageView1111 = findViewById(R.id.legs1);
        ImageView gifImageView2222 = findViewById(R.id.legs2);
        ImageView gifImageView3333 = findViewById(R.id.legs3);
        ImageView gifImageView4444 = findViewById(R.id.legs4);
        ImageView gifImageView5555 = findViewById(R.id.legs5);
        ImageView gifImageView6666 = findViewById(R.id.legs6);

        Glide.with(this)
                .asGif()
                .load(R.drawable.legs1)
                .into(gifImageView1111);

        Glide.with(this)
                .asGif()
                .load(R.drawable.legs2)
                .into(gifImageView2222);

        Glide.with(this)
                .asGif()
                .load(R.drawable.legs3)
                .into(gifImageView3333);

        Glide.with(this)
                .asGif()
                .load(R.drawable.legs4)
                .into(gifImageView4444);

        Glide.with(this)
                .asGif()
                .load(R.drawable.legs5)
                .into(gifImageView5555);
        Glide.with(this)
                .asGif()
                .load(R.drawable.legs6)
                .into(gifImageView6666);
    }
}
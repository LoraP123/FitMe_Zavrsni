package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ArmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arms);

        ImageView gifImageView11 = findViewById(R.id.arms1);
        ImageView gifImageView22 = findViewById(R.id.arms2);
        ImageView gifImageView33 = findViewById(R.id.arms3);
        ImageView gifImageView44 = findViewById(R.id.arms4);
        ImageView gifImageView55 = findViewById(R.id.arms5);
        ImageView gifImageView66 = findViewById(R.id.arms6);
        ImageView gifImageView77 = findViewById(R.id.arms7);

        Glide.with(this)
                .asGif()
                .load(R.drawable.arms1)
                .into(gifImageView11);

        Glide.with(this)
                .asGif()
                .load(R.drawable.arms2)
                .into(gifImageView22);

        Glide.with(this)
                .asGif()
                .load(R.drawable.arms3)
                .into(gifImageView33);

        Glide.with(this)
                .asGif()
                .load(R.drawable.arms4)
                .into(gifImageView44);

        Glide.with(this)
                .asGif()
                .load(R.drawable.arms5)
                .into(gifImageView55);
        Glide.with(this)
                .asGif()
                .load(R.drawable.arms6)
                .into(gifImageView66);
        Glide.with(this)
                .asGif()
                .load(R.drawable.arms7)
                .into(gifImageView77);
    }
}
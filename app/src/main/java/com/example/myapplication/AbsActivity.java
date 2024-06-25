package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class AbsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs);

        ImageView gifImageView1 = findViewById(R.id.abs1);
        ImageView gifImageView2 = findViewById(R.id.abs2);
        ImageView gifImageView3 = findViewById(R.id.abs3);
        ImageView gifImageView4 = findViewById(R.id.abs4);
        ImageView gifImageView5 = findViewById(R.id.abs5);

        Glide.with(this)
                .asGif()
                .load(R.drawable.abs1)
                .into(gifImageView1);

        Glide.with(this)
                .asGif()
                .load(R.drawable.abs2)
                .into(gifImageView2);

        Glide.with(this)
                .asGif()
                .load(R.drawable.abs3)
                .into(gifImageView3);

        Glide.with(this)
                .asGif()
                .load(R.drawable.abs4)
                .into(gifImageView4);

        Glide.with(this)
                .asGif()
                .load(R.drawable.abs5)
                .into(gifImageView5);
    }
}
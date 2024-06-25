package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class BackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        ImageView gifImageView111 = findViewById(R.id.back1);
        ImageView gifImageView222 = findViewById(R.id.back2);
        ImageView gifImageView333 = findViewById(R.id.back3);
        ImageView gifImageView444 = findViewById(R.id.back4);
        ImageView gifImageView555 = findViewById(R.id.back5);
        ImageView gifImageView666 = findViewById(R.id.back6);

        Glide.with(this)
                .asGif()
                .load(R.drawable.back1)
                .into(gifImageView111);

        Glide.with(this)
                .asGif()
                .load(R.drawable.back2)
                .into(gifImageView222);

        Glide.with(this)
                .asGif()
                .load(R.drawable.back3)
                .into(gifImageView333);

        Glide.with(this)
                .asGif()
                .load(R.drawable.back4)
                .into(gifImageView444);

        Glide.with(this)
                .asGif()
                .load(R.drawable.back5)
                .into(gifImageView555);
        Glide.with(this)
                .asGif()
                .load(R.drawable.back6)
                .into(gifImageView666);
    }
}
package com.example.tiktoktoe;

import static com.example.tiktoktoe.R.layout.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FrontActivity extends AppCompatActivity {

    public void mainPage(View view){
        Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_front);
        ImageView frontImage=(ImageView) findViewById(R.id.imageView);
        frontImage.setTranslationY(-1000f);
        frontImage.animate().rotation(360f).translationYBy(1000f).setDuration(2000);
        TextView btn =(TextView) findViewById(R.id.button2);
        btn.setTranslationX(-1000f);
        btn.animate().translationXBy(1000f).setDuration(1500);
    }
}
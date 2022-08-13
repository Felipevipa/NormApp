package com.normapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void navigate(View a) {
        String Estado=a.getTag().toString();
        Intent intent = new Intent(this, MainActivity.class);
        Bundle b = new Bundle();
        b.putInt("key", Integer.parseInt(Estado)); //Your id
        intent.putExtras(b); //Put your id to your next Intent
        startActivity(intent);
        finish();

    }
}
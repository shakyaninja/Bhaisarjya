package com.project.bhaisarjya.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.bhaisarjya.R;
import com.project.bhaisarjya.fragments.Imports;
import com.project.bhaisarjya.fragments.Medicines;
import com.project.bhaisarjya.fragments.Sales;

public class SecondaryActivity extends AppCompatActivity {
    private int fragmentManager;
    private int choice;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_activity);
        choice = (int) getIntent().getIntExtra("id",0);
        switch (choice){
            case 1:
                fragmentManager = getSupportFragmentManager().beginTransaction().addToBackStack(String.valueOf(true)).replace(R.id.container1,new Medicines()).commit();
                break;
            case 2:
                fragmentManager = getSupportFragmentManager().beginTransaction().addToBackStack(String.valueOf(true)).replace(R.id.container1,new Sales()).commit();
                break;
            case 3:
                fragmentManager = getSupportFragmentManager().beginTransaction().addToBackStack(String.valueOf(true)).replace(R.id.container1,new Imports()).commit();
                break;
        }
    }
}

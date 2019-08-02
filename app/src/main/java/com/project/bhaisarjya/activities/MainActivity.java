package com.project.bhaisarjya.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.project.bhaisarjya.R;
import com.project.bhaisarjya.adapters.SectionsPageAdapters;
import com.project.bhaisarjya.fragments.CheckExpiry;
import com.project.bhaisarjya.fragments.CheckStatement;
import com.project.bhaisarjya.fragments.Welcome;

public class MainActivity extends AppCompatActivity {
    private int fragmentManager;
    private FloatingActionButton floatingActionButtonMedicine;
    private FloatingActionButton floatingActionButtonAdd;
    private FloatingActionButton floatingActionButtonClose;
    private FloatingActionButton floatingActionButtonAddSales;
    private FloatingActionButton floatingActionButtonAddImports;
    private FloatingActionButton floatingActionButtonCheckExpiry;
    private static final String TAG = "MainActivity";
    private SectionsPageAdapters mSectionsPageAdapter;
    private ViewPager mViewPager;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapters(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        floatingActionButtonAdd = findViewById(R.id.open);
        floatingActionButtonMedicine = findViewById(R.id.medicineinfo);
        floatingActionButtonClose = findViewById(R.id.close);
        floatingActionButtonAddSales = findViewById(R.id.addsales);
        floatingActionButtonAddImports = findViewById(R.id.addimports);
        floatingActionButtonCheckExpiry = findViewById(R.id.expiry);
        floatingActionButtonAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                floatingActionButtonAddSales.setVisibility(View.VISIBLE);
                floatingActionButtonAdd.setVisibility(View.INVISIBLE);
                floatingActionButtonClose.setVisibility(View.VISIBLE);
                floatingActionButtonAddImports.setVisibility(View.VISIBLE);
                floatingActionButtonCheckExpiry.setVisibility(View.VISIBLE);
                floatingActionButtonMedicine.setVisibility(View.VISIBLE);
            }
        });
        floatingActionButtonAddSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent extraintent=new Intent(MainActivity.this,SecondaryActivity.class);
                extraintent.putExtra("id",2);
                startActivity(extraintent);
            }
        });
        floatingActionButtonAddImports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent extraintent=new Intent(MainActivity.this,SecondaryActivity.class);
                extraintent.putExtra("id",3);
                startActivity(extraintent);
            }
        });
        floatingActionButtonMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent extraintent=new Intent(MainActivity.this,SecondaryActivity.class);
                extraintent.putExtra("id",1);
                startActivity(extraintent);
            }
        });
        floatingActionButtonClose.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                floatingActionButtonAddSales.setVisibility(View.INVISIBLE);
                floatingActionButtonAdd.setVisibility(View.VISIBLE);
                floatingActionButtonClose.setVisibility(View.INVISIBLE);
                floatingActionButtonAddImports.setVisibility(View.INVISIBLE);
                floatingActionButtonCheckExpiry.setVisibility(View.INVISIBLE);
                floatingActionButtonMedicine.setVisibility(View.INVISIBLE);
            }
        });
        floatingActionButtonCheckExpiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapters adapter = new SectionsPageAdapters(getSupportFragmentManager());
        adapter.addFragment(new Welcome(), "Home");
        adapter.addFragment(new CheckExpiry(), "Check Expiry");
        adapter.addFragment(new CheckStatement(), "Statement");
        viewPager.setAdapter(adapter);
    }
}
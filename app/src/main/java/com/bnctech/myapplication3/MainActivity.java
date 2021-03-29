package com.bnctech.myapplication3;


import android.content.Context;

import android.os.Bundle;



import android.view.View;

import android.view.animation.Animation;

import android.view.animation.AnimationUtils;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;



    private FloatingActionButton fab_main, fab_sub1, fab_sub2;

    private Animation fab_open, fab_close, fab_rotate;

    private boolean isFabOpen = false;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();



        fab_open = AnimationUtils.loadAnimation(mContext, R.anim.fab_open);

        fab_close = AnimationUtils.loadAnimation(mContext, R.anim.fab_close);

        fab_rotate = AnimationUtils.loadAnimation(mContext, R.anim.fab_rotate);



        fab_main = (FloatingActionButton) findViewById(R.id.fab_main);

        fab_sub1 = (FloatingActionButton) findViewById(R.id.fab_sub1);

        fab_sub2 = (FloatingActionButton) findViewById(R.id.fab_sub2);



        fab_main.setOnClickListener(this);

        fab_sub1.setOnClickListener(this);

        fab_sub2.setOnClickListener(this);

    }



    @Override

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.fab_main:

                toggleFab();
                fab_main.startAnimation(fab_rotate);

                break;

            case R.id.fab_sub1:

                toggleFab();

                Toast.makeText(this, "Camera Open-!", Toast.LENGTH_SHORT).show();

                break;



            case R.id.fab_sub2:

                toggleFab();

                Toast.makeText(this, "Map Open-!", Toast.LENGTH_SHORT).show();

                break;

        }

    }



    private void toggleFab() {

        if (isFabOpen) {

//            fab_main.setImageResource(R.drawable.ic_add);

            fab_sub1.startAnimation(fab_close);

            fab_sub2.startAnimation(fab_close);

            fab_sub1.setClickable(false);

            fab_sub2.setClickable(false);

            isFabOpen = false;

        } else {

//            fab_main.setImageResource(R.drawable.ic_close);

            fab_sub1.startAnimation(fab_open);

            fab_sub2.startAnimation(fab_open);

            fab_sub1.setClickable(true);

            fab_sub2.setClickable(true);

            isFabOpen = true;

        }

    }

}
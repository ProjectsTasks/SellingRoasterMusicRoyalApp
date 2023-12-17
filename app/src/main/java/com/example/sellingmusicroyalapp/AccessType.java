package com.example.sellingmusicroyalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.ViewportHint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccessType extends AppCompatActivity {

    Button reg, logn;
    String ff1;
    public static final String SHARED_PREFS= "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_type);

        reg= (Button) findViewById(R.id.reg);
        logn= (Button) findViewById(R.id.logn);

        checkBox();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(AccessType.this, Register.class));
                    finish();
            }
        });

        logn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(AccessType.this, Login.class));
                    finish();

            }
        });

    }

    private void checkBox() {
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String check= sharedPreferences.getString("name", "");

        if (check.equals("true")){
                startActivity(new Intent(AccessType.this, HomePage.class));
                finish();

        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
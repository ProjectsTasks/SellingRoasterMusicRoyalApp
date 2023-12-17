package com.example.sellingmusicroyalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyMusic extends AppCompatActivity {
    EditText credit;
    Button confirm, back;
    String u_credit;
    TextView ms_name2;
    String getM;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_music);

        credit= findViewById(R.id.credit2);
        confirm= findViewById(R.id.confirm2);
        back= findViewById(R.id.back2);
        ms_name2= findViewById(R.id.ms_name2);

        if (getIntent().hasExtra("getM")) {
            getM = getIntent().getStringExtra("getM");
            ms_name2.setText("Music "+getM);
        }

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    Toast.makeText(
                            BuyMusic.this, "Music Purchase Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMusic.this, HomePage.class));
                    finish();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMusic.this, SellMusic.class));
                finish();
            }
        });
    }

    private Boolean validate(){
        boolean result= false;

        u_credit = credit.getText().toString();
        if(u_credit.isEmpty()){
            Toast.makeText(this, "Please enter Credit Card number to pay", Toast.LENGTH_SHORT).show();
        }else {
            result= true;
        }
        return result;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(BuyMusic.this, SellMusic.class));
        finish();
    }
}
package com.example.sellingmusicroyalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SellRoaster extends AppCompatActivity {

    EditText credit;
    Button confirm, back;
    String u_credit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_roaster);

        credit= findViewById(R.id.credit);
        confirm= findViewById(R.id.confirm);
        back= findViewById(R.id.back1);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    Toast.makeText(
                            SellRoaster.this, "Roaster Purchase Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SellRoaster.this, HomePage.class));
                    finish();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SellRoaster.this, HomePage.class));
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
        startActivity(new Intent(SellRoaster.this, HomePage.class));
        finish();
    }
}
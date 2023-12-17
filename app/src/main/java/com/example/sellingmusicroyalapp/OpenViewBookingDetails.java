package com.example.sellingmusicroyalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class OpenViewBookingDetails extends AppCompatActivity {

    TextView t_name, t_price;
    ImageView img;
    Button back;

    String getPic;
    String pic1="Hassan Thani Bait Nasib"; String pic2="Mohammed Ahsan"; String pic3="Hina Mukhtar";
    String pic4="Hajra Nasir";  String pic5="Usman Abid";

    private int Request_Code= 234;
    private Uri filepath;
    private StorageReference storageReference;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    String u_name, u_price;
    String getKey;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_view_booking_details);

        t_name= findViewById(R.id.t_name2);
        t_price= findViewById(R.id.t_price2);
        img= findViewById(R.id.img2);
        back= findViewById(R.id.back);

        if (getIntent().hasExtra("key")) {

            getKey= getIntent().getStringExtra("key");
        }

        firebaseAuth= FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseReference= FirebaseDatabase.getInstance().getReference("Bookings").child(user.getUid()).child("image").child(getKey);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                   UserBooking userBooking= snapshot.getValue(UserBooking.class);
                   t_name.setText(userBooking.getBookingName());
                   t_price.setText(userBooking.getBookingPrice());

                   u_name= t_name.getText().toString();

                   if (u_name.equals(pic1)){
                       img.setImageResource(R.drawable.t1);
                   }

                    if (u_name.equals(pic2)){
                        img.setImageResource(R.drawable.t2);
                    }

                    if (u_name.equals(pic3)){
                        img.setImageResource(R.drawable.t3);
                    }

                    if (u_name.equals(pic4)){
                        img.setImageResource(R.drawable.t4);
                    }

                    if (u_name.equals(pic5)){
                        img.setImageResource(R.drawable.t5);
                    }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(OpenViewBookingDetails.this, ViewBooking.class));
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(OpenViewBookingDetails.this, ViewBooking.class));
        finish();
    }
}
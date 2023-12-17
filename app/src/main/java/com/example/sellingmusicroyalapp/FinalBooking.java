package com.example.sellingmusicroyalapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class FinalBooking extends AppCompatActivity {
    TextView t_name, t_price;
    ImageView img;
    Button confirm;

    String getPic;
    String pic1="1"; String pic2="2"; String pic3="3";  String pic4="4";  String pic5="5";

    private int Request_Code= 234;
    private Uri filepath;
    private StorageReference storageReference;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    String u_name, u_price;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_booking);

        t_name= findViewById(R.id.t_name);
        t_price= findViewById(R.id.t_price);
        img= findViewById(R.id.img);
        confirm= findViewById(R.id.confirm);

        firebaseAuth= FirebaseAuth.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseReference= FirebaseDatabase.getInstance().getReference("Bookings").child(user.getUid()).child("image");


        if (getIntent().hasExtra("getPic")) {
            getPic = getIntent().getStringExtra("getPic");

            if (getPic.equals(pic1)){
                img.setImageResource(R.drawable.t1);
                t_name.setText("Hassan Thani Bait Nasib");
                t_price.setText("200 OMR");
            }

            if (getPic.equals(pic2)){
                img.setImageResource(R.drawable.t2);
                t_name.setText("Mohammed Ahsan");
                t_price.setText("200 OMR");
            }

            if (getPic.equals(pic3)){
                img.setImageResource(R.drawable.t3);
                t_name.setText("Hina Mukhtar");
                t_price.setText("200 OMR");
            }

            if (getPic.equals(pic4)){
                img.setImageResource(R.drawable.t4);
                t_name.setText("Hajra Nasir");
                t_price.setText("200 OMR");
            }

            if (getPic.equals(pic5)){
                img.setImageResource(R.drawable.t5);
                t_name.setText("Usman Abid");
                t_price.setText("200 OMR");
            }

        }

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog=new ProgressDialog(FinalBooking.this);
                progressDialog.setTitle("Uploading...");
                progressDialog.show();
                    u_name= t_name.getText().toString();
                    u_price= t_price.getText().toString();

                UserBooking userBooking = new UserBooking(u_name, u_price);
                databaseReference.child(databaseReference.push().getKey()).setValue(userBooking);

                progressDialog.dismiss();
                Toast.makeText(FinalBooking.this, "Booking save to database", Toast.LENGTH_LONG).show();
                startActivity(new Intent(FinalBooking.this, HomePage.class));
                finish();
            }
        });


    }
}
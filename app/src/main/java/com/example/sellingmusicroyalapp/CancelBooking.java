package com.example.sellingmusicroyalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CancelBooking extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ImageAdapterCancelBooking mAdapter;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private ProgressBar mProgressCircle;
    DatabaseReference databaseReference;
    String key;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_booking);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view3);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mProgressCircle = (ProgressBar) findViewById(R.id.progress_circle3);

        FirebaseRecyclerOptions<UserBooking> options =
                new FirebaseRecyclerOptions.Builder<UserBooking>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Bookings").child(user.getUid()).child("image"), UserBooking.class)
                        .build();

        mAdapter = new ImageAdapterCancelBooking(options);
        mRecyclerView.setAdapter(mAdapter);
        mProgressCircle.setVisibility(View.INVISIBLE);

        mAdapter.setOnItemClickListener(new ImageAdapterCancelBooking.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                key= mAdapter.getRef(position).getKey();
                deleteBookingFunction();


            }
        });



    }

    private void deleteBookingFunction() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                CancelBooking.this);
        alertDialog.setTitle("Delete Booking");
        alertDialog.setMessage("Are you sure you want to Cancel the booking?");
        alertDialog.setIcon(R.drawable.logo);
        alertDialog.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseReference ref= FirebaseDatabase.getInstance().getReference("Bookings").child(user.getUid()).child("image").child(key);
                        ref.getRef().removeValue();
                        startActivity(new Intent(CancelBooking.this, CancelBooking.class));
                        Toast.makeText(CancelBooking.this, "Booking is canceled", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        // Showing Alert Message
        alertDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(CancelBooking.this, HomePage.class));
        finish();
    }
}
package com.example.sellingmusicroyalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewBooking extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ImageAdapterViewBooking mAdapter;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private ProgressBar mProgressCircle;
    DatabaseReference databaseReference;
    String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_booking);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mProgressCircle = (ProgressBar) findViewById(R.id.progress_circle2);

        FirebaseRecyclerOptions<UserBooking> options =
                new FirebaseRecyclerOptions.Builder<UserBooking>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Bookings").child(user.getUid()).child("image"), UserBooking.class)
                        .build();

        mAdapter = new ImageAdapterViewBooking(options);
        mRecyclerView.setAdapter(mAdapter);
        mProgressCircle.setVisibility(View.INVISIBLE);

        mAdapter.setOnItemClickListener(new ImageAdapterViewBooking.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                key= mAdapter.getRef(position).getKey();
                Intent intent = new Intent(ViewBooking.this, OpenViewBookingDetails.class);
                intent.putExtra("key", key);
                startActivity(intent);
                finish();


            }
        });



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
        startActivity(new Intent(ViewBooking.this, HomePage.class));
        finish();
    }
}
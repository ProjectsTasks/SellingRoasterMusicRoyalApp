package com.example.sellingmusicroyalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookTeacher extends AppCompatActivity {
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_teacher);

        listView= findViewById(R.id.listView);


        //create data
        ArrayList<Teacher> arrayList= new ArrayList<>();
        arrayList.add(new Teacher(R.drawable.t1, "Hassan Thani Bait Nasib", "200 OMR"));
        arrayList.add(new Teacher(R.drawable.t2, "Mohammed Ahsan", "200 OMR"));
        arrayList.add(new Teacher(R.drawable.t3, "Hina Mukhtar", "200 OMR"));
        arrayList.add(new Teacher(R.drawable.t4, "Hajra Nasir", "200 OMR"));
        arrayList.add(new Teacher(R.drawable.t5, "Usman Abid", "200 OMR"));

        //create CustomAdapter
        TeacherAdapter teacherAdapter= new TeacherAdapter(this, R.layout.list_row,arrayList);

        listView.setAdapter(teacherAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent =new Intent(BookTeacher.this, FinalBooking.class);
                    String pic= "1";
                    intent.putExtra("getPic", pic);
                    startActivity(intent);
                    finish();

                }
                if (position==1){
                    Intent intent =new Intent(BookTeacher.this, FinalBooking.class);
                    String pic= "2";
                    intent.putExtra("getPic", pic);
                    startActivity(intent);
                    finish();
                }
                if (position==2){
                    Intent intent =new Intent(BookTeacher.this, FinalBooking.class);
                    String pic= "3";
                    intent.putExtra("getPic", pic);
                    startActivity(intent);
                    finish();
                }
                if (position==3){
                    Intent intent =new Intent(BookTeacher.this, FinalBooking.class);
                    String pic= "4";
                    intent.putExtra("getPic", pic);
                    startActivity(intent);
                    finish();
                }
                if (position==4){
                    Intent intent =new Intent(BookTeacher.this, FinalBooking.class);
                    String pic= "5";
                    intent.putExtra("getPic", pic);
                    startActivity(intent);
                    finish();
                }
            }
        });



    }
}
package com.example.sellingmusicroyalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SellMusic extends AppCompatActivity {

    MediaPlayer player, player2, player3, player4;
    TextView m1, m2, m3, m4;
    Button m1_p1, m1_pa1, m1_s1, m1_b1, m2_p, m2_pa, m2_s, m2_b, m3_p, m3_pa, m3_s, m3_b, m4_p, m4_pa, m4_s, m4_b;
    ImageView m1_pic, m2_pic, m3_pic, m4_pic;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_music);

//for music 1
        m1= findViewById(R.id.m1);
        m1_p1= findViewById(R.id.m1_p1);
        m1_pa1= findViewById(R.id.m1_pa1);
        m1_s1= findViewById(R.id.m1_s1);
        m1_b1= findViewById(R.id.m1_b1);
        m1.setPaintFlags(m1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        m1_pic= findViewById(R.id.m1_pic);
        m1_pic.setVisibility(View.INVISIBLE);

        //for music 2
        m2= findViewById(R.id.m2);
        m2_p= findViewById(R.id.m2_p);
        m2_pa= findViewById(R.id.m2_pa);
        m2_s= findViewById(R.id.m2_s);
        m2_b= findViewById(R.id.m2_b);
        m2.setPaintFlags(m2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        m2_pic= findViewById(R.id.m2_pic);
        m2_pic.setVisibility(View.INVISIBLE);

        //for music 3
        m3= findViewById(R.id.m3);
        m3_p= findViewById(R.id.m3_p);
        m3_pa= findViewById(R.id.m3_pa);
        m3_s= findViewById(R.id.m3_s);
        m3_b= findViewById(R.id.m3_b);
        m3.setPaintFlags(m3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        m3_pic= findViewById(R.id.m3_pic);
        m3_pic.setVisibility(View.INVISIBLE);

        //for music 4
        m4= findViewById(R.id.m4);
        m4_p= findViewById(R.id.m4_p);
        m4_pa= findViewById(R.id.m4_pa);
        m4_s= findViewById(R.id.m4_s);
        m4_b= findViewById(R.id.m4_b);
        m4.setPaintFlags(m4.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        m4_pic= findViewById(R.id.m4_pic);
        m4_pic.setVisibility(View.INVISIBLE);

        //music 1
        m1_p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(v);
            }
        });

        m1_pa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause(v);
            }
        });

        m1_s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop(v);
            }
        });

        m1_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SellMusic.this, BuyMusic.class);
                String mus= "1";
                intent.putExtra("getM", mus);
                startActivity(intent);
                finish();
            }
        });
        //music 1 end

        //music 2
        m2_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play2(v);
            }
        });

        m2_pa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause2(v);
            }
        });

        m2_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop2(v);
            }
        });

        m2_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SellMusic.this, BuyMusic.class);
                String mus= "2";
                intent.putExtra("getM", mus);
                startActivity(intent);
                finish();
            }
        });
        //music 2 end

        //music 3
        m3_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play3(v);
            }
        });

        m3_pa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause3(v);
            }
        });

        m3_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop3(v);
            }
        });

        m3_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SellMusic.this, BuyMusic.class);
                String mus= "3";
                intent.putExtra("getM", mus);
                startActivity(intent);
                finish();
            }
        });
        //music 3 end

        //music 4
        m4_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play4(v);
            }
        });

        m4_pa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause4(v);
            }
        });

        m4_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop4(v);
            }
        });

        m4_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SellMusic.this, BuyMusic.class);
                String mus= "4";
                intent.putExtra("getM", mus);
                startActivity(intent);
                finish();
            }
        });

        //music 4 end
    }

    //for music 1
    public void play (View v){
        if (player==null){
            player= MediaPlayer.create(this, R.raw.music1);
            m1_pic.setVisibility(View.VISIBLE);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void pause (View v){
        if (player!=null){
            player.pause();
            m1_pic.setVisibility(View.INVISIBLE);
        }
    }

    public void stop (View v){
        stopPlayer();
        m1_pic.setVisibility(View.INVISIBLE);
    }

    private void stopPlayer(){
        if (player!=null){
            player.release();
            player=null;
            Toast.makeText(this, "Music stopped!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
        stopPlayer2();
        stopPlayer3();
        stopPlayer4();
    }
    //for music 1 end

    //for music 2
    public void play2 (View v){
        if (player2==null){
            player2= MediaPlayer.create(this, R.raw.music2);
            m2_pic.setVisibility(View.VISIBLE);
            player2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer2();
                }
            });
        }
        player2.start();
    }

    public void pause2 (View v){
        if (player2!=null){
            player2.pause();
            m2_pic.setVisibility(View.INVISIBLE);
        }
    }

    public void stop2 (View v){
        stopPlayer2();
        m2_pic.setVisibility(View.INVISIBLE);
    }

    private void stopPlayer2(){
        if (player2!=null){
            player2.release();
            player2=null;
            Toast.makeText(this, "Music stopped!", Toast.LENGTH_SHORT).show();
        }
    }

    //for music 2 end

    //for music 3
    public void play3 (View v){
        if (player3==null){
            player3= MediaPlayer.create(this, R.raw.music3);
            m3_pic.setVisibility(View.VISIBLE);
            player3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer3();
                }
            });
        }
        player3.start();
    }

    public void pause3 (View v){
        if (player3!=null){
            player3.pause();
            m3_pic.setVisibility(View.INVISIBLE);
        }
    }

    public void stop3 (View v){
        stopPlayer3();
        m3_pic.setVisibility(View.INVISIBLE);
    }

    private void stopPlayer3(){
        if (player3!=null){
            player3.release();
            player3=null;
            Toast.makeText(this, "Music stopped!", Toast.LENGTH_SHORT).show();
        }
    }
    //for music 3 end

    //for music 4
    public void play4 (View v){
        if (player4==null){
            player4= MediaPlayer.create(this, R.raw.music4);
            m4_pic.setVisibility(View.VISIBLE);
            player4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer4();
                }
            });
        }
        player4.start();
    }

    public void pause4 (View v){
        if (player4!=null){
            player4.pause();
            m4_pic.setVisibility(View.INVISIBLE);
        }
    }

    public void stop4 (View v){
        stopPlayer4();
        m4_pic.setVisibility(View.INVISIBLE);
    }

    private void stopPlayer4(){
        if (player4!=null){
            player4.release();
            player4=null;
            Toast.makeText(this, "Music stopped!", Toast.LENGTH_SHORT).show();
        }
    }

    //for music 4 end

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SellMusic.this, HomePage.class));
        finish();
    }
}
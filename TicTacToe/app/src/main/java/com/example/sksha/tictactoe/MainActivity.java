package com.example.sksha.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    Button proPack,exit,highScores;
    ImageButton ibPlayNow;
    public Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ibPlayNow= (ImageButton) findViewById(R.id.ib_play_now);
        proPack= (Button) findViewById(R.id.btn_buy_pro_pack);
        exit= (Button) findViewById(R.id.btn_exit);
        highScores= (Button) findViewById(R.id.btn_high_scores);


        View.OnClickListener OCL =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.ib_play_now:
                        intent =new Intent(getApplicationContext(),NewGame.class);
                        startActivity(intent);
                        break;
                    case R.id.btn_buy_pro_pack:
                         intent =new Intent(getApplicationContext(),ProPack.class);
                        startActivity(intent);break;
                    case R.id.btn_exit:
                        finish();
                        moveTaskToBack(true);
                        System.exit(0);
                        break;
                    case R.id.btn_high_scores:
                        intent =new Intent(getApplicationContext(),HighScores.class);
                        startActivity(intent);
                        break;
                }
            }
        };

        exit.setOnClickListener(OCL);
        ibPlayNow.setOnClickListener(OCL);
        proPack.setOnClickListener(OCL);
        highScores.setOnClickListener(OCL);

    }
}

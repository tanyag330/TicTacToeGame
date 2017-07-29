package com.example.sksha.tictactoe;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sksha on 30-06-2016.
 */
    public class ThreeByThree extends AppCompatActivity {
    public ImageButton ib00,ib01,ib02,ib10,ib11,ib12,ib20,ib21,ib22,ibChange;
    public int ibPlayerOne;
    public int ibPlayerTwo;
    public int ibPlayer,rbId;
    public int turn,count,difficultySwitch;
    int[] set;
    Intent i ;
    ImageView ivStars;
    TextView tvWinner;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.three_by_three);
            ib00= (ImageButton) findViewById(R.id.ib_00);
            ib01= (ImageButton) findViewById(R.id.ib_01);
            ib02= (ImageButton) findViewById(R.id.ib_02);
            ib10= (ImageButton) findViewById(R.id.ib_10);
            ib11= (ImageButton) findViewById(R.id.ib_11);
            ib12= (ImageButton) findViewById(R.id.ib_12);
            ib20= (ImageButton) findViewById(R.id.ib_20);
            ib21= (ImageButton) findViewById(R.id.ib_21);
            ib22= (ImageButton) findViewById(R.id.ib_22);
        difficultySwitch=0;// 0 for easy , 1 for hard
            ibPlayerOne=getIntent().getIntExtra("idPlayerOne",R.drawable.avatar_earth);
            ibPlayerTwo=getIntent().getIntExtra("idPlayerTwo",R.drawable.avatar_star);
        rbId=getIntent().getIntExtra("difficulty",R.id.rb_moderate);
            final long interval= SystemClock.uptimeMillis();

             set= new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        turn=0;count=0;

            View.OnClickListener OCL =new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                       if (turn == 2) {
                           ibPlayer = ibPlayerTwo;
                           turn = 1;
                       } else {
                           ibPlayer = ibPlayerOne;
                           turn = 2;
                       }


                    switch (v.getId())
                       {
                        case R.id.ib_00: ibChange=ib00;
                            set[0]=ibPlayer;
                            break;
                        case R.id.ib_01: ibChange=ib01;
                            set[1]=ibPlayer;
                            break;
                        case R.id.ib_02: ibChange=ib02;
                            set[2]=ibPlayer;
                            break;
                        case R.id.ib_10: ibChange=ib10;
                            set[3]=ibPlayer;
                            break;
                        case R.id.ib_11: ibChange=ib11;
                            set[4]=ibPlayer;
                            break;
                        case R.id.ib_12: ibChange=ib12;
                            set[5]=ibPlayer;
                            break;
                        case R.id.ib_20: ibChange=ib20;
                            set[6]=ibPlayer;
                            break;
                        case R.id.ib_21: ibChange=ib21;
                            set[7]=ibPlayer;
                            break;
                        case R.id.ib_22: ibChange=ib22;
                            set[8]=ibPlayer;
                            break;
                    }
                    count++;
                    ibChange.setClickable(false);
                    ibChange.setImageResource(ibPlayer);
                    if(winCheck()==true)
                    {
                        int[] a= new int[3];
                        a=getWin();
                        winBackgroundChange(a[0]);
                        winBackgroundChange(a[1]);
                        winBackgroundChange(a[2]);
                        Dialog dialog= new Dialog(ThreeByThree.this);
                        dialog.setContentView(R.layout.game_complete);
                        dialog.setCanceledOnTouchOutside(false);
                        Button btnNewGame,btnExit,btnMainMenu;
                        btnNewGame= (Button)dialog.findViewById(R.id.btn_complete_new_game);
                        btnMainMenu= (Button)dialog. findViewById(R.id.btn_complete_main_menu);
                        tvWinner= (TextView) dialog.findViewById(R.id.tv_winner);
                        btnExit= (Button)dialog. findViewById(R.id.btn_complete_exit);
                       dialog.setCancelable(false);
                        ImageView ivStars;
                        ivStars= (ImageView) dialog.findViewById(R.id.iv_stars);
                        if(SystemClock.uptimeMillis()-interval<10000)
                        {
                            ivStars.setImageResource(R.drawable.three_star);
                        }
                        else if(SystemClock.uptimeMillis()-interval<15000){
                            ivStars.setImageResource(R.drawable.two_star);
                        }
                        else{
                            ivStars.setImageResource(R.drawable.one_star);
                        }
                        if(getIntent().getStringExtra("playAgainst").equals("cpu")&&ibPlayer==ibPlayerOne){
                            dialog.setTitle("You won!!");
                            tvWinner.setText("YOU WON");
                        }
                        else if(getIntent().getStringExtra("playAgainst").equals("cpu")&&ibPlayer==ibPlayerTwo)
                        {
                            dialog.setTitle("You Lose!! ");
                            tvWinner.setText("YOU LOSE");
                            ivStars.setImageResource(R.drawable.you_lose);
                        }
                        else if(ibPlayer==ibPlayerOne) {
                            dialog.setTitle("Player One Won!!");
                            tvWinner.setText("PLAYER ONE WON");
                        }
                        else {
                            dialog.setTitle("Player Two Won!!");
                            tvWinner.setText("PLAYER TWO WON");
                        }



                        dialog.show();
                        btnNewGame.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i =new Intent(getApplicationContext(),NewGame.class);
                                startActivity(i);
                            }
                        });

                        btnMainMenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i =new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(i);
                            }
                        });

                        btnExit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                               finish();
                                System.exit(0);
                            }
                        });

                    }

                   else if(ibPlayerTwo==R.drawable.avatar_computer&&turn==2&&count<9)
                    {   int position;
                        if(rbId==R.id.rb_easy){
                             EasyDifficulty easyDifficulty=new EasyDifficulty(set,3);
                             position =easyDifficulty.getPosition();
                        }
                       else if(rbId==R.id.rb_hard){
                            HardDifficulty hardDifficulty =new HardDifficulty(set,3,ibPlayerOne,ibPlayerTwo);
                             position =hardDifficulty.getPosition();
                        }
                        else
                        {
                            EasyDifficulty easyDifficulty=new EasyDifficulty(set,3);
                            HardDifficulty hardDifficulty =new HardDifficulty(set,3,ibPlayerOne,ibPlayerTwo);

                            if(difficultySwitch==0) {
                                position = easyDifficulty.getPosition();
                                difficultySwitch=1;
                            }
                            else
                            {
                                position = hardDifficulty.getPosition();
                                difficultySwitch=0;
                            }
                        }

                        if(position/3==0)
                        {
                            if(position%3==0)
                                ib00.performClick();
                            else if(position%3==1)
                                ib01.performClick();
                            else ib02.performClick();

                        }
                        else if(position/3==1)
                        {
                            if(position%3==0)
                                ib10.performClick();
                            else if(position%3==1)
                                ib11.performClick();
                            else ib12.performClick();
                        }
                        else
                        {
                            if(position%3==0)
                                ib20.performClick();
                            else if(position%3==1)
                                ib21.performClick();
                            else ib22.performClick();
                        }
                    }

                    if(count==9&&winCheck()==false)
                    {
                        Dialog dialog= new Dialog(ThreeByThree.this);
                        dialog.setContentView(R.layout.game_complete);
                       dialog.setCanceledOnTouchOutside(false);
                        Button btnNewGame,btnExit,btnMainMenu;
                        btnNewGame= (Button)dialog.findViewById(R.id.btn_complete_new_game);
                        btnMainMenu= (Button)dialog. findViewById(R.id.btn_complete_main_menu);
                        btnExit= (Button)dialog. findViewById(R.id.btn_complete_exit);
                        dialog.setCancelable(false);
                        dialog.setTitle("Tie Game!!");
                        ivStars= (ImageView) dialog.findViewById(R.id.iv_stars);
                        ivStars.setImageResource(R.drawable.tie_game);
                        dialog.show();
                        btnNewGame.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i =new Intent(getApplicationContext(),NewGame.class);
                                startActivity(i);
                            }
                        });

                        btnMainMenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i =new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(i);
                            }
                        });

                        btnExit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                moveTaskToBack(true);
                                finish();

                            }
                        });
                    }

                }
            };

        ib00.setOnClickListener(OCL);
        ib01.setOnClickListener(OCL);
        ib02.setOnClickListener(OCL);
        ib10.setOnClickListener(OCL);
        ib11.setOnClickListener(OCL);
        ib12.setOnClickListener(OCL);
        ib20.setOnClickListener(OCL);
        ib21.setOnClickListener(OCL);
        ib22.setOnClickListener(OCL);


        }

    public boolean winCheck()
    {
        if((set[0]==ibPlayer&&set[1]==ibPlayer&&set[2]==ibPlayer)
                ||(set[3]==ibPlayer&&set[4]==ibPlayer&&set[5]==ibPlayer)
                ||(set[6]==ibPlayer&&set[7]==ibPlayer&&set[8]==ibPlayer)
                ||(set[0]==ibPlayer&&set[3]==ibPlayer&&set[6]==ibPlayer)
                ||(set[1]==ibPlayer&&set[4]==ibPlayer&&set[7]==ibPlayer)
                ||(set[2]==ibPlayer&&set[5]==ibPlayer&&set[8]==ibPlayer)
                ||(set[0]==ibPlayer&&set[4]==ibPlayer&&set[8]==ibPlayer)
                ||(set[2]==ibPlayer&&set[4]==ibPlayer&&set[6]==ibPlayer))
        {
            return true;
        }

        return false;
    }

    public int[] getWin()
    {
        int[] a= new int[3];
        if(set[0]==ibPlayer&&set[1]==ibPlayer&&set[2]==ibPlayer)
        {
            a[0]=0;
            a[1]=1;
            a[2]=2;

        }

        else if(set[3]==ibPlayer&&set[4]==ibPlayer&&set[5]==ibPlayer)
        {
            a[0]=3;
            a[1]=4;
            a[2]=5;

        }
        else if(set[6]==ibPlayer&&set[7]==ibPlayer&&set[8]==ibPlayer)
        {
            a[0]=6;
            a[1]=7;
            a[2]=8;

        }
        else if(set[0]==ibPlayer&&set[3]==ibPlayer&&set[6]==ibPlayer)
        {
            a[0]=0;
            a[1]=3;
            a[2]=6;

        }
        else if(set[1]==ibPlayer&&set[4]==ibPlayer&&set[7]==ibPlayer)
        {
            a[0]=1;
            a[1]=4;
            a[2]=7;

        }
        else if(set[2]==ibPlayer&&set[5]==ibPlayer&&set[8]==ibPlayer)
        {
            a[0]=2;
            a[1]=5;
            a[2]=8;

        }
        else if(set[0]==ibPlayer&&set[4]==ibPlayer&&set[8]==ibPlayer)
        {
            a[0]=0;
            a[1]=4;
            a[2]=8;

        }
        else if(set[2]==ibPlayer&&set[4]==ibPlayer&&set[6]==ibPlayer)
        {
            a[0]=2;
            a[1]=4;
            a[2]=6;

        }

        return a;


    }

    public void winBackgroundChange(int position)
    {
        if(position/3==0)
        {
            if(position%3==0)
                ib00.setBackgroundColor(Color.argb(255,255,161,0));
            else if(position%3==1)
                ib01.setBackgroundColor(Color.argb(255,255,161,0));
            else ib02.setBackgroundColor(Color.argb(255,255,161,0));

        }
        else if(position/3==1)
        {
            if(position%3==0)
                ib10.setBackgroundColor(Color.argb(255,255,161,0));
            else if(position%3==1)
                ib11.setBackgroundColor(Color.argb(255,255,161,0));
            else ib12.setBackgroundColor(Color.argb(255,255,161,0));
        }
        else
        {
            if(position%3==0)
                ib20.setBackgroundColor(Color.argb(255,255,161,0));
            else if(position%3==1)
                ib21.setBackgroundColor(Color.argb(255,255,161,0));
            else ib22.setBackgroundColor(Color.argb(255,255,161,0));
        }
    }
    }
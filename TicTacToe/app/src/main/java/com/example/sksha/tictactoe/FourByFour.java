package com.example.sksha.tictactoe;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sksha on 30-06-2016.
 */
public class FourByFour extends AppCompatActivity {
    public ImageButton ib00,ib01,ib02,ib03,ib10,ib11,ib12,ib13,ib20,ib21,ib22,ib23,ib30,ib31,ib32,ib33,ibChange;
    public int ibPlayerOne;
    public int ibPlayerTwo;
    public int ibPlayer,rbId;
    public int turn,count,difficultySwitch;
    int[] set;
    Intent i;long interval;
    TextView tvWinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_by_four);
        ib00= (ImageButton) findViewById(R.id.ib_00);
        ib01= (ImageButton) findViewById(R.id.ib_01);
        ib02= (ImageButton) findViewById(R.id.ib_02);
        ib03= (ImageButton) findViewById(R.id.ib_03);
        ib10= (ImageButton) findViewById(R.id.ib_10);
        ib11= (ImageButton) findViewById(R.id.ib_11);
        ib12= (ImageButton) findViewById(R.id.ib_12);
        ib13= (ImageButton) findViewById(R.id.ib_13);
        ib20= (ImageButton) findViewById(R.id.ib_20);
        ib21= (ImageButton) findViewById(R.id.ib_21);
        ib22= (ImageButton) findViewById(R.id.ib_22);
        ib23= (ImageButton) findViewById(R.id.ib_23);
        ib30= (ImageButton) findViewById(R.id.ib_30);
        ib31= (ImageButton) findViewById(R.id.ib_31);
        ib32= (ImageButton) findViewById(R.id.ib_32);
        ib33= (ImageButton) findViewById(R.id.ib_33);
        ibPlayerOne=getIntent().getIntExtra("idPlayerOne",R.drawable.avatar_earth);
        ibPlayerTwo=getIntent().getIntExtra("idPlayerTwo",R.drawable.avatar_star);
        rbId=getIntent().getIntExtra("difficulty",R.id.rb_moderate);
        difficultySwitch=0;//0 for easy, 1 for hard
        interval=SystemClock.uptimeMillis();
        count=0;
        set= new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0};
        turn=0;

        View.OnClickListener OCL =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==2) {
                    ibPlayer = ibPlayerTwo;
                    turn=1;
                }
                else {
                    ibPlayer = ibPlayerOne;
                    turn=2;
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
                    case R.id.ib_03: ibChange=ib03;
                        set[3]=ibPlayer;
                        break;
                    case R.id.ib_10: ibChange=ib10;
                        set[4]=ibPlayer;
                        break;
                    case R.id.ib_11: ibChange=ib11;
                        set[5]=ibPlayer;
                        break;
                    case R.id.ib_12: ibChange=ib12;
                        set[6]=ibPlayer;
                        break;
                    case R.id.ib_13: ibChange=ib13;
                        set[7]=ibPlayer;
                        break;
                    case R.id.ib_20: ibChange=ib20;
                        set[8]=ibPlayer;
                        break;
                    case R.id.ib_21: ibChange=ib21;
                        set[9]=ibPlayer;
                        break;
                    case R.id.ib_22: ibChange=ib22;
                        set[10]=ibPlayer;
                        break;
                    case R.id.ib_23: ibChange=ib23;
                        set[11]=ibPlayer;
                        break;
                    case R.id.ib_30: ibChange=ib30;
                        set[12]=ibPlayer;
                        break;
                    case R.id.ib_31: ibChange=ib31;
                        set[13]=ibPlayer;
                        break;
                    case R.id.ib_32: ibChange=ib32;
                        set[14]=ibPlayer;
                        break;
                    case R.id.ib_33: ibChange=ib33;
                        set[15]=ibPlayer;
                        break;
                }
                count++;
                ibChange.setClickable(false);
                ibChange.setImageResource(ibPlayer);
                if(winCheck()==true)
                {
                    int[] a= new int[4];
                    a=getWin();
                    winBackgroundChange(a[0]);
                    winBackgroundChange(a[1]);
                    winBackgroundChange(a[2]);
                    winBackgroundChange(a[3]);
                    Dialog dialog= new Dialog(FourByFour.this);
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
                    if(getIntent().getStringExtra("playAgainst").equals("cpu")&&ibPlayer==ibPlayerOne) {
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
                            moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
                        }
                    });

                }

                else if(ibPlayerTwo==R.drawable.avatar_computer&&turn==2&&count<16)
                {
                  int position;
                    if(rbId==R.id.rb_easy){
                        Log.d("TAG", "onClick: easy difficulty");
                        EasyDifficulty easyDifficulty=new EasyDifficulty(set,4);
                        position =easyDifficulty.getPosition();
                    }
                    else if(rbId==R.id.rb_hard){
                        Log.d("TAG", "onClick: hard difficulty");
                        HardDifficulty hardDifficulty =new HardDifficulty(set,4,ibPlayerOne,ibPlayerTwo);
                        position =hardDifficulty.getPosition();
                    }
                    else
                    {   Log.d("TAG", "onClick: moderate difficulty");
                        EasyDifficulty easyDifficulty=new EasyDifficulty(set,4);
                        HardDifficulty hardDifficulty =new HardDifficulty(set,4,ibPlayerOne,ibPlayerTwo);

                        if(difficultySwitch==0) {
                            Log.d("TAG", "onClick: easy****STEP");
                            position = easyDifficulty.getPosition();
                            difficultySwitch=1;
                        }
                        else
                        {   Log.d("TAG", "onClick: hard***STEP");
                            position = hardDifficulty.getPosition();
                            difficultySwitch=0;
                        }
                    }
                    if(position/4==0)
                    {
                        if(position%4==0)
                            ib00.performClick();
                        else if(position%4==1)
                            ib01.performClick();
                        else if(position%4==2)
                            ib02.performClick();
                        else ib03.performClick();

                    }
                    else if(position/4==1)
                    {
                        if(position%4==0)
                            ib10.performClick();
                        else if(position%4==1)
                            ib11.performClick();
                        else if(position%4==2)
                            ib12.performClick();
                        else ib13.performClick();
                    }
                    else if(position/4==2)
                    {
                        if(position%4==0)
                            ib20.performClick();
                        else if(position%4==1)
                            ib21.performClick();
                        else if(position%4==2)
                            ib22.performClick();
                        else ib23.performClick();
                    }

                    else
                    {
                        if(position%4==0)
                            ib30.performClick();
                        else if(position%4==1)
                            ib31.performClick();
                        else if(position%4==2)
                            ib32.performClick();
                        else ib33.performClick();
                    }
                }

                if(count==16&&winCheck()==false)
                {
                    Dialog dialog= new Dialog(FourByFour.this);
                    dialog.setContentView(R.layout.game_complete);
                 dialog.setCanceledOnTouchOutside(false);
                    Button btnNewGame,btnExit,btnMainMenu;
                    btnNewGame= (Button)dialog.findViewById(R.id.btn_complete_new_game);
                    btnMainMenu= (Button)dialog. findViewById(R.id.btn_complete_main_menu);
                    btnExit= (Button)dialog. findViewById(R.id.btn_complete_exit);
                 dialog.setCancelable(false);
                    dialog.setTitle("Tie Game!!");
                    ImageView ivStars;
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
                            finish();

                        }
                    });
                }

            }
        };

        ib00.setOnClickListener(OCL);
        ib01.setOnClickListener(OCL);
        ib02.setOnClickListener(OCL);
        ib03.setOnClickListener(OCL);
        ib10.setOnClickListener(OCL);
        ib11.setOnClickListener(OCL);
        ib12.setOnClickListener(OCL);
        ib13.setOnClickListener(OCL);
        ib20.setOnClickListener(OCL);
        ib21.setOnClickListener(OCL);
        ib22.setOnClickListener(OCL);
        ib23.setOnClickListener(OCL);
        ib30.setOnClickListener(OCL);
        ib31.setOnClickListener(OCL);
        ib32.setOnClickListener(OCL);
        ib33.setOnClickListener(OCL);


    }

    public boolean winCheck()
    {
        if((set[0]==ibPlayer&&set[1]==ibPlayer&&set[2]==ibPlayer&&set[3]==ibPlayer)
                ||(set[4]==ibPlayer&&set[5]==ibPlayer&&set[6]==ibPlayer&&set[7]==ibPlayer)
                ||(set[8]==ibPlayer&&set[9]==ibPlayer&&set[10]==ibPlayer&&set[11]==ibPlayer)
                ||(set[12]==ibPlayer&&set[13]==ibPlayer&&set[14]==ibPlayer&&set[15]==ibPlayer)
                ||(set[0]==ibPlayer&&set[4]==ibPlayer&&set[8]==ibPlayer&&set[12]==ibPlayer)
                ||(set[1]==ibPlayer&&set[5]==ibPlayer&&set[9]==ibPlayer&&set[13]==ibPlayer)
                ||(set[2]==ibPlayer&&set[6]==ibPlayer&&set[10]==ibPlayer&&set[14]==ibPlayer)
                ||(set[3]==ibPlayer&&set[7]==ibPlayer&&set[11]==ibPlayer&&set[15]==ibPlayer)
                ||(set[0]==ibPlayer&&set[5]==ibPlayer&&set[10]==ibPlayer&&set[15]==ibPlayer)
                ||(set[12]==ibPlayer&&set[9]==ibPlayer&&set[6]==ibPlayer&&set[3]==ibPlayer))
        {
            return true;
        }

        return false;
    }

    public int[] getWin()
    {
        int[] a= new int[4];
        if(set[0]==ibPlayer&&set[1]==ibPlayer&&set[2]==ibPlayer&&set[3]==ibPlayer)
        {
            a[0]=0;
            a[1]=1;
            a[2]=2;
            a[3]=3;
        }

                else if(set[4]==ibPlayer&&set[5]==ibPlayer&&set[6]==ibPlayer&&set[7]==ibPlayer)
        {
            a[0]=4;
            a[1]=5;
            a[2]=6;
            a[3]=7;
        }
                else if(set[8]==ibPlayer&&set[9]==ibPlayer&&set[10]==ibPlayer&&set[11]==ibPlayer)
        {
            a[0]=8;
            a[1]=9;
            a[2]=10;
            a[3]=11;
        }
                else if(set[12]==ibPlayer&&set[13]==ibPlayer&&set[14]==ibPlayer&&set[15]==ibPlayer)
        {
            a[0]=12;
            a[1]=13;
            a[2]=14;
            a[3]=15;
        }
                else if(set[0]==ibPlayer&&set[4]==ibPlayer&&set[8]==ibPlayer&&set[12]==ibPlayer)
        {
            a[0]=0;
            a[1]=4;
            a[2]=8;
            a[3]=12;
        }
                else if(set[1]==ibPlayer&&set[5]==ibPlayer&&set[9]==ibPlayer&&set[13]==ibPlayer)
        {
            a[0]=1;
            a[1]=5;
            a[2]=9;
            a[3]=13;
        }
               else if(set[2]==ibPlayer&&set[6]==ibPlayer&&set[10]==ibPlayer&&set[14]==ibPlayer)
        {
            a[0]=2;
            a[1]=6;
            a[2]=10;
            a[3]=14;
        }
                else if(set[3]==ibPlayer&&set[7]==ibPlayer&&set[11]==ibPlayer&&set[15]==ibPlayer)
        {
            a[0]=3;
            a[1]=7;
            a[2]=11;
            a[3]=15;
        }
                else if(set[0]==ibPlayer&&set[5]==ibPlayer&&set[10]==ibPlayer&&set[15]==ibPlayer)
        {
            a[0]=0;
            a[1]=5;
            a[2]=10;
            a[3]=15;
        }
                else
        {
            a[0]=12;
            a[1]=9;
            a[2]=6;
            a[3]=3;
        }
        return a;


}
    public void winBackgroundChange(int position)
    {
        if(position/4==0)
        {
            if(position%4==0)
                ib00.setBackgroundColor(Color.argb(255,255,161,0));
            else if(position%4==1)
                ib01.setBackgroundColor(Color.argb(255,255,161,0));
            else if(position%4==2)
                ib02.setBackgroundColor(Color.argb(255,255,161,0));
            else ib03.setBackgroundColor(Color.argb(255,255,161,0));

        }
        else if(position/4==1)
        {
            if(position%4==0)
                ib10.setBackgroundColor(Color.argb(255,255,161,0));
            else if(position%4==1)
                ib11.setBackgroundColor(Color.argb(255,255,161,0));
            else if(position%4==2)
                ib12.setBackgroundColor(Color.argb(255,255,161,0));
            else ib13.setBackgroundColor(Color.argb(255,255,161,0));
        }
        else if(position/4==2)
        {
            if(position%4==0)
                ib20.setBackgroundColor(Color.argb(255,255,161,0));
            else if(position%4==1)
                ib21.setBackgroundColor(Color.argb(255,255,161,0));
            else if(position%4==2)
                ib22.setBackgroundColor(Color.argb(255,255,161,0));
            else ib23.setBackgroundColor(Color.argb(255,255,161,0));
        }

        else
        {
            if(position%4==0)
                ib30.setBackgroundColor(Color.argb(255,255,161,0));
            else if(position%4==1)
                ib31.setBackgroundColor(Color.argb(255,255,161,0));
            else if(position%4==2)
                ib32.setBackgroundColor(Color.argb(255,255,161,0));
            else ib33.setBackgroundColor(Color.argb(255,255,161,0));
        }
    }
}

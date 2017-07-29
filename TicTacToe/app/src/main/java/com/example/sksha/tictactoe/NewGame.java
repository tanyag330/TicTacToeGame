package com.example.sksha.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class NewGame extends AppCompatActivity {
    RadioGroup rgGridSize, rgDifficulty, rgPlayAgainst;
    RadioButton rbThreeCrossThree, rbFourCrossFour, rbEasy, rbModerate, rbHard, rbCpu, rbHuman;
    int idPlayerOne, idPlayerTwo;
    PlayAgainstCpu playAgainstCpu;
    PlayAgainstHuman playAgainstHuman;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ImageButton btnPlayerOne, btnPlayerTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);
        rgGridSize = (RadioGroup) findViewById(R.id.rg_grid_size);
        rgDifficulty = (RadioGroup) findViewById(R.id.rg_difficulty);
        rbCpu = (RadioButton) findViewById(R.id.rb_play_against_cpu);
        rbHuman = (RadioButton) findViewById(R.id.rb_play_against_human);
        rbThreeCrossThree = (RadioButton) findViewById(R.id.rb_three_by_three);
        rbFourCrossFour = (RadioButton) findViewById(R.id.rb_four_by_four);
        playAgainstCpu = new PlayAgainstCpu();
        playAgainstHuman = new PlayAgainstHuman();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.play_against_container, playAgainstCpu, null);
        fragmentTransaction.commit();

        playAgainstCpu.setOnCreateViewListner(new PlayAgainstCpu.OnCreateViewListner() {
            @Override
            public void onCreateViewListner(Button playBtn, final ImageButton ibEarth, final ImageButton ibSmile, final ImageButton ibStar) {
                playBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("TAG", "onClick: ***************CPU");

                        if (btnPlayerOne == ibEarth) {
                            idPlayerOne = R.drawable.avatar_earth;
                        } else if (btnPlayerOne == ibSmile) {
                            idPlayerOne = R.drawable.avatar_smile;
                        } else {
                            idPlayerOne = R.drawable.avatar_star;
                        }

                        Intent intent;
                        if (rgGridSize.getCheckedRadioButtonId() == rbThreeCrossThree.getId()) {
                            intent = new Intent(getApplicationContext(), ThreeByThree.class);
                        } else {
                            intent = new Intent(getApplicationContext(), FourByFour.class);
                        }

                        intent.putExtra("difficulty", rgDifficulty.getCheckedRadioButtonId());
                        intent.putExtra("playAgainst", "cpu");
                        intent.putExtra("idPlayerOne", idPlayerOne);
                        intent.putExtra("idPlayerTwo", R.drawable.avatar_computer);
                        startActivity(intent);
                    }
                });

                ibEarth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ibEarth.setBackgroundColor(Color.argb(255, 255, 161, 0));
                        ibSmile.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        ibStar.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        btnPlayerOne = ibEarth;
                    }
                });

                ibSmile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ibSmile.setBackgroundColor(Color.argb(255, 255, 161, 0));
                        ibEarth.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        ibStar.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        btnPlayerOne = ibSmile;
                    }
                });

                ibStar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ibStar.setBackgroundColor(Color.argb(255, 255, 161, 0));
                        ibSmile.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        ibEarth.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        btnPlayerOne = ibStar;
                    }
                });

                ibEarth.performClick();
            }
        });

        playAgainstHuman.setOnCreateViewListner(new PlayAgainstHuman.OnCreateViewListner() {
            @Override
            public void onCreateViewListner(Button playBtn, final ImageButton ibEarthPlayerOne, final ImageButton ibSmilePlayerOne, final ImageButton ibStarPlayerOne, final ImageButton ibEarthPlayerTwo, final ImageButton ibSmilePlayerTwo, final ImageButton ibStarPlayerTwo) {
                playBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("TAG", "onClick: ***************HUMANS");

                        if (btnPlayerOne == ibEarthPlayerOne) {
                            idPlayerOne = R.drawable.avatar_earth;
                        } else if (btnPlayerOne == ibSmilePlayerOne) {
                            idPlayerOne = R.drawable.avatar_smile;
                        } else {
                            idPlayerOne = R.drawable.avatar_star;
                        }

                        if (btnPlayerTwo == ibEarthPlayerTwo) {
                            idPlayerTwo = R.drawable.avatar_earth;
                        } else if (btnPlayerTwo == ibSmilePlayerTwo) {
                            idPlayerTwo = R.drawable.avatar_smile;
                        } else {
                            idPlayerTwo = R.drawable.avatar_star;
                        }

                        Intent intent;
                        if (rgGridSize.getCheckedRadioButtonId() == rbThreeCrossThree.getId()) {
                            intent = new Intent(getApplicationContext(), ThreeByThree.class);
                        } else {
                            intent = new Intent(getApplicationContext(), FourByFour.class);
                        }

                        intent.putExtra("difficulty", rgDifficulty.getCheckedRadioButtonId());
                        intent.putExtra("playAgainst", "human");
                        intent.putExtra("idPlayerOne", idPlayerOne);
                        intent.putExtra("idPlayerTwo", idPlayerTwo);
                        startActivity(intent);
                    }
                });


                ibEarthPlayerOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ibEarthPlayerOne.setBackgroundColor(Color.argb(255, 255, 161, 0));
                        ibSmilePlayerOne.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        ibStarPlayerOne.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        btnPlayerOne = ibEarthPlayerOne;
                        ibEarthPlayerTwo.setClickable(false);
                        ibStarPlayerTwo.setClickable(true);
                        ibSmilePlayerTwo.setClickable(true);
                        ibEarthPlayerTwo.setAlpha(0.15f);
                        ibSmilePlayerTwo.setAlpha(1f);
                        ibStarPlayerTwo.setAlpha(1f);


                    }
                });

                ibSmilePlayerOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ibSmilePlayerOne.setBackgroundColor(Color.argb(255, 255, 161, 0));
                        ibEarthPlayerOne.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        ibStarPlayerOne.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        btnPlayerOne = ibSmilePlayerOne;
                        ibEarthPlayerTwo.setClickable(true);
                        ibStarPlayerTwo.setClickable(true);
                        ibSmilePlayerTwo.setClickable(false);
                        ibEarthPlayerTwo.setAlpha(1f);
                        ibSmilePlayerTwo.setAlpha(0.15f);
                        ibStarPlayerTwo.setAlpha(1f);
                    }
                });

                ibStarPlayerOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ibStarPlayerOne.setBackgroundColor(Color.argb(255, 255, 161, 0));
                        ibSmilePlayerOne.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        ibEarthPlayerOne.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        btnPlayerOne = ibStarPlayerOne;
                        ibEarthPlayerTwo.setClickable(true);
                        ibStarPlayerTwo.setClickable(false);
                        ibSmilePlayerTwo.setClickable(true);
                        ibEarthPlayerTwo.setAlpha(1f);
                        ibSmilePlayerTwo.setAlpha(1f);
                        ibStarPlayerTwo.setAlpha(0.15f);

                    }
                });

                ibEarthPlayerTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ibEarthPlayerTwo.setBackgroundColor(Color.argb(255, 255, 161, 0));
                        ibSmilePlayerTwo.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        ibStarPlayerTwo.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        btnPlayerTwo = ibEarthPlayerTwo;
                        ibEarthPlayerOne.setClickable(false);
                        ibStarPlayerOne.setClickable(true);
                        ibSmilePlayerOne.setClickable(true);
                        ibEarthPlayerOne.setAlpha(0.15f);
                        ibSmilePlayerOne.setAlpha(1f);
                        ibStarPlayerOne.setAlpha(1f);
                    }
                });

                ibSmilePlayerTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ibSmilePlayerTwo.setBackgroundColor(Color.argb(255, 255, 161, 0));
                        ibEarthPlayerTwo.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        ibStarPlayerTwo.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        btnPlayerTwo = ibSmilePlayerTwo;
                        ibEarthPlayerOne.setClickable(true);
                        ibStarPlayerOne.setClickable(true);
                        ibSmilePlayerOne.setClickable(false);
                        ibEarthPlayerOne.setAlpha(1f);
                        ibSmilePlayerOne.setAlpha(0.15f);
                        ibStarPlayerOne.setAlpha(1f);
                    }
                });

                ibStarPlayerTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ibStarPlayerTwo.setBackgroundColor(Color.argb(255, 255, 161, 0));
                        ibSmilePlayerTwo.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        ibEarthPlayerTwo.setBackgroundColor(Color.argb(0, 0, 0, 0));
                        btnPlayerTwo = ibStarPlayerTwo;
                        ibEarthPlayerOne.setClickable(true);
                        ibStarPlayerOne.setClickable(false);
                        ibSmilePlayerOne.setClickable(true);
                        ibEarthPlayerOne.setAlpha(1f);
                        ibSmilePlayerOne.setAlpha(1f);
                        ibStarPlayerOne.setAlpha(0.15f);
                    }
                });

                ibEarthPlayerOne.performClick();
                ibSmilePlayerTwo.performClick();
            }
        });

        rbHuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout llDifficultyBox;
                llDifficultyBox = (LinearLayout) findViewById(R.id.ll_difficulty_box);
                llDifficultyBox.setClickable(false);
                llDifficultyBox.setAlpha(0.15f);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.play_against_container, playAgainstHuman, null);
                fragmentTransaction.commit();
            }
        });

        rbCpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout llDifficultyBox;
                llDifficultyBox = (LinearLayout) findViewById(R.id.ll_difficulty_box);
                llDifficultyBox.setClickable(true);
                llDifficultyBox.setAlpha(1f);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.play_against_container, playAgainstCpu, null);
                fragmentTransaction.commit();
            }
        });
    }
}
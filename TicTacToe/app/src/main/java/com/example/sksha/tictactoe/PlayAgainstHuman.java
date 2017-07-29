package com.example.sksha.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by sksha on 30-06-2016.
 */
public class PlayAgainstHuman extends Fragment  {
    Button btnPlay;
    ImageButton ibEarthPlayerOne,ibEarthPlayerTwo,ibSmilePlayerOne,ibStarPlayerOne,ibSmilePlayerTwo,ibStarPlayerTwo;

    OnCreateViewListner OCVL;
    void setOnCreateViewListner(OnCreateViewListner OCVL)
    {
        this.OCVL=OCVL;
    }
    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.play_against_human, container, false);
        btnPlay= (Button) rootView.findViewById(R.id.btn_play);
        ibEarthPlayerOne= (ImageButton) rootView.findViewById(R.id.ib_avatar_earth_p1);
        ibSmilePlayerOne= (ImageButton) rootView.findViewById(R.id.ib_avatar_smile_p1);
        ibStarPlayerOne=(ImageButton) rootView.findViewById(R.id.ib_avatar_star_p1);
        ibEarthPlayerTwo= (ImageButton) rootView.findViewById(R.id.ib_avatar_earth_p2);
        ibSmilePlayerTwo= (ImageButton) rootView.findViewById(R.id.ib_avatar_smile_p2);
        ibStarPlayerTwo=(ImageButton) rootView.findViewById(R.id.ib_avatar_star_p2);

        if(OCVL!=null)
            OCVL.onCreateViewListner(btnPlay,ibEarthPlayerOne,ibSmilePlayerOne,ibStarPlayerOne,ibEarthPlayerTwo,ibSmilePlayerTwo,ibStarPlayerTwo);
            return rootView;
        }
    public interface OnCreateViewListner{
        void onCreateViewListner(Button btn,ImageButton ibEarthPlayerOne,ImageButton ibSmilePlayerOne,ImageButton ibStarPlayerOneb,ImageButton ibEarthPlayerTwo,ImageButton ibSmilePlayerTwo,ImageButton ibStarPlayerTwo);

    }

    }


package com.example.sksha.tictactoe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class PlayAgainstCpu extends Fragment {
    Button btnPlay;
    ImageButton ibEarth,ibSmile,ibStar;

    OnCreateViewListner OCVL;

    void setOnCreateViewListner(OnCreateViewListner OCVL)
    {
        this.OCVL=OCVL;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.play_against_cpu, container, false);
        btnPlay= (Button) rootView.findViewById(R.id.btn_play);
        ibEarth= (ImageButton) rootView.findViewById(R.id.ib_avatar_earth);
        ibSmile= (ImageButton) rootView.findViewById(R.id.ib_avatar_smile);
        ibStar=(ImageButton) rootView.findViewById(R.id.ib_avatar_star);

        if(OCVL!=null)
        OCVL.onCreateViewListner(btnPlay,ibEarth,ibSmile,ibStar);
        return rootView;
    }

    public interface OnCreateViewListner{
         void onCreateViewListner(Button btn, ImageButton ibEarth,ImageButton ibSmile,ImageButton ibStar);
    }
}
package com.example.sksha.tictactoe;

import android.util.Log;

import java.util.Random;

/**
 * Created by sksha on 01-07-2016.
 */
public class EasyDifficulty {

    int[][] setOur=new int[4][4];
    int[] set =new int[16];
    int size;
    EasyDifficulty(int[] set,int size)
    {   this.set=set;
        this.size=size;
        if(size!=4)
        {
            int i=0,j=0,k=0;
            while(k<9)
            {
                setOur[i][j]=set[k];
                j++;k++;
                if(j==3)
                {
                    i++;
                    j=0;
                }

            }
        }

        else
        {
            int i=0,j=0,k=0;
            while(k<16)
            {
               setOur[i][j]=set[k];
                j++;k++;
                if(j==4)
                {
                    i++;
                    j=0;
                }

            }
        }
    }



    public int getPosition()
    {
        Random r= new Random();
        int i;
        if(size!=4) {
            i = r.nextInt(9);
            Log.d("TAG","i OUTSIDE LOOP FOUND="+ String.valueOf(i));
            while (set[i] != 0) {
               i=r.nextInt(9);
                Log.d("TAG","i INSIDE-*------------ LOOP FOUND="+ String.valueOf(i));
            }
            Log.d("TAG","RETURNING i========++++++="+ String.valueOf(i));
            return i;
        }
        i = r.nextInt(16);
        while (set[i] != 0) {
            i=r.nextInt(16);
        }

        return i;


    }
}

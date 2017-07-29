package com.example.sksha.tictactoe;

import android.util.Log;

import java.util.Random;

/**
 * Created by sksha on 01-07-2016.
 */
public class HardDifficulty {
    int[][] setOur=new int[4][4];
    int[] set =new int[16];
    int size,playerOne,playerTwo;
    HardDifficulty(int[] set,int size,int playerOne,int playerTwo)
    {   this.playerOne=playerOne;
        this.playerTwo=playerTwo;
        this.set=set;
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




    public boolean checkCorner()
    {
       if(size==3)
       {
           if(setOur[0][0]==0
                   ||setOur[0][2]==0
                   ||setOur[2][0]==0
                   ||setOur[2][2]==0)
           {
              return true;
           }

           return  false;
       }

        else
       {
           if(setOur[0][0]==0
                   ||setOur[0][3]==0
                   ||setOur[3][0]==0
                   ||setOur[3][3]==0)
           {
               return true;
           }

           return  false;
       }
    }


    public boolean checkEdge()
    {
        if(size==3)
        {
            if(setOur[1][0]==0
                    ||setOur[0][1]==0
                    ||setOur[1][2]==0
                    ||setOur[2][1]==0)
            {
                return true;
            }

            return  false;
        }

        else
        {
            if(setOur[1][0]==0
                    ||setOur[2][0]==0
                    ||setOur[0][1]==0
                    ||setOur[0][2]==0
                    ||setOur[1][3]==0
                    ||setOur[2][3]==0
                    ||setOur[3][1]==0
                    ||setOur[3][2]==0)
            {
                return true;
            }

            return  false;
        }
    }
    public boolean checkCenter()
    {
        if(size==3)
        {
            if(setOur[1][1]==0)
                return true;
        }
        return  false;
    }

    public int[] findCorner()
    {
        int a[]=new int[2];
        if(size==3)
        {
            if(setOur[0][0]==0)
            {
                a[0]=0;
                a[1]=0;
            }
            else  if(setOur[0][2]==0)
            {
                a[0]=0;
                a[1]=2;
            }

            else  if(setOur[2][0]==0)
            {
                a[0]=2;
                a[1]=0;
            }

            else if(setOur[2][2]==0) {
                a[0]=2;
                a[1]=2;

            }
        }

        else
        {
            if(setOur[0][0]==0)
            {
                a[0]=0;
                a[1]=0;
            }
            else  if(setOur[0][3]==0)
            {
                a[0]=0;
                a[1]=3;
            }

            else  if(setOur[3][0]==0)
            {
                a[0]=3;
                a[1]=0;
            }

            else {
                a[0]=3;
                a[1]=3;

            }
        }
        return  a;
    }

    public int[] findOppositeCorner(int in[])
    {
        int a[]=new int[2];
        if(size==3)
        {
            if(in[0]==0&&in[1]==0)
            {
                a[0]=2;
                a[1]=2;
            }
            else  if(in[0]==0&&in[1]==2)
            {
                a[0]=2;
                a[1]=0;
            }

            else  if(in[0]==2&&in[1]==0)
            {
                a[0]=0;
                a[1]=2;
            }

            else {
                a[0]=0;
                a[1]=0;

            }
        }

        else
        {
            if(in[0]==0&&in[1]==0)
            {
                a[0]=3;
                a[1]=3;
            }
            else  if(in[0]==0&&in[1]==3)
            {
                a[0]=3;
                a[1]=0;
            }

            else  if(in[0]==3&&in[1]==0)
            {
                a[0]=0;
                a[1]=3;
            }

            else {
                a[0]=0;
                a[1]=0;

            }
        }
        return  a;
    }

    public int[] findEdge()
    {
        int a[]=new int[2];
          if(size==3) {
              if (setOur[0][1] == 0) {
                  a[0] = 0;
                  a[1] = 1;
              } else if (setOur[1][2] == 0) {
                  a[0] = 1;
                  a[1] = 2;
              } else if (setOur[2][1] == 0) {
                  a[0] = 2;
                  a[1] = 1;
              } else {
                  a[0] = 1;
                  a[1] = 0;

              }
          }
        else
          {
              if(setOur[0][1]==0)
              {
                  a[0]=0;
                  a[1]=1;
              }
              else if(setOur[0][2]==0)
              {
                  a[0]=0;
                  a[1]=2;
              }
              else  if(setOur[1][0]==0)
              {
                  a[0]=1;
                  a[1]=0;
              }
              else  if(setOur[2][0]==0)
              {
                  a[0]=2;
                  a[1]=0;
              }
              else  if(setOur[1][3]==0)
              {
                  a[0]=1;
                  a[1]=3;
              }
              else  if(setOur[2][3]==0)
              {
                  a[0]=2;
                  a[1]=3;
              }

              else  if(setOur[3][1]==0)
              {
                  a[0]=3;
                  a[1]=1;
              }

              else {
                  a[0]=3;
                  a[1]=2;

              }

          }


        return  a;
    }

    public boolean isEnemyWinning()
    {
        if(size==3) {
            if ((setOur[0][0] == setOur[1][0] && setOur[0][0] ==playerOne && setOur[2][0] == 0)
                    || (setOur[0][0] == setOur[2][0] && setOur[0][0] ==playerOne && setOur[1][0] == 0)
                    || (setOur[2][0] == setOur[1][0] && setOur[2][0] ==playerOne && setOur[0][0] == 0)

                    || (setOur[0][1] == setOur[1][1] && setOur[0][1] ==playerOne && setOur[2][1] == 0)
                    || (setOur[0][1] == setOur[2][1] && setOur[0][1] ==playerOne && setOur[1][1] == 0)
                    || (setOur[2][1] == setOur[1][1] && setOur[2][1] ==playerOne && setOur[0][1] == 0)

                    || (setOur[0][2] == setOur[1][2] && setOur[0][2] ==playerOne && setOur[2][2] == 0)
                    || (setOur[0][2] == setOur[2][2] && setOur[0][2] ==playerOne && setOur[1][2] == 0)
                    || (setOur[2][2] == setOur[1][2] && setOur[2][2] ==playerOne && setOur[0][2] == 0)

                    || (setOur[0][0] == setOur[0][1] && setOur[0][0] ==playerOne && setOur[0][2] == 0)
                    || (setOur[0][0] == setOur[0][2] && setOur[0][0] ==playerOne && setOur[0][1] == 0)
                    || (setOur[0][2] == setOur[0][1] && setOur[0][2] ==playerOne && setOur[0][0] == 0)

                    || (setOur[1][0] == setOur[1][1] && setOur[1][0] ==playerOne && setOur[1][2] == 0)
                    || (setOur[1][0] == setOur[1][2] && setOur[1][0] ==playerOne && setOur[1][1] == 0)
                    || (setOur[1][2] == setOur[1][1] && setOur[1][2] ==playerOne && setOur[1][0] == 0)

                    || (setOur[2][0] == setOur[2][1] && setOur[2][0] ==playerOne && setOur[2][2] == 0)
                    || (setOur[2][0] == setOur[2][2] && setOur[2][0] ==playerOne && setOur[2][1] == 0)
                    || (setOur[2][2] == setOur[2][1] && setOur[2][2] ==playerOne && setOur[2][0] == 0)

                    || (setOur[0][0] == setOur[1][1] && setOur[0][0] ==playerOne && setOur[2][2] == 0)
                    || (setOur[0][0] == setOur[2][2] && setOur[2][2] ==playerOne && setOur[1][1] == 0)
                    || (setOur[1][1] == setOur[2][2] && setOur[2][2] ==playerOne && setOur[0][0] == 0)

                    || (setOur[2][0] == setOur[1][1] && setOur[2][0] ==playerOne && setOur[0][2] == 0)
                    || (setOur[2][0] == setOur[0][2] && setOur[2][0] ==playerOne && setOur[1][1] == 0)
                    || (setOur[1][1] == setOur[0][2] && setOur[0][2] ==playerOne && setOur[2][0] == 0)) {
                return true;
            }
        }

        else
        {
            if((setOur[0][0]==setOur[1][0]&&setOur[0][0]==setOur[2][0]&&setOur[0][0]==playerOne&&setOur[3][0]==0)
                    ||(setOur[0][0]==setOur[1][0]&&setOur[0][0]==setOur[3][0]&&setOur[0][0]==playerOne&&setOur[2][0]==0)
                    ||(setOur[0][0]==setOur[2][0]&&setOur[0][0]==setOur[3][0]&&setOur[0][0]==playerOne&&setOur[1][0]==0)
                    ||(setOur[1][0]==setOur[2][0]&&setOur[1][0]==setOur[3][0]&&setOur[1][0]==playerOne&&setOur[0][0]==0)

                    ||(setOur[0][1]==setOur[1][1]&&setOur[0][1]==setOur[2][1]&&setOur[0][1]==playerOne&&setOur[3][1]==0)
                    ||(setOur[0][1]==setOur[1][1]&&setOur[0][1]==setOur[3][1]&&setOur[0][1]==playerOne&&setOur[2][1]==0)
                    ||(setOur[0][1]==setOur[2][1]&&setOur[0][1]==setOur[3][1]&&setOur[0][1]==playerOne&&setOur[1][1]==0)
                    ||(setOur[1][1]==setOur[2][1]&&setOur[1][1]==setOur[3][1]&&setOur[1][1]==playerOne&&setOur[0][1]==0)

                    ||(setOur[0][2]==setOur[1][2]&&setOur[0][2]==setOur[2][2]&&setOur[0][2]==playerOne&&setOur[3][2]==0)
                    ||(setOur[0][2]==setOur[1][2]&&setOur[0][2]==setOur[3][2]&&setOur[0][2]==playerOne&&setOur[2][2]==0)
                    ||(setOur[0][2]==setOur[2][2]&&setOur[0][2]==setOur[3][2]&&setOur[0][2]==playerOne&&setOur[1][2]==0)
                    ||(setOur[1][2]==setOur[2][2]&&setOur[1][2]==setOur[3][2]&&setOur[1][2]==playerOne&&setOur[0][2]==0)

                    ||(setOur[0][3]==setOur[1][3]&&setOur[0][3]==setOur[2][3]&&setOur[0][3]==playerOne&&setOur[3][3]==0)
                    ||(setOur[0][3]==setOur[1][3]&&setOur[0][3]==setOur[3][3]&&setOur[0][3]==playerOne&&setOur[2][3]==0)
                    ||(setOur[0][3]==setOur[2][3]&&setOur[0][3]==setOur[3][3]&&setOur[0][3]==playerOne&&setOur[1][3]==0)
                    ||(setOur[1][3]==setOur[2][3]&&setOur[1][3]==setOur[3][3]&&setOur[1][3]==playerOne&&setOur[0][3]==0)

                    ||(setOur[0][0]==setOur[0][1]&&setOur[0][0]==setOur[0][2]&&setOur[0][0]==playerOne&&setOur[0][3]==0)
                    ||(setOur[0][0]==setOur[0][1]&&setOur[0][0]==setOur[0][3]&&setOur[0][0]==playerOne&&setOur[0][2]==0)
                    ||(setOur[0][0]==setOur[0][2]&&setOur[0][0]==setOur[0][3]&&setOur[0][0]==playerOne&&setOur[0][1]==0)
                    ||(setOur[0][1]==setOur[0][2]&&setOur[0][1]==setOur[0][3]&&setOur[0][1]==playerOne&&setOur[0][0]==0)


                    ||(setOur[1][0]==setOur[1][1]&&setOur[1][0]==setOur[1][2]&&setOur[1][0]==playerOne&&setOur[1][3]==0)
                    ||(setOur[1][0]==setOur[1][1]&&setOur[1][0]==setOur[1][3]&&setOur[1][0]==playerOne&&setOur[1][2]==0)
                    ||(setOur[1][0]==setOur[1][2]&&setOur[1][0]==setOur[1][3]&&setOur[1][0]==playerOne&&setOur[1][1]==0)
                    ||(setOur[1][1]==setOur[1][2]&&setOur[1][1]==setOur[1][3]&&setOur[1][1]==playerOne&&setOur[1][0]==0)

                    ||(setOur[2][0]==setOur[2][1]&&setOur[2][0]==setOur[2][2]&&setOur[2][0]==playerOne&&setOur[2][3]==0)
                    ||(setOur[2][0]==setOur[2][1]&&setOur[2][0]==setOur[2][3]&&setOur[2][0]==playerOne&&setOur[2][2]==0)
                    ||(setOur[2][0]==setOur[2][2]&&setOur[2][0]==setOur[2][3]&&setOur[2][0]==playerOne&&setOur[2][1]==0)
                    ||(setOur[2][1]==setOur[2][2]&&setOur[2][1]==setOur[2][3]&&setOur[2][1]==playerOne&&setOur[2][0]==0)


                    ||(setOur[3][0]==setOur[3][1]&&setOur[3][0]==setOur[3][2]&&setOur[3][0]==playerOne&&setOur[3][3]==0)
                    ||(setOur[3][0]==setOur[3][1]&&setOur[3][0]==setOur[3][3]&&setOur[3][0]==playerOne&&setOur[3][2]==0)
                    ||(setOur[3][0]==setOur[3][2]&&setOur[3][0]==setOur[3][3]&&setOur[3][0]==playerOne&&setOur[3][1]==0)
                    ||(setOur[3][1]==setOur[3][2]&&setOur[3][1]==setOur[3][3]&&setOur[3][1]==playerOne&&setOur[3][0]==0)

                    ||(setOur[0][0]==setOur[1][1]&&setOur[0][0]==setOur[2][2]&&setOur[0][0]==playerOne&&setOur[3][3]==0)
                    ||(setOur[0][0]==setOur[1][1]&&setOur[0][0]==setOur[3][3]&&setOur[0][0]==playerOne&&setOur[2][2]==0)
                    ||(setOur[0][0]==setOur[2][2]&&setOur[0][0]==setOur[3][3]&&setOur[0][0]==playerOne&&setOur[1][1]==0)
                    ||(setOur[1][1]==setOur[2][2]&&setOur[1][1]==setOur[3][3]&&setOur[1][1]==playerOne&&setOur[0][0]==0)


                    ||(setOur[3][0]==setOur[2][1]&&setOur[3][0]==setOur[1][2]&&setOur[3][0]==playerOne&&setOur[0][3]==0)
                    ||(setOur[3][0]==setOur[2][1]&&setOur[3][0]==setOur[0][3]&&setOur[3][0]==playerOne&&setOur[1][2]==0)
                    ||(setOur[3][0]==setOur[1][2]&&setOur[3][0]==setOur[0][3]&&setOur[3][0]==playerOne&&setOur[2][1]==0)
                    ||(setOur[2][1]==setOur[1][2]&&setOur[2][1]==setOur[0][3]&&setOur[2][1]==playerOne&&setOur[3][0]==0)                       )
            {
                return true;
            }
        }


        return false;

    }
    public boolean areWeWinning()
    {
        if(size==3) {
            if ((setOur[0][0] == setOur[1][0] && setOur[0][0] ==playerTwo && setOur[2][0] == 0)
                    || (setOur[0][0] == setOur[2][0] && setOur[0][0] ==playerTwo && setOur[1][0] == 0)
                    || (setOur[2][0] == setOur[1][0] && setOur[2][0] ==playerTwo && setOur[0][0] == 0)

                    || (setOur[0][1] == setOur[1][1] && setOur[0][1] ==playerTwo && setOur[2][1] == 0)
                    || (setOur[0][1] == setOur[2][1] && setOur[0][1] ==playerTwo && setOur[1][1] == 0)
                    || (setOur[2][1] == setOur[1][1] && setOur[2][1] ==playerTwo && setOur[0][1] == 0)

                    || (setOur[0][2] == setOur[1][2] && setOur[0][2] ==playerTwo && setOur[2][2] == 0)
                    || (setOur[0][2] == setOur[2][2] && setOur[0][2] ==playerTwo && setOur[1][2] == 0)
                    || (setOur[2][2] == setOur[1][2] && setOur[2][2] ==playerTwo && setOur[0][2] == 0)

                    || (setOur[0][0] == setOur[0][1] && setOur[0][0] ==playerTwo && setOur[0][2] == 0)
                    || (setOur[0][0] == setOur[0][2] && setOur[0][0] ==playerTwo && setOur[0][1] == 0)
                    || (setOur[0][2] == setOur[0][1] && setOur[0][2] ==playerTwo && setOur[0][0] == 0)

                    || (setOur[1][0] == setOur[1][1] && setOur[1][0] ==playerTwo && setOur[1][2] == 0)
                    || (setOur[1][0] == setOur[1][2] && setOur[1][0] ==playerTwo && setOur[1][1] == 0)
                    || (setOur[1][2] == setOur[1][1] && setOur[1][2] ==playerTwo && setOur[1][0] == 0)

                    || (setOur[2][0] == setOur[2][1] && setOur[2][0] ==playerTwo && setOur[2][2] == 0)
                    || (setOur[2][0] == setOur[2][2] && setOur[2][0] ==playerTwo && setOur[2][1] == 0)
                    || (setOur[2][2] == setOur[2][1] && setOur[2][2] ==playerTwo && setOur[2][0] == 0)

                    || (setOur[0][0] == setOur[1][1] && setOur[0][0] ==playerTwo && setOur[2][2] == 0)
                    || (setOur[0][0] == setOur[2][2] && setOur[2][2] ==playerTwo && setOur[1][1] == 0)
                    || (setOur[1][1] == setOur[2][2] && setOur[2][2] ==playerTwo && setOur[0][0] == 0)

                    || (setOur[2][0] == setOur[1][1] && setOur[2][0] ==playerTwo && setOur[0][2] == 0)
                    || (setOur[2][0] == setOur[0][2] && setOur[2][0] ==playerTwo && setOur[1][1] == 0)
                    || (setOur[1][1] == setOur[0][2] && setOur[0][2] ==playerTwo && setOur[2][0] == 0)) {
                return true;
            }
        }

        else
        {
            if((setOur[0][0]==setOur[1][0]&&setOur[0][0]==setOur[2][0]&&setOur[0][0]==playerTwo&&setOur[3][0]==0)
                    ||(setOur[0][0]==setOur[1][0]&&setOur[0][0]==setOur[3][0]&&setOur[0][0]==playerTwo&&setOur[2][0]==0)
                    ||(setOur[0][0]==setOur[2][0]&&setOur[0][0]==setOur[3][0]&&setOur[0][0]==playerTwo&&setOur[1][0]==0)
                    ||(setOur[1][0]==setOur[2][0]&&setOur[1][0]==setOur[3][0]&&setOur[1][0]==playerTwo&&setOur[0][0]==0)

                    ||(setOur[0][1]==setOur[1][1]&&setOur[0][1]==setOur[2][1]&&setOur[0][1]==playerTwo&&setOur[3][1]==0)
                    ||(setOur[0][1]==setOur[1][1]&&setOur[0][1]==setOur[3][1]&&setOur[0][1]==playerTwo&&setOur[2][1]==0)
                    ||(setOur[0][1]==setOur[2][1]&&setOur[0][1]==setOur[3][1]&&setOur[0][1]==playerTwo&&setOur[1][1]==0)
                    ||(setOur[1][1]==setOur[2][1]&&setOur[1][1]==setOur[3][1]&&setOur[1][1]==playerTwo&&setOur[0][1]==0)

                    ||(setOur[0][2]==setOur[1][2]&&setOur[0][2]==setOur[2][2]&&setOur[0][2]==playerTwo&&setOur[3][2]==0)
                    ||(setOur[0][2]==setOur[1][2]&&setOur[0][2]==setOur[3][2]&&setOur[0][2]==playerTwo&&setOur[2][2]==0)
                    ||(setOur[0][2]==setOur[2][2]&&setOur[0][2]==setOur[3][2]&&setOur[0][2]==playerTwo&&setOur[1][2]==0)
                    ||(setOur[1][2]==setOur[2][2]&&setOur[1][2]==setOur[3][2]&&setOur[1][2]==playerTwo&&setOur[0][2]==0)

                    ||(setOur[0][3]==setOur[1][3]&&setOur[0][3]==setOur[2][3]&&setOur[0][3]==playerTwo&&setOur[3][3]==0)
                    ||(setOur[0][3]==setOur[1][3]&&setOur[0][3]==setOur[3][3]&&setOur[0][3]==playerTwo&&setOur[2][3]==0)
                    ||(setOur[0][3]==setOur[2][3]&&setOur[0][3]==setOur[3][3]&&setOur[0][3]==playerTwo&&setOur[1][3]==0)
                    ||(setOur[1][3]==setOur[2][3]&&setOur[1][3]==setOur[3][3]&&setOur[1][3]==playerTwo&&setOur[0][3]==0)

                    ||(setOur[0][0]==setOur[0][1]&&setOur[0][0]==setOur[0][2]&&setOur[0][0]==playerTwo&&setOur[0][3]==0)
                    ||(setOur[0][0]==setOur[0][1]&&setOur[0][0]==setOur[0][3]&&setOur[0][0]==playerTwo&&setOur[0][2]==0)
                    ||(setOur[0][0]==setOur[0][2]&&setOur[0][0]==setOur[0][3]&&setOur[0][0]==playerTwo&&setOur[0][1]==0)
                    ||(setOur[0][1]==setOur[0][2]&&setOur[0][1]==setOur[0][3]&&setOur[0][1]==playerTwo&&setOur[0][0]==0)


                    ||(setOur[1][0]==setOur[1][1]&&setOur[1][0]==setOur[1][2]&&setOur[1][0]==playerTwo&&setOur[1][3]==0)
                    ||(setOur[1][0]==setOur[1][1]&&setOur[1][0]==setOur[1][3]&&setOur[1][0]==playerTwo&&setOur[1][2]==0)
                    ||(setOur[1][0]==setOur[1][2]&&setOur[1][0]==setOur[1][3]&&setOur[1][0]==playerTwo&&setOur[1][1]==0)
                    ||(setOur[1][1]==setOur[1][2]&&setOur[1][1]==setOur[1][3]&&setOur[1][1]==playerTwo&&setOur[1][0]==0)

                    ||(setOur[2][0]==setOur[2][1]&&setOur[2][0]==setOur[2][2]&&setOur[2][0]==playerTwo&&setOur[2][3]==0)
                    ||(setOur[2][0]==setOur[2][1]&&setOur[2][0]==setOur[2][3]&&setOur[2][0]==playerTwo&&setOur[2][2]==0)
                    ||(setOur[2][0]==setOur[2][2]&&setOur[2][0]==setOur[2][3]&&setOur[2][0]==playerTwo&&setOur[2][1]==0)
                    ||(setOur[2][1]==setOur[2][2]&&setOur[2][1]==setOur[2][3]&&setOur[2][1]==playerTwo&&setOur[2][0]==0)


                    ||(setOur[3][0]==setOur[3][1]&&setOur[3][0]==setOur[3][2]&&setOur[3][0]==playerTwo&&setOur[3][3]==0)
                    ||(setOur[3][0]==setOur[3][1]&&setOur[3][0]==setOur[3][3]&&setOur[3][0]==playerTwo&&setOur[3][2]==0)
                    ||(setOur[3][0]==setOur[3][2]&&setOur[3][0]==setOur[3][3]&&setOur[3][0]==playerTwo&&setOur[3][1]==0)
                    ||(setOur[3][1]==setOur[3][2]&&setOur[3][1]==setOur[3][3]&&setOur[3][1]==playerTwo&&setOur[3][0]==0)

                    ||(setOur[0][0]==setOur[1][1]&&setOur[0][0]==setOur[2][2]&&setOur[0][0]==playerTwo&&setOur[3][3]==0)
                    ||(setOur[0][0]==setOur[1][1]&&setOur[0][0]==setOur[3][3]&&setOur[0][0]==playerTwo&&setOur[2][2]==0)
                    ||(setOur[0][0]==setOur[2][2]&&setOur[0][0]==setOur[3][3]&&setOur[0][0]==playerTwo&&setOur[1][1]==0)
                    ||(setOur[1][1]==setOur[2][2]&&setOur[1][1]==setOur[3][3]&&setOur[1][1]==playerTwo&&setOur[0][0]==0)


                    ||(setOur[3][0]==setOur[2][1]&&setOur[3][0]==setOur[1][2]&&setOur[3][0]==playerTwo&&setOur[0][3]==0)
                    ||(setOur[3][0]==setOur[2][1]&&setOur[3][0]==setOur[0][3]&&setOur[3][0]==playerTwo&&setOur[1][2]==0)
                    ||(setOur[3][0]==setOur[1][2]&&setOur[3][0]==setOur[0][3]&&setOur[3][0]==playerTwo&&setOur[2][1]==0)
                    ||(setOur[2][1]==setOur[1][2]&&setOur[2][1]==setOur[0][3]&&setOur[2][1]==playerTwo&&setOur[3][0]==0)                       )
            {
                return true;
            }
        }


        return false;


    }


    public int[] findWinningIndex(int player)
    {
        int[] a= new int[2];

        if(size==3) {
            if (setOur[0][0] == setOur[1][0] && setOur[0][0] ==player && setOur[2][0] ==0)
            {
                a[0]=2;
                a[1]=0;
            }
            else if (setOur[0][0] == setOur[2][0] && setOur[0][0] ==player && setOur[1][0] ==0)
            {
                a[0]=1 ;
                a[1]=0;
            }
            else if (setOur[2][0] == setOur[1][0] && setOur[2][0] ==player && setOur[0][0] ==0)
            {
                a[0]=0 ;
                a[1]=0;
            }

            else if (setOur[0][1] == setOur[1][1] && setOur[0][1] ==player && setOur[2][1] ==0)
            {
                a[0]= 2;
                a[1]=1;
            }
            else if(setOur[0][1] == setOur[2][1] && setOur[0][1] ==player && setOur[1][1] ==0)
            {
                a[0]=1 ;
                a[1]=1;
            }
            else if(setOur[2][1] == setOur[1][1] && setOur[2][1] ==player && setOur[0][1] ==0)
            {
                a[0]= 0;
                a[1]=1;
            }

            else if (setOur[0][2] == setOur[1][2] && setOur[0][2] ==player && setOur[2][2] ==0)
            {
                a[0]= 2;
                a[1]=2;
            }
            else if(setOur[0][2] == setOur[2][2] && setOur[0][2] ==player && setOur[1][2] ==0)
            {
                a[0]= 1;
                a[1]=2;
            }
            else if (setOur[2][2] == setOur[1][2] && setOur[2][2] ==player && setOur[0][2] ==0)
            {
                a[0]= 0;
                a[1]=2;
            }

            else if (setOur[0][0] == setOur[0][1] && setOur[0][0] ==player && setOur[0][2] ==0)
            {
                a[0]=0 ;
                a[1]=2;
            }
            else if (setOur[0][0] == setOur[0][2] && setOur[0][0] ==player && setOur[0][1] ==0)
            {
                a[0]= 0;
                a[1]=1;
            }
            else if(setOur[0][2] == setOur[0][1] && setOur[0][2] ==player && setOur[0][0] ==0)
            {
                a[0]=0 ;
                a[1]=0;
            }

            else if(setOur[1][0] == setOur[1][1] && setOur[1][0] ==player && setOur[1][2] ==0)
            {
                a[0]=1 ;
                a[1]=2;
            }
            else if(setOur[1][0] == setOur[1][2] && setOur[1][0] ==player && setOur[1][1] ==0)
            {
                a[0]= 1;
                a[1]=1;
            }
            else if (setOur[1][2] == setOur[1][1] && setOur[1][2] ==player && setOur[1][0] ==0)
            {
                a[0]=1 ;
                a[1]=0;
            }

            else if (setOur[2][0] == setOur[2][1] && setOur[2][0] ==player && setOur[2][2] ==0)
            {
                a[0]= 2;
                a[1]=2;
            }
            else if (setOur[2][0] == setOur[2][2] && setOur[2][0] ==player && setOur[2][1] ==0)
            {
                a[0]=2 ;
                a[1]=1;
            }
            else if (setOur[2][2] == setOur[2][1] && setOur[2][2] ==player && setOur[2][0] ==0)
            {
                a[0]= 2;
                a[1]=0;
            }

            else if (setOur[0][0] == setOur[1][1] && setOur[0][0] ==player && setOur[2][2] ==0)
            {
                a[0]=2 ;
                a[1]=2;
            }
            else  if (setOur[0][0] == setOur[2][2] && setOur[2][2] ==player && setOur[1][1] ==0)
            {
                a[0]=1 ;
                a[1]=1;
            }
            else if (setOur[1][1] == setOur[2][2] && setOur[2][2] ==player && setOur[0][0] ==0)
            {
                a[0]= 0;
                a[1]=0;
            }

            else if (setOur[2][0] == setOur[1][1] && setOur[2][0] ==player && setOur[0][2] ==0)
            {
                a[0]=0 ;
                a[1]=2;
            }
            else if (setOur[2][0] == setOur[0][2] && setOur[2][0] ==player && setOur[1][1] ==0)
            {
                a[0]= 1;
                a[1]=1;
            }
            else if (setOur[1][1] == setOur[0][2] && setOur[0][2] ==player && setOur[2][0] ==0)
            {
                a[0]= 2;
                a[1]=0;
            }

        }


        else
        {
            if(setOur[0][0]==setOur[1][0]&&setOur[0][0]==setOur[2][0]&&setOur[0][0]==player&&setOur[3][0]==0)
            {
                a[0]=3 ;
                a[1]=0;
            }
            else if(setOur[0][0]==setOur[1][0]&&setOur[0][0]==setOur[3][0]&&setOur[0][0]==player&&setOur[2][0]==0)
            {
                a[0]= 2;
                a[1]=0;
            }
            else if(setOur[0][0]==setOur[2][0]&&setOur[0][0]==setOur[3][0]&&setOur[0][0]==player&&setOur[1][0]==0)
            {
                a[0]=1 ;
                a[1]=0;
            }
            else if(setOur[1][0]==setOur[2][0]&&setOur[1][0]==setOur[3][0]&&setOur[1][0]==player&&setOur[0][0]==0)
            {
                a[0]=0 ;
                a[1]=0;
            }

            else if(setOur[0][1]==setOur[1][1]&&setOur[0][1]==setOur[2][1]&&setOur[0][1]==player&&setOur[3][1]==0)
            {
                a[0]=3 ;
                a[1]=1;
            }
            else if(setOur[0][1]==setOur[1][1]&&setOur[0][1]==setOur[3][1]&&setOur[0][1]==player&&setOur[2][1]==0)
            {
                a[0]=2 ;
                a[1]=1;
            }
            else if(setOur[0][1]==setOur[2][1]&&setOur[0][1]==setOur[3][1]&&setOur[0][1]==player&&setOur[1][1]==0)
            {
                a[0]=1 ;
                a[1]=1;
            }
            else if(setOur[1][1]==setOur[2][1]&&setOur[1][1]==setOur[3][1]&&setOur[1][1]==player&&setOur[0][1]==0)
            {
                a[0]=0 ;
                a[1]=1;
            }

            else if(setOur[0][2]==setOur[1][2]&&setOur[0][2]==setOur[2][2]&&setOur[0][2]==player&&setOur[3][2]==0)
            {
                a[0]=3 ;
                a[1]=2;
            }
            else if(setOur[0][2]==setOur[1][2]&&setOur[0][2]==setOur[3][2]&&setOur[0][2]==player&&setOur[2][2]==0)
            {
                a[0]=2 ;
                a[1]=2;
            }
            else if(setOur[0][2]==setOur[2][2]&&setOur[0][2]==setOur[3][2]&&setOur[0][2]==player&&setOur[1][2]==0)
            {
                a[0]=1 ;
                a[1]=2;
            }
            else if(setOur[1][2]==setOur[2][2]&&setOur[1][2]==setOur[3][2]&&setOur[1][2]==player&&setOur[0][2]==0)
            {
                a[0]=0 ;
                a[1]=2;
            }

            else if(setOur[0][3]==setOur[1][3]&&setOur[0][3]==setOur[2][3]&&setOur[0][3]==player&&setOur[3][3]==0)
            {
                a[0]=3 ;
                a[1]=3;
            }
            else if(setOur[0][3]==setOur[1][3]&&setOur[0][3]==setOur[3][3]&&setOur[0][3]==player&&setOur[2][3]==0)
            {
                a[0]= 2;
                a[1]=3;
            }
            else if(setOur[0][3]==setOur[2][3]&&setOur[0][3]==setOur[3][3]&&setOur[0][3]==player&&setOur[1][3]==0)
            {
                a[0]= 1;
                a[1]=3;
            }
            else if(setOur[1][3]==setOur[2][3]&&setOur[1][3]==setOur[3][3]&&setOur[1][3]==player&&setOur[0][3]==0)
            {
                a[0]= 0;
                a[1]=3;
            }

            else if(setOur[0][0]==setOur[0][1]&&setOur[0][0]==setOur[0][2]&&setOur[0][0]==player&&setOur[0][3]==0)
            {
                a[0]=0 ;
                a[1]=3;
            }
            else if(setOur[0][0]==setOur[0][1]&&setOur[0][0]==setOur[0][3]&&setOur[0][0]==player&&setOur[0][2]==0)
            {
                a[0]= 0;
                a[1]=2;
            }
            else if(setOur[0][0]==setOur[0][2]&&setOur[0][0]==setOur[0][3]&&setOur[0][0]==player&&setOur[0][1]==0)
            {
                a[0]=0 ;
                a[1]=1;
            }
            else if(setOur[0][1]==setOur[0][2]&&setOur[0][1]==setOur[0][3]&&setOur[0][1]==player&&setOur[0][0]==0)
            {
                a[0]=0 ;
                a[1]=0;
            }


            else if(setOur[1][0]==setOur[1][1]&&setOur[1][0]==setOur[1][2]&&setOur[1][0]==player&&setOur[1][3]==0)
            {
                a[0]= 1;
                a[1]=3;
            }
            else if(setOur[1][0]==setOur[1][1]&&setOur[1][0]==setOur[1][3]&&setOur[1][0]==player&&setOur[1][2]==0)
            {
                a[0]= 1;
                a[1]=2;
            }
            else if(setOur[1][0]==setOur[1][2]&&setOur[1][0]==setOur[1][3]&&setOur[1][0]==player&&setOur[1][1]==0)
            {
                a[0]=1 ;
                a[1]=1;
            }
            else if(setOur[1][1]==setOur[1][2]&&setOur[1][1]==setOur[1][3]&&setOur[1][1]==player&&setOur[1][0]==0)
            {
                a[0]= 1;
                a[1]=0;
            }

            else if(setOur[2][0]==setOur[2][1]&&setOur[2][0]==setOur[2][2]&&setOur[2][0]==player&&setOur[2][3]==0)
            {
                a[0]=2 ;
                a[1]=3;
            }
            else if(setOur[2][0]==setOur[2][1]&&setOur[2][0]==setOur[2][3]&&setOur[2][0]==player&&setOur[2][2]==0)
            {
                a[0]=2 ;
                a[1]=2;
            }
            else if(setOur[2][0]==setOur[2][2]&&setOur[2][0]==setOur[2][3]&&setOur[2][0]==player&&setOur[2][1]==0)
            {
                a[0]=2 ;
                a[1]=1;
            }
            else if(setOur[2][1]==setOur[2][2]&&setOur[2][1]==setOur[2][3]&&setOur[2][1]==player&&setOur[2][0]==0)
            {
                a[0]=2 ;
                a[1]=0;
            }


            else if(setOur[3][0]==setOur[3][1]&&setOur[3][0]==setOur[3][2]&&setOur[3][0]==player&&setOur[3][3]==0)
            {
                a[0]= 3;
                a[1]=3;
            }
            else if(setOur[3][0]==setOur[3][1]&&setOur[3][0]==setOur[3][3]&&setOur[3][0]==player&&setOur[3][2]==0)
            {
                a[0]=3 ;
                a[1]=2;
            }
            else if(setOur[3][0]==setOur[3][2]&&setOur[3][0]==setOur[3][3]&&setOur[3][0]==player&&setOur[3][1]==0)
            {
                a[0]= 3;
                a[1]=1;
            }
            else if(setOur[3][1]==setOur[3][2]&&setOur[3][1]==setOur[3][3]&&setOur[3][1]==player&&setOur[3][0]==0)
            {
                a[0]=3 ;
                a[1]=0;
            }

            else if(setOur[0][0]==setOur[1][1]&&setOur[0][0]==setOur[2][2]&&setOur[0][0]==player&&setOur[3][3]==0)
            {
                a[0]=3 ;
                a[1]=3;
            }
            else if(setOur[0][0]==setOur[1][1]&&setOur[0][0]==setOur[3][3]&&setOur[0][0]==player&&setOur[2][2]==0)
            {
                a[0]=2 ;
                a[1]=2;
            }
            else if(setOur[0][0]==setOur[2][2]&&setOur[0][0]==setOur[3][3]&&setOur[0][0]==player&&setOur[1][1]==0)
            {
                a[0]= 1;
                a[1]=1;
            }
            else if(setOur[1][1]==setOur[2][2]&&setOur[1][1]==setOur[3][3]&&setOur[1][1]==player&&setOur[0][0]==0)
            {
                a[0]=0 ;
                a[1]=0;
            }


            else if(setOur[3][0]==setOur[2][1]&&setOur[3][0]==setOur[1][2]&&setOur[3][0]==player&&setOur[0][3]==0)
            {
                a[0]= 0;
                a[1]=3;
            }
            else if(setOur[3][0]==setOur[2][1]&&setOur[3][0]==setOur[0][3]&&setOur[3][0]==player&&setOur[1][2]==0)
            {
                a[0]= 1;
                a[1]=2;
            }
            else if(setOur[3][0]==setOur[1][2]&&setOur[3][0]==setOur[0][3]&&setOur[3][0]==player&&setOur[2][1]==0)
            {
                a[0]= 2;
                a[1]=1;
            }
            else if(setOur[2][1]==setOur[1][2]&&setOur[2][1]==setOur[0][3]&&setOur[2][1]==player&&setOur[3][0]==0)
            {
                a[0]= 3;
                a[1]=0;
            }

        }

        return a;


    }
    public int returnPosition(int[] a)
    {
        if(size==3)
        {
            if(a[0]==0)
            {
                if(a[1]==0)
                    return 0;

                if(a[1]==1)
                    return 1;

                if(a[1]==2)
                    return 2;
            }

            if(a[0]==1)
            {
                if(a[1]==0)
                    return 3;

                if(a[1]==1)
                    return 4;

                if(a[1]==2)
                    return 5;
            }

            if(a[0]==2)
            {
                if(a[1]==0)
                    return 6;

                if(a[1]==1)
                    return 7;

                if(a[1]==2)
                    return 8;
            }
        }

        else
        {
            if(a[0]==0)
            {
                if(a[1]==0)
                    return 0;

                if(a[1]==1)
                    return 1;

                if(a[1]==2)
                    return 2;
                if(a[1]==3)
                    return 3;
            }

            if(a[0]==1)
            {
                if(a[1]==0)
                    return 4;

                if(a[1]==1)
                    return 5;

                if(a[1]==2)
                    return 6;
                if(a[1]==3)
                    return 7;
            }

            if(a[0]==2)
            {
                if(a[1]==0)
                    return 8;

                if(a[1]==1)
                    return 9;

                if(a[1]==2)
                    return 10;
                if(a[1]==3)
                    return 11;
            }

            if(a[0]==3)
            {
                if(a[1]==0)
                    return 12;

                if(a[1]==1)
                    return 13;

                if(a[1]==2)
                    return 14;
                if(a[1]==3)
                    return 15;
            }
        }
        return -1;
    }


    public int getPosition()
    {
        int[] a=new int[2];
        int[] b=new int[2];
        if(areWeWinning())
        {  Log.d("TAG", "getPosition:  are weWINNING+++++++++++");
            a=findWinningIndex(playerTwo);
            Log.d("TAG", "getPosition: WINNING INDEX= "+a[0]+","+a[1]);
            return returnPosition(a);
        }
        if(isEnemyWinning())
        {  Log.d("TAG", "getPosition:  is enemy WINNING+++++++++++");
            a=findWinningIndex(playerOne);
            Log.d("TAG", "getPosition: WINNING INDEX= "+a[0]+","+a[1]);
            return returnPosition(a);
        }
        if(checkCenter()&&size==3)
            return 4;
        if(checkCorner())
        {
            Log.d("TAG", "getPosition:  CHECK CORNER");
            a=findCorner();
            b=findOppositeCorner(a);
            Log.d("TAG", "getPosition:  CHECKED CORNER IS "+a[0]+","+a[1]);
            Log.d("TAG", "getPosition: FOUND CORNER IS "+b[0]+","+b[1]);

            while(setOur[b[0]][b[1]]==0&&checkCorner())
            {     Log.d("TAG", "getPosition:  WHILE LOOP*******");

                Log.d("TAG", "getPosition: WHILE LOOP CHECKED CORNER IS "+a[0]+","+a[1]);
                Log.d("TAG", "getPosition: WHILE LOOP FOUND CORNER IS "+b[0]+","+b[1]);
                setOur[a[0]][a[1]]=-1;
                setOur[b[0]][b[1]]=-1;
                if(size==3)
            {
                if(setOur[0][0]!=0&&setOur[0][2]!=0&&setOur[2][0]!=0&&setOur[2][2]!=0) {
                    Log.d("TAG", "getPosition:  SIZE 3 LOOP BREAK");
                    break;
                }
            }
                else
            {
                if(setOur[0][0]!=0&&setOur[0][3]!=0&&setOur[3][0]!=0&&setOur[3][3]!=0) {
                    Log.d("TAG", "getPosition:  SIZE 4 LOOP BEAK");
                    break;
                }
            }

                a=findCorner();
                b=findOppositeCorner(a);

                Log.d("TAG", "getPosition: WHILE LOOP END**** CHECKED CORNER IS "+a[0]+","+a[1]);
                Log.d("TAG", "getPosition: WHILE LOOP END****FOUND CORNER IS "+b[0]+","+b[1]);
            }

            if(size==3)
            {    Log.d("TAG", "getPosition: MINUS ONE COMPENSATE SIZE 3");
                if(setOur[0][0]==-1)
                    setOur[0][0]=0;
                if(setOur[0][2]==-1)
                    setOur[0][2]=0;
                if(setOur[2][0]==-1)
                    setOur[2][0]=0;
                if(setOur[2][2]==-1)
                    setOur[2][2]=0;
            }
            else
            {
                if(setOur[0][0]==-1)
                    setOur[0][0]=0;
                if(setOur[0][3]==-1)
                    setOur[0][3]=0;
                if(setOur[3][0]==-1)
                    setOur[3][0]=0;
                if(setOur[3][3]==-1)
                    setOur[3][3]=0;
            }
            Log.d("TAG", "getPosition: RETURNING POSITION "+a[0]+", "+a[1]);
            return returnPosition(a);
        }

        if(checkEdge())
        {   Log.d("TAG", "getPosition: CHECK EDGE***");
            a=findEdge();
            Log.d("TAG", "getPosition: EDGE INDEX= "+a[0]+","+a[1]);
            return  returnPosition(a);
        }

        else {
            Log.d("TAG", "getPosition:  RANDOM NUMBER");
            Random r = new Random();
            int i;
            if (size != 4) {
                i = r.nextInt(9);
                Log.d("TAG", "i OUTSIDE LOOP FOUND=" + String.valueOf(i));
                while (set[i] != 0) {
                    i = r.nextInt(9);
                    Log.d("TAG", "i INSIDE-*------------ LOOP FOUND=" + String.valueOf(i));
                }
                Log.d("TAG", "RETURNING i========++++++=" + String.valueOf(i));
                return i;
            }
            i = r.nextInt(16);
            while (set[i] != 0) {
                i = r.nextInt(16);
            }

            return i;
        }
    }


}

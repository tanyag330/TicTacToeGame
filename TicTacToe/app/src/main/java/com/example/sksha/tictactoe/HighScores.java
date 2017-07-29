package com.example.sksha.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class HighScores extends AppCompatActivity {
    ListView lvHighScores;
    ImageButton ibHallOfFame;
    StudentsListAdapter studentsListAdapter;
    NetFetchTask myTask;
    int i;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        i=-1;
        setContentView(R.layout.hall_of_fame);
        lvHighScores = (ListView) findViewById(R.id.lv_hall_of_fame);
        ibHallOfFame = (ImageButton) findViewById(R.id.ib_hall_of_fame);


       /* myTask = new NetFetchTask(new NetFetchTask.PostExecuteListener() {
            @Override
            public void postExecuteDone(ArrayList<Events> event) {
                // Log.d("**************", "StudentsListAdapter: "+event.get(0).name);
              studentsListAdapter =new StudentsListAdapter(event);
                lvHighScores.setAdapter(studentsListAdapter);


            }
        },i);
        myTask.execute("https://api.myjson.com/bins/4957r");*/

        ibHallOfFame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                myTask = new NetFetchTask(new NetFetchTask.PostExecuteListener() {
                    @Override
                    public void postExecuteDone(ArrayList<Events> event) {
                        // Log.d("**************", "StudentsListAdapter: "+event.get(0).name);
                        studentsListAdapter =new StudentsListAdapter(event);
                        lvHighScores.setAdapter(studentsListAdapter);
                       // studentsListAdapter.notifyDataSetChanged();

                    }
                },i);
                myTask.execute("https://api.myjson.com/bins/4957r");
            }
        });
    }

    private class StudentsListAdapter extends BaseAdapter {

        public class StudentsViewHolder{
            TextView nameView;
            TextView scoreView;

        }
        private  ArrayList<Events> sList;
        public StudentsListAdapter(ArrayList<Events> sList)
        {
            this.sList=sList;
            //Log.d("**************", "StudentsListAdapter: "+sList.get(0).name);
        }

        @Override
        public int getCount() {
            return sList.size();
        }

        @Override
        public Events getItem(int position) {
            return sList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            StudentsViewHolder studentsViewHolder;
            if(convertView==null) {
                convertView = getLayoutInflater().inflate(R.layout.lv_hall_of_fame, null);

                studentsViewHolder=new StudentsViewHolder();
                studentsViewHolder.nameView=(TextView)convertView.findViewById(R.id.tv_name_hall_of_fame);
                studentsViewHolder.scoreView=(TextView)convertView.findViewById(R.id.tv_scores_hall_of_fame);
                convertView.setTag(studentsViewHolder);
            }
            else
            {
                studentsViewHolder=(StudentsViewHolder)convertView.getTag();
            }

            Events thisStudent=getItem(position);
            studentsViewHolder.nameView.setText(thisStudent.name);
            studentsViewHolder.scoreView.setText(String.valueOf(thisStudent.score));
            return convertView;
        }
    }
}

package com.example.sksha.tictactoe;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sksha on 30-06-2016.
 */
public class ProPack extends AppCompatActivity {

    RecyclerView proRecyclerView;
    ArrayList<ProLists.ProList> proLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pro_pack);
        proRecyclerView= (RecyclerView) findViewById(R.id.rv_pro_pack);
        proLists= ProLists.getPackList();
        ProRecyclerViewAdapter proRecyclerViewAdapter = new ProRecyclerViewAdapter(proLists);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        proRecyclerView.setLayoutManager(layoutManager);
        proRecyclerView.setAdapter(proRecyclerViewAdapter);
        //proRecyclerViewAdapter.notifyDataSetChanged();
    }

    public class ProRecyclerViewHolder extends RecyclerView.ViewHolder
    {
         public TextView tvProList;
        public Button btnBuy;
        public ProRecyclerViewHolder(View itemView) {
            super(itemView);
            tvProList= (TextView)itemView.findViewById(R.id.tv_pro_list);
            btnBuy= (Button)itemView.findViewById(R.id.btn_buy);
        }
    }

    public class ProRecyclerViewAdapter extends RecyclerView.Adapter<ProRecyclerViewHolder>
    {
        private ArrayList<ProLists.ProList> proArrayList;
        public ProRecyclerViewAdapter(ArrayList<ProLists.ProList> proArrayList)
        {
            this.proArrayList=proArrayList;
        }

        @Override
        public ProRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater li = getLayoutInflater();
            View itemView = li.inflate(R.layout.recycler_view_layout, parent,false);
            ProRecyclerViewHolder proRecyclerViewHolder=new ProRecyclerViewHolder(itemView);
            return proRecyclerViewHolder;
        }

        @Override
        public void onBindViewHolder(ProRecyclerViewHolder holder, int position) {
          ProLists.ProList thisproList= proArrayList.get(position);
            holder.tvProList.setText(thisproList.packName+" @"+thisproList.packAmount);
            holder.btnBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog= new Dialog(ProPack.this);
                    dialog.setContentView(R.layout.pro_pack_purchase);
                    dialog.setCanceledOnTouchOutside(false);
                    Button btnOk;
                    btnOk= (Button) dialog.findViewById(R.id.btn_ok);
                    dialog.setTitle("  READ CAREFULLY!!");
                    btnOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return proArrayList.size();
        }
    }
}

package com.example.sksha.tictactoe;

import java.util.ArrayList;

/**
 * Created by sksha on 02-07-2016.
 */
public class ProLists {
    public static class ProList {
        String packName;
        String packAmount;

        public ProList(String packName, String packAmount) {
            this.packName = packName;
            this.packAmount = packAmount;
        }
    }
    public static ArrayList<ProList> getPackList()
    {
        ArrayList<ProList> proLists=new ArrayList<>();
        proLists.add(new ProList("UNLIMITED WIN","RS.10"));
        proLists.add(new ProList("LIMITED WIN","RS.1"));
        proLists.add(new ProList("ROOT PACK(rooted users)","RS.5"));
        proLists.add(new ProList("OK OK PACK","RS.7"));
        proLists.add(new ProList("PACK PACK","RS.2"));
        proLists.add(new ProList("TIME WASTE","RS.100"));
        proLists.add(new ProList("MORE TIME WASTE","RS.101"));
        proLists.add(new ProList("LESS TIME WASTE","RS.99"));
        proLists.add(new ProList("YOUR TIME WASTE","RS.0"));
        proLists.add(new ProList("MY TIME WASTE","RS.1000"));

        return  proLists;
    }
}

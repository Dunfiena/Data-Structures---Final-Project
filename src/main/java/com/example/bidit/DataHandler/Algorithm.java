package com.example.bidit.DataHandler;

import java.util.ArrayList;

public class Algorithm {

    public DataStructure returnWinner(ArrayList<DataStructure> arrayList){
        int winner = 0;
        int highest = 0;
        int leader = 0;
        ArrayList<DataStructure> checkTime = new ArrayList<>();

        arrayList = sortHighest(arrayList);
        for (DataStructure b: arrayList) {
            highest = b.getBidAmount();
            if (highest == arrayList.get(0).getBidAmount()) {
                checkTime.add(b);
            }
        }
        if (checkTime.size() > 1) {
            arrayList = checkTimeSig(arrayList);
        }
        return arrayList.get(0);
    }

    public ArrayList<DataStructure> sortHighest(ArrayList<DataStructure> unsorted){
        for (int i = 0; i < unsorted.size(); i++){
            for(int j = 0; j < unsorted.size(); j++){
                if (unsorted.get(i).getBidAmount() > unsorted.get(j).getBidAmount()) {
                    DataStructure tmp = unsorted.get(i);
                    unsorted.set(i, unsorted.get(j));
                    unsorted.set(j, tmp);
                }
            }
        }
        return unsorted;
    }

    public ArrayList<DataStructure> checkTimeSig(ArrayList<DataStructure> untimed) {
        for (int i = 0; i < untimed.size(); i++){
            for(int j = 0; j < untimed.size(); j++){
                if (untimed.get(i).getTime().before(untimed.get(j).getTime())) {
                    DataStructure tmp = untimed.get(i);
                    untimed.set(i, untimed.get(j));
                    untimed.set(j, tmp);
                }
            }
        }

        return untimed;
    }
}

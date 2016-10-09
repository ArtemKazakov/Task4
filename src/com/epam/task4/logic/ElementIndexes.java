package com.epam.task4.logic;

import java.util.Arrays;

/**
 * Created by ASUS on 09.10.2016.
 */
public class ElementIndexes {
    private int[] indexes = {0 ,0};
    private int rowCount;
    private int colCount;
    private boolean done;

    public int[] getIndexes() {
            int[] returnCoords = Arrays.copyOf(indexes, indexes.length);
            nextIndexes();
            return returnCoords;
    }

    public ElementIndexes(int colCount, int rowCount){
        this.rowCount = rowCount;
        this.colCount = colCount;
    }

    public void nextIndexes(){
        if(indexes[1] == colCount-1){
            if(indexes[0] != rowCount-1) {
                indexes[0] = indexes[0] + 1;
                indexes[1] = 0;
            }
            else {
                done = true;
            }
        } else {
            indexes[1] = indexes[1] + 1;
        }
    }

    public boolean isDone() {
        return done;
    }
}

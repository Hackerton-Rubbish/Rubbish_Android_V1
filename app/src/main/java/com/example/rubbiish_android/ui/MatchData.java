package com.example.rubbiish_android.ui;

import android.media.Image;
import android.widget.ImageView;

public class MatchData {
    private String matchItemName;
    private int matchItemCnt, matchItemImage;

    public MatchData(String matchItemName, int matchItemCnt, int matchItemImage){
        this.matchItemName = matchItemName;
        this.matchItemCnt = matchItemCnt;
        this.matchItemImage = matchItemImage;
    }

    public String getMatchItemName() {
        return matchItemName;
    }
    public void setMatchItemName(String matchItemName) {
        this.matchItemName = matchItemName;
    }
    public int getMatchItemCnt() {
        return matchItemCnt;
    }
    public void setMatchItemCnt(int matchItemCnt) {
        this.matchItemCnt = matchItemCnt;
    }
    public int getMatchItemImage() {
        return matchItemImage;
    }
    public void setMatchItemImage(int matchItemImage) {
        this.matchItemImage = matchItemImage;
    }
}

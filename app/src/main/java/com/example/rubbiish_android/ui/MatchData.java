package com.example.rubbiish_android.ui;

public class MatchData {
    private String matchItemName;
    private int matchItemCnt;
    public MatchData(String matchItemName, int matchItemCnt){
        this.matchItemName = matchItemName;
        this.matchItemCnt = matchItemCnt;
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
}

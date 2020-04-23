package cn.eu.resultmgr.model;

import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.contants.TwoPointSystemResult;

public class Score {

    private ScoreType scoreType;
    private Float value;

    public Score(Float value){
        this.scoreType = ScoreType.HUNDRED_MARK_SYSTEM;
        this.value = value;
    }

    public Score(TwoPointSystemResult value){
        this.scoreType = ScoreType.TWO_POINTS_SYSTEM;
        this.value = value.getValue();
    }
    public ScoreType getScoreType() {
        return scoreType;
    }

    public Float getValue() {
        return value;
    }
}

package cn.eu.resultmgr.booking.domain.checkResult;

import cn.eu.framwork.bean.ValueObj;
import cn.eu.resultmgr.model.Score;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItem;

import java.io.Serializable;

public class CheckSubItemResult extends ValueObj {
    private static final long serialVersionUID = -8680939135578292913L;
    private String studentID;
    private CheckSubItem checkItem;
    private Score score;

    public CheckSubItemResult(String studentID, CheckSubItem checkItem, Score score) {
        this.studentID = studentID;
        this.checkItem = checkItem;
        this.score = score;
    }

    public String getStudentID() {
        return studentID;
    }

    public CheckSubItem getCheckItem() {
        return checkItem;
    }

    public Score getScore() {
        return score;
    }
}

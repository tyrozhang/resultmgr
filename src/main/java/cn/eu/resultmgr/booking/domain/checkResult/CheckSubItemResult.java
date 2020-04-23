package cn.eu.resultmgr.booking.domain.checkResult;

import cn.eu.resultmgr.model.Score;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItem;

public class CheckSubItemResult {
    private String studentID;
    private CheckSubItem checkItem;
    private Score score;

    public CheckSubItemResult(String studentID, CheckSubItem checkSubItem, Score score) {
        this.studentID = studentID;
        this.checkItem = checkSubItem;
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

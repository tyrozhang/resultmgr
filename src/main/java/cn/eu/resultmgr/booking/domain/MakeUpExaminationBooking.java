package cn.eu.resultmgr.booking.domain;

import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.contants.TwoPointSystemResult;
import cn.eu.resultmgr.model.CheckCourse;
import cn.eu.resultmgr.model.CheckTerm;
import cn.eu.resultmgr.model.Score;
import cn.eu.resultmgr.booking.domain.checkPlan.CheckPlanItem;
import cn.eu.resultmgr.booking.domain.checkResult.CheckSubItemResult;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItem;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItemFactory;

import java.util.HashSet;
import java.util.Set;

public class MakeUpExaminationBooking extends Booking {
    public MakeUpExaminationBooking(CheckCourse checkCourse, CheckTerm checkTerm, ScoreType scoreType) {
        super(checkCourse, checkTerm, scoreType);
    }

    @Override
    public void changeResultTypeFllow(ScoreType scoreType) {

    }

    @Override
    public Set<CheckPlanItem> getCheckPlanItems() {
        HashSet<CheckPlanItem> checkPlanItems=new HashSet<CheckPlanItem>(){
        };
        checkPlanItems.add(new CheckPlanItem(CheckSubItemFactory.MakeUpExam));
        return checkPlanItems;
    }

    @Override
    public boolean checkSubItemIsValid(CheckSubItem checkSubItem) {
        return checkSubItem.equal(CheckSubItemFactory.MakeUpExam)?true:false;
    }

    @Override
    public boolean checkItemScoreIsValid(CheckSubItemResult checkSubItemResult) {
        return checkSubItemResult.getScore().getScoreType().equals(this.scoreType)?true:false;
    }

    @Override
    public Score countFinalResultNext(String studentID) {
        //二分制
        if(this.getScoreType()==ScoreType.TWO_POINTS_SYSTEM) {
            Score score =this.getCheckSubItemResult(studentID, CheckSubItemFactory.MakeUpExam).getScore();
            if (score.getValue().equals(TwoPointSystemResult.PASS.getValue()))
                return new Score(TwoPointSystemResult.MARKUP_PASS);
            if (score.getValue().equals(TwoPointSystemResult.NOTPASS.getValue()))
                return new Score(TwoPointSystemResult.MARKUP_NOTPASS);
        }

        ////百分制
        Score score =this.getCheckSubItemResult(studentID, CheckSubItemFactory.MakeUpExam).getScore();
        if(score.getValue()>=60F)
            return new Score(60F);
        else
            return score;
    }

    @Override
    public <T> T genatatePO() {
        return null;
    }
}

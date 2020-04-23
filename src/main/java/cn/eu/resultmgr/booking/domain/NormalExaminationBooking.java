package cn.eu.resultmgr.booking.domain;

import cn.eu.resultmgr.contants.ScoreType;
import cn.eu.resultmgr.model.CheckCourse;
import cn.eu.resultmgr.model.CheckTerm;
import cn.eu.resultmgr.model.Score;
import cn.eu.resultmgr.booking.domain.checkPlan.CheckPlan;
import cn.eu.resultmgr.booking.domain.checkPlan.CheckPlanItem;
import cn.eu.resultmgr.booking.domain.checkResult.CheckSubItemResult;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItem;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItemFactory;

import java.util.Set;

public class NormalExaminationBooking extends Booking {
    @Override
    public Set<CheckPlanItem> getCheckPlanItems() {
        return this.checkPlan.getCheckPlanItem();
    }

    //考核计划
    private CheckPlan checkPlan;

    public NormalExaminationBooking(CheckCourse checkCourse, CheckTerm checkTerm, ScoreType scoreType) {
        super(checkCourse, checkTerm, scoreType);
    }

    @Override
    public boolean checkSubItemIsValid(CheckSubItem checkSubItem) {
        if (this.checkPlan==null)
            return false;
        return this.checkPlan.include(checkSubItem);
    }

    @Override
    public boolean checkItemScoreIsValid(CheckSubItemResult checkSubItemResult) {
        return this.getScoreType()==checkSubItemResult.getScore().getScoreType()?true:false;
    }

    @Override
    public void changeResultTypeFllow(ScoreType scoreType) {
        this.checkPlan.clear();
        //如果改为非百分值，只允许录入考试成绩
        if(scoreType != ScoreType.HUNDRED_MARK_SYSTEM)
            this.checkPlan.addCheckPlanItem(new CheckPlanItem(CheckSubItemFactory.EXAM));

        //所有已登记成绩
        super.checkSubItemResultStorehouse.clearCheckSubItemResult();
    }

    @Override
    public Score CountFinalResultNext(String studentID) {
        Set<CheckSubItemResult> checkSubItemResults=getCheckSubItemResult(studentID);

        //二分制直接返回考试成绩
        if(this.getScoreType()==ScoreType.TWO_POINTS_SYSTEM) {
            return this.getCheckSubItemResult(studentID, CheckSubItemFactory.EXAM).getScore();
        }

        ////百分制返回加权算总分
        Float finalScoreValue=0F;
        for (CheckSubItemResult item:checkSubItemResults) {
            Float subItemWeight=this.checkPlan.getCheckPlanItem(item.getCheckItem()).getWeight();
            finalScoreValue =finalScoreValue + item.getScore().getValue()*subItemWeight;
        }
        return new Score(finalScoreValue);
    }

    //添加考核计划项
    public void addCheckPlanItem(CheckPlanItem checkPlanItem){
        if (this.checkPlan == null)
            this.checkPlan = new CheckPlan();

        this.checkPlan.addCheckPlanItem(checkPlanItem);
    }
    /**
     * 登记免考
     */
    public void markAvoidExam(String studentID){
        this.examBehaviorRecord.markAvoidExam(studentID);
    }
}
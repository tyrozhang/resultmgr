package cn.eu.resultmgr.booking.domain.checkResult;

import cn.eu.framwork.bean.ValueObj;
import cn.eu.resultmgr.model.Score;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItem;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CheckSubItemResultStorehouse extends ValueObj {
    private static final long serialVersionUID = 2503316443957908021L;
    //分项成绩
    private Collection<CheckSubItemResult> studentCheckItemResults = new HashSet<CheckSubItemResult>();
    public CheckSubItemResultStorehouse() {
    }

    //登记成绩
    public void recordResult(CheckSubItemResult checkSubItemResult) {
        //如果有该项的成绩，则先删除
        CheckSubItemResult oldCheckSubItemResult=getCheckSubItemResult(checkSubItemResult.getStudentID(),checkSubItemResult.getCheckItem());
        if (oldCheckSubItemResult!=null)
            this.studentCheckItemResults.remove(oldCheckSubItemResult);

        this.studentCheckItemResults.add(checkSubItemResult);
    }

    //获取全部学员最终成绩
    public  Score[] getFinalResult(){
        return null;
    };

    //获取指定学员某分项成绩
    public  CheckSubItemResult getCheckSubItemResult(String studentID, CheckSubItem checkSubItem){
        for (CheckSubItemResult item:this.studentCheckItemResults) {
            if(item.getStudentID()==studentID && item.getCheckItem().equal(checkSubItem)){
                return item;
            }
        }
        return null;
    }

    //获取指定学员所有分项成绩
    public  Set<CheckSubItemResult> getCheckSubItemResult(String studentID){
        Set<CheckSubItemResult> checkSubItemResults=new HashSet<CheckSubItemResult>();
        for (CheckSubItemResult item:this.studentCheckItemResults) {
            if(item.getStudentID()==studentID){
                checkSubItemResults.add(item);
            }
        }
        return checkSubItemResults;
    }

    //删除某分项全部已登记成绩
    public void clearCheckSubItemResult(CheckSubItem checkSubItem){
        for (CheckSubItemResult item:this.studentCheckItemResults) {
            if(item.getCheckItem().equal(checkSubItem)){
                this.studentCheckItemResults.remove(item);
            }
        }
    }

    //删除全部已登记成绩
    public void clearCheckSubItemResult(){
        this.studentCheckItemResults.clear();
    }
}
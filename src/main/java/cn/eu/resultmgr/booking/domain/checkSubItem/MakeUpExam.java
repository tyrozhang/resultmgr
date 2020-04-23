package cn.eu.resultmgr.booking.domain.checkSubItem;

public class MakeUpExam extends CheckSubItem {
    private String checkSubItemName ="补考";
    @Override
    public String getItemName() {
        return checkSubItemName;
    }
}

package cn.eu.resultmgr.booking.domain.checkSubItem;

public class Exam extends CheckSubItem {
    private String checkSubItemName="exam";
    @Override
    public String getItemName() {
        return checkSubItemName;
    }
}

package cn.eu.resultmgr.booking.domain.checkSubItem;

public class Usual extends CheckSubItem {
    private String checkSubItemName ="平时成绩";
    @Override
    public String getItemName() {
        return checkSubItemName;
    }
}

package cn.eu.resultmgr.booking.domain.checkSubItem;

public class Usual extends CheckSubItem {
    private static final long serialVersionUID = 3875079637620411092L;
    private String checkSubItemName ="平时成绩";
    @Override
    public String getItemName() {
        return checkSubItemName;
    }
}

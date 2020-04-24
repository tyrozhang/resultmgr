package cn.eu.resultmgr.booking.domain.checkSubItem;

public class Exam extends CheckSubItem {
    private static final long serialVersionUID = 8693496764574024036L;
    private String checkSubItemName="exam";
    @Override
    public String getItemName() {
        return checkSubItemName;
    }
}

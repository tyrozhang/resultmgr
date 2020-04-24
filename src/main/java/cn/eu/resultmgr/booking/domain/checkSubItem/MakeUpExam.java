package cn.eu.resultmgr.booking.domain.checkSubItem;

public class MakeUpExam extends CheckSubItem {
    private static final long serialVersionUID = -3492035044601457019L;
    private String checkSubItemName ="补考";
    @Override
    public String getItemName() {
        return checkSubItemName;
    }
}

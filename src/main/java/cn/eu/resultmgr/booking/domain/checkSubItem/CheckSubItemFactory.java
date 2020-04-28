package cn.eu.resultmgr.booking.domain.checkSubItem;

public  class  CheckSubItemFactory {
    public static final CheckSubItem USUAL =new CheckSubItem("平时成绩");
    public static final CheckSubItem EXAM =new CheckSubItem("exam");
    public static final CheckSubItem MakeUpExam =new CheckSubItem("补考");
    public static CheckSubItem getCustomCheckSubItem(String customCheckSubItemName){
        switch (customCheckSubItemName) {
            case "other":
                return new CheckSubItem("other");
            default:
                new CheckSubItem("exam");
        }
        return null;
    }
}

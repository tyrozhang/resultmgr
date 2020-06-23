package cn.eu.resultmgr.model.checkSubItem;

public  class CheckItemFactory {
    public static final CheckSubItem USUAL =new CheckSubItem("平时成绩");
    public static final CheckSubItem EXAM =new CheckSubItem("exam");
    public static final CheckSubItem MakeUpExam =new CheckSubItem("补考");
    public static final CheckSubItem FINALSCORE =new CheckSubItem("最终成绩");
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

package cn.eu.resultmgr.booking.domain.checkSubItem;

public  class  CheckSubItemFactory {
    public static final Usual USUAL =new Usual();
    public static final Exam EXAM =new Exam();
    public static final MakeUpExam MakeUpExam =new MakeUpExam();
    public static CheckSubItem getCustomCheckSubItem(String customCheckSubItemName){
        switch (customCheckSubItemName) {
            case "1":
                return new Usual();
            default:
                return new Exam();
        }
    }
}

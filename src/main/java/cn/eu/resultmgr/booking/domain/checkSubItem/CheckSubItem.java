package cn.eu.resultmgr.booking.domain.checkSubItem;

public abstract class CheckSubItem {
    public abstract String getItemName();
    public  boolean equal(CheckSubItem checkSubItem){
        return  checkSubItem.getItemName().equals(this.getItemName())?true:false;
    }
}

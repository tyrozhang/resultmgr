package cn.eu.resultmgr.booking.domain.checkSubItem;

import cn.eu.framwork.bean.ValueObj;

public class CheckSubItem extends ValueObj {
    private static final long serialVersionUID = 7324096096824917356L;
    private String itemName;

    public String getItemName() {
        return itemName;
    }
    public void setItemName() {
        this.itemName=itemName;
    }


    public boolean equal(CheckSubItem checkSubItem) {
        return  checkSubItem.getItemName().equals(this.getItemName())?true:false;
    }

    public CheckSubItem(String itemName) {
        this.itemName=itemName;
    }
}

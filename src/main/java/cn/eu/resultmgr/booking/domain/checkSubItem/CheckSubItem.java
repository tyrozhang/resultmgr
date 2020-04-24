package cn.eu.resultmgr.booking.domain.checkSubItem;

import cn.eu.framwork.bean.ValueObj;

public abstract class CheckSubItem extends ValueObj {
    private static final long serialVersionUID = 6455974742657818351L;

    public abstract String getItemName();
    public  boolean equal(CheckSubItem checkSubItem){
        return  checkSubItem.getItemName().equals(this.getItemName())?true:false;
    }
}

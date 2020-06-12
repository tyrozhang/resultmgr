package cn.eu.resultmgr.booking.checkPlan.checkSubItem;

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


/*    public boolean equal(CheckSubItem checkSubItem) {
        return  checkSubItem.getItemName().equals(this.getItemName())?true:false;
    }*/

    public CheckSubItem(String itemName) {
        this.itemName=itemName;
    }

    @Override
    public boolean equals(Object obj){
        if (obj != null && obj.getClass() == this.getClass()) {
            CheckSubItem checkSubItem=(CheckSubItem) obj;
            return itemName.equalsIgnoreCase(checkSubItem.getItemName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        return 31 * result + (itemName == null ? 0 : itemName.hashCode());
    }
}

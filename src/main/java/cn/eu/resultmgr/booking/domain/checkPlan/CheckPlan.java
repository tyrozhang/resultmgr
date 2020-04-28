package cn.eu.resultmgr.booking.domain.checkPlan;

import cn.eu.framwork.bean.ValueObj;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItem;
import cn.eu.resultmgr.booking.domain.exception.CheckPlanItemWeightMoreThanOneException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckPlan extends ValueObj {

    private static final long serialVersionUID = 8428429143491967285L;
    private Set<CheckPlanItem> checkPlanItems;
    public CheckPlan() {
    }

    //检查是否包含指定考核项
    public Boolean include(CheckSubItem checkSubItem){
        return (getCheckPlanItem(checkSubItem)==null)?false:true;
    }


    //根据考核项名称得到考核计划项
    public CheckPlanItem getCheckPlanItem(CheckSubItem checkSubItem){
        if (this.checkPlanItems==null)
            return null;

        for (CheckPlanItem item : checkPlanItems) {
            if(item.getCheckSubItem().equal(checkSubItem))
                return item;
        }

        return null;
    }

    //得到考核计划项
    public Set<CheckPlanItem> getCheckPlanItem(){
        if (this.checkPlanItems==null)
            return null;
        return checkPlanItems;
    }

    //添加考核项
    public void addCheckPlanItem(CheckPlanItem checkPlanItem){
        if (this.checkPlanItems==null)
            this.checkPlanItems =new HashSet<CheckPlanItem>();

        Float sumWeight=0F;
        for (CheckPlanItem item : checkPlanItems) {
            sumWeight =sumWeight +item.getWeight();
        }
        if ((sumWeight+checkPlanItem.getWeight())>1F)
            throw  new CheckPlanItemWeightMoreThanOneException();

        this.checkPlanItems.add(checkPlanItem);
    }

    //添加考核项
    public void addCheckPlanItem(List<CheckPlanItem> checkPlanItems){
        if(checkPlanItems==null)
            return;
        for (CheckPlanItem checkPlanItem:checkPlanItems ) {
            addCheckPlanItem(checkPlanItem);
        }
    }

    //移除指定考核项
    public void removeCheckPlanItem(CheckSubItem checkSubItem){
        if (this.checkPlanItems==null)
            return;

        for (CheckPlanItem item : checkPlanItems) {
            if (item.getCheckSubItem().equal(checkSubItem))
                this.checkPlanItems.remove(item);
        }
        //留下以前不好的写法
/*        if (this.checkPlanItems!=null){
            for (CheckPlanItem item : checkPlanItems) {
                if (item.getCheckSubItem().equal(checkSubItem))
                    this.checkPlanItems.remove(item);
            }
        }*/
    }

    //移除所有考核项
    public void clear(){
        if (this.checkPlanItems==null)
            return;
        this.checkPlanItems.clear();
    }
}

package cn.eu.resultmgr.booking.domain.checkPlan;

import cn.eu.framwork.bean.ValueObj;
import cn.eu.resultmgr.booking.domain.checkSubItem.CheckSubItem;
import cn.eu.resultmgr.booking.domain.exception.CheckPlanItemWeightMoreThanOneException;

public class CheckPlanItem extends ValueObj {
    private static final long serialVersionUID = 5591187979769451342L;
    private CheckSubItem checkSubItem;
    private Float weight = 0F;

    /*
    本构造函数只允许构造百分制考核计划项
     */
    public CheckPlanItem(CheckSubItem checkSubItem, Float weight) {
        if (weight > 1F)
            throw new CheckPlanItemWeightMoreThanOneException();

        this.checkSubItem = checkSubItem;
        this.weight = weight;
    }

    /*
    本构造函数只允许构造非百分制考核计划项
     */
    public CheckPlanItem(CheckSubItem checkSubItem) {
        this.checkSubItem = checkSubItem;
    }

    public CheckSubItem getCheckSubItem() {
        return checkSubItem;
    }

    public Float getWeight() {
        return weight;
    }
}

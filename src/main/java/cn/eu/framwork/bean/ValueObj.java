package cn.eu.framwork.bean;

import cn.eu.common.bean.BeanCopyUtil;

import java.io.Serializable;

public abstract class ValueObj implements Serializable {
    private static final long serialVersionUID = -7990176638316688579L;

    public <T extends ValueObj> T copy(){
        return (T) BeanCopyUtil.clone(this);
    }
}

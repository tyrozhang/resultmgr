package cn.eu.resultmgr.model;

import cn.eu.framwork.bean.ValueObj;

public class CheckTerm extends ValueObj {
    private static final long serialVersionUID = 2841201269314877842L;

    public CheckTerm(String termName) {
        this.termName = termName;
    }

    public String getTermName() {
        return termName;
    }

    private String termName;
}

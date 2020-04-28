package cn.eu.resultmgr.contants;

public enum TwoPointSystemResult {
    PASS("及格",-1F),
    NOTPASS("不及格",-2F),
    MARKUP_PASS("补及",-3F),
    MARKUP_NOTPASS("补不及",-4F);

    private  TwoPointSystemResult(String mark,Float value) {
        this.mark=mark;
        this.value=value;
    }
    private String mark;
    private Float value;

    public String getMark() {
        return mark;
    }

    public Float getValue() {
        return value;
    }
}

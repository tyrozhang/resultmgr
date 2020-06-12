package cn.eu.framwork.domain;

public interface  IDomain<T> {
    //获取领域对象ID
    String getEntityID();

    public <T> T genatatePO();
}

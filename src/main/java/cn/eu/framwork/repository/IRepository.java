package cn.eu.framwork.repository;

import cn.eu.framwork.domain.IDomain;

public interface IRepository<T extends  IDomain> {
    public void save(T t);
}

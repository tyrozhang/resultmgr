package cn.eu.resultmgr.resultWarehouse.repository;

import cn.eu.framwork.repository.IRepository;

public interface  ResultRespository <Result> extends IRepository<Result> {
    public void save(Result result);
}

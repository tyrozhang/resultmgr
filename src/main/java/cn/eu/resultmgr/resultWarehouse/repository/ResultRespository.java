package cn.eu.resultmgr.resultWarehouse.repository;

import cn.eu.framwork.repository.IRepository;
import cn.eu.resultmgr.resultWarehouse.domain.Result;

public interface  ResultRespository extends IRepository<Result> {
    public void save(Result result);
}

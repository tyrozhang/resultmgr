package cn.eu.resultmgr.resultWarehouse.repository;

import cn.eu.framwork.repository.IRepository;
import cn.eu.resultmgr.resultWarehouse.domain.Result;

public interface ResultQueryRespository extends IRepository<Result> {
    public Result getResult(String resultID);

    public Result getResult(String studentID,String courseID,String termID);

    public Result[] getResults(String studentID);

    public Result[] getResults(String classID,String courseID,String termID);


    public Result[] getResultsFromBooking(String bookingID);
}

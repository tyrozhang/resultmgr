package cn.eu.resultmgr.resultWarehouse.repository;

import cn.eu.framwork.repository.IRepository;

public interface ResultQueryRespository<Result> extends IRepository<Result> {
    public Result getResult(String resultID);

    public Result getResult(String studentID,String courseID,String termID);

    public Result[] getResults(String studentID);

    public Result[] getResults(String classID,String courseID,String termID);


    public Result[] getResultsFromBooking(String bookingID);
}

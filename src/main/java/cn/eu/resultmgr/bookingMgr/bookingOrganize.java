package cn.eu.resultmgr.bookingMgr;

public class bookingOrganize {
    private String bookingID;
    private String[] allowBookingPersons;

    public bookingOrganize(String bookingID, String[] allowBookingPersons) {
        this.bookingID = bookingID;
        this.allowBookingPersons = allowBookingPersons;
    }

    public void addBookingPersonID(){

    }

    /**
     * 开始登记
     * @param processTaskID 处理登记的工作流任务标记
     */
    public void beginBooking(String processTaskID){

    }
}

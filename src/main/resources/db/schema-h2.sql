DROP TABLE IF EXISTS BOOKING;
CREATE TABLE BOOKING(
    bookingid varchar(32) not null,
    type varchar(2) not null,
    courseid varchar(32) null,
    courseno varchar(32) null,
    coursename varchar(32) null,
    studyrequire varchar(32) null,
    termname varchar(32) null,
    scoretype varchar(32) null,
    students varchar(4000) null,
    subItemresults varchar(10000) null,
    checkplanitems varchar(500) null,
    exambehaviorrecord varchar(500) null,
    PRIMARY KEY (bookingid)
);
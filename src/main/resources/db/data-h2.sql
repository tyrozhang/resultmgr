DELETE FROM BOOKING;

INSERT INTO BOOKING (bookingid,type,courseid,courseno,coursename,studyrequire,termname,scoretype,students,subItemresults,checkplanitems,exambehaviorrecord) VALUES
('1', '0','c_id_123', 'C_NO_123','大学英语','MUST_STUDY','2019-2020-1','HUNDRED_MARK_SYSTEM','[{"studentID":"stu1"},{"studentID":"stu2"},{"studentID":"stu3"},{"studentID":"stu4"},{"studentID":"stu5"},{"studentID":"stu6"},{"studentID":"stu7"},{"studentID":"stu8"},{"studentID":"stu9"},{"studentID":"stu11"},{"studentID":"stu12"},{"studentID":"stu13"},{"studentID":"stu14"},{"studentID":"stu15"},{"studentID":"stu16"},{"studentID":"stu17"},{"studentID":"stu18"},{"studentID":"stu19"},{"studentID":"s_id_123","studentNO":"s_no_123","studentName":"张三"}]','[{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"s_id_123"},{"checkItem":{"itemName":"平时考试"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"s_id_123"}]','[{"checkSubItem":{"itemName":"exam"},"weight":0.0}]','{"s_id_123":"CHEATED"}'),
('2','0','c_id_123', 'C_NO_123','大学物理','MUST_STUDY','2019-2020-1','HUNDRED_MARK_SYSTEM','[{"studentID":"stu1"},{"studentID":"stu2"},{"studentID":"stu3"},{"studentID":"stu4"},{"studentID":"stu5"},{"studentID":"stu6"},{"studentID":"stu7"},{"studentID":"stu8"},{"studentID":"stu9"},{"studentID":"stu11"},{"studentID":"stu12"},{"studentID":"stu13"},{"studentID":"stu14"},{"studentID":"stu15"},{"studentID":"stu16"},{"studentID":"stu17"},{"studentID":"stu18"},{"studentID":"stu19"},{"studentID":"s_id_123","studentNO":"s_no_123","studentName":"张三"}]','[{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"s_id_123"},{"checkItem":{"itemName":"平时考试"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"s_id_123"}]','[{"checkSubItem":{"itemName":"exam"},"weight":0.0}]','{"s_id_123":"CHEATED"}'),
('3','0', 'c_id_123', 'C_NO_123','大学英语','MUST_STUDY','2019-2020-1','HUNDRED_MARK_SYSTEM','[{"studentID":"stu1"},{"studentID":"stu2"},{"studentID":"stu3"},{"studentID":"stu4"},{"studentID":"stu5"},{"studentID":"stu6"},{"studentID":"stu7"},{"studentID":"stu8"},{"studentID":"stu9"},{"studentID":"stu11"},{"studentID":"stu12"},{"studentID":"stu13"},{"studentID":"stu14"},{"studentID":"stu15"},{"studentID":"stu16"},{"studentID":"stu17"},{"studentID":"stu18"},{"studentID":"stu19"},{"studentID":"s_id_123","studentNO":"s_no_123","studentName":"张三"}]','[{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"s_id_123"},{"checkItem":{"itemName":"平时考试"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"s_id_123"}]','[{"checkSubItem":{"itemName":"exam"},"weight":0.0}]','{"s_id_123":"CHEATED"}'),
('4','0', 'c_id_123', 'C_NO_123','大学英语','MUST_STUDY','2019-2020-1','HUNDRED_MARK_SYSTEM','[{"studentID":"stu1"},{"studentID":"stu2"},{"studentID":"stu3"},{"studentID":"stu4"},{"studentID":"stu5"},{"studentID":"stu6"},{"studentID":"stu7"},{"studentID":"stu8"},{"studentID":"stu9"},{"studentID":"stu11"},{"studentID":"stu12"},{"studentID":"stu13"},{"studentID":"stu14"},{"studentID":"stu15"},{"studentID":"stu16"},{"studentID":"stu17"},{"studentID":"stu18"},{"studentID":"stu19"},{"studentID":"s_id_123","studentNO":"s_no_123","studentName":"张三"}]','','[{"checkSubItem":{"itemName":"exam"},"weight":0.0}]','{"s_id_123":"CHEATED"}'),
('6','0', 'c_id_123', 'C_NO_123','大学英语','MUST_STUDY','2019-2020-1','HUNDRED_MARK_SYSTEM','[{"studentID":"stu1"},{"studentID":"stu2"},{"studentID":"stu3"},{"studentID":"stu4"},{"studentID":"stu5"},{"studentID":"stu6"},{"studentID":"stu7"},{"studentID":"stu8"},{"studentID":"stu9"},{"studentID":"stu10"},{"studentID":"stu11"},{"studentID":"stu12"},{"studentID":"stu13"},{"studentID":"stu14"},{"studentID":"stu15"},{"studentID":"stu16"},{"studentID":"stu17"},{"studentID":"stu18"},{"studentID":"stu19"},{"studentID":"stu20"},{"studentID":"stu21"},{"studentID":"stu22"},{"studentID":"stu23"},{"studentID":"stu24"},{"studentID":"stu25"},{"studentID":"stu26"},{"studentID":"stu27"},{"studentID":"stu28"},{"studentID":"stu29"},{"studentID":"stu30"},{"studentID":"stu31"},{"studentID":"stu32"},{"studentID":"stu33"},{"studentID":"stu34"},{"studentID":"stu35"},{"studentID":"stu36"},{"studentID":"stu37"},{"studentID":"stu38"},{"studentID":"stu39"},{"studentID":"stu11"},{"studentID":"stu12"},{"studentID":"stu13"},{"studentID":"stu14"},{"studentID":"stu15"},{"studentID":"stu16"},{"studentID":"stu17"},{"studentID":"stu18"},{"studentID":"stu19"},{"studentID":"s_id_123","studentNO":"s_no_123","studentName":"张三"}]','[{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu16"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu19"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu20"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu25"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu19"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu22"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu17"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu11"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu4"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu37"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu11"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu9"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu2"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu15"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu13"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu8"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu14"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu35"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu5"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu1"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu26"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu37"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"s_id_123"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu24"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu3"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu10"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu10"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu39"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu30"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu33"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu4"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu23"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu8"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu13"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu21"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu17"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu7"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu34"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu1"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu34"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu32"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu5"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu28"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu3"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu26"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu21"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu25"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu38"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu12"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu18"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu20"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu2"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu27"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"s_id_123"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu36"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu30"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu29"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu29"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu18"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu31"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu24"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu32"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu6"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu38"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu39"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu35"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu28"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu36"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu12"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu7"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu27"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu16"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu22"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu6"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu33"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu23"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu31"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu15"},{"checkItem":{"itemName":"平时成绩"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":90.0},"studentID":"stu14"},{"checkItem":{"itemName":"exam"},"score":{"scoreType":"HUNDRED_MARK_SYSTEM","value":80.0},"studentID":"stu9"}]','[{"checkSubItem":{"itemName":"平时成绩"},"weight":0.3},{"checkSubItem":{"itemName":"exam"},"weight":0.7}]','')

;
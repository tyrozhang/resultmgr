package cn.eu.resultmgr.contants;

import java.util.stream.Stream;

public enum ExamBehavior {
    NORMAL,     //正常
    CHEATED,    //作弊
    ABSENT,     //缺考
    DELAYEXAM, //缓考
    AVOIDEXAM;   //免考

    //根据字符返回对应的枚举，该方法主要为解决 从json中反序列化构造枚举使用
    public static ExamBehavior fromString(String examBehaviorString) {
        return Stream.of(ExamBehavior.values())
                .filter(examBehavior -> examBehaviorString.equalsIgnoreCase(examBehavior.name()))
                .findFirst()
                .orElse(null);
    }
}

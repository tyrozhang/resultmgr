package cn.eu.resultmgr.contants;

import java.io.Serializable;
import java.util.stream.Stream;

public enum ScoreType implements Serializable {
    HUNDRED_MARK_SYSTEM,
    TWO_POINTS_SYSTEM,
    FIVE_POINTS_SYSTEM;

    //根据字符返回对应的枚举，该方法主要为解决 从json中反序列化构造枚举使用
    public static ScoreType fromString(String scoreTypeString) {
        return Stream.of(ScoreType.values())
                .filter(examBehavior -> scoreTypeString.equalsIgnoreCase(examBehavior.name()))
                .findFirst()
                .orElse(null);
    }

}


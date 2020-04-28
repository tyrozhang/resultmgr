package cn.eu.resultmgr.contants;

import java.io.Serializable;
import java.util.stream.Stream;

public enum StudyRequire implements Serializable {
    MUST_STUDY,
    ELECTIVE_STUDY;

    //根据字符返回对应的枚举，该方法主要为解决 从json中反序列化构造枚举使用
    public static StudyRequire fromString(String studyRequireString) {
        return Stream.of(StudyRequire.values())
                .filter(examBehavior -> studyRequireString.equalsIgnoreCase(examBehavior.name()))
                .findFirst()
                .orElse(null);
    }

}

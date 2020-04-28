package cn.eu.resultmgr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.eu.resultmgr.booking.persistence")
public class ResultmgrApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultmgrApplication.class, args);
    }

}

package com.easy.office;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author taylor
 * @date 2019.4.14
 */
@MapperScan("com.easy.office.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class OfficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfficeApplication.class, args);
    }

}

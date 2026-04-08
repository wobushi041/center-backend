package org.wobushi041.centerbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages = {"org.wobushi041.centerbackend","service"})
@MapperScan("org.wobushi041.centerbackend.mapper")
public class CenterBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CenterBackendApplication.class, args);
    }

}

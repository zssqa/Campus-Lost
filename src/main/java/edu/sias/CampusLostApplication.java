package edu.sias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 校园失物招领平台启动类
 * Spring Boot应用程序入口点
 */
@SpringBootApplication
@ComponentScan(basePackages = "edu.sias")
public class CampusLostApplication {

    /**
     * 应用程序主方法
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(CampusLostApplication.class, args);
    }

}
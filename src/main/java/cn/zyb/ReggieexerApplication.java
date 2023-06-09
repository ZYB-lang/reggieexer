package cn.zyb;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Slf4j
@MapperScan("cn.zyb.mapper")
@ServletComponentScan
@EnableTransactionManagement
public class ReggieexerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReggieexerApplication.class, args);
        log.info("项目启动成功");
    }

}

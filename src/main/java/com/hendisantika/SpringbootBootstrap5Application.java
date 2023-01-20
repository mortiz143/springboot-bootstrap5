package com.hendisantika;

import com.hendisantika.repository.CbaStatusReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SpringbootBootstrap5Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBootstrap5Application.class, args);
    }

    //@Bean
    public CommandLineRunner runner(CbaStatusReportRepository repository) {
        return (args) -> {
          repository.findAll().forEach(cbaStatusReportEntity -> log.info(cbaStatusReportEntity.toString()));
        };
    }

}

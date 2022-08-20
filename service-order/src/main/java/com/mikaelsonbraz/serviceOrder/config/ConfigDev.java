package com.mikaelsonbraz.serviceOrder.config;

import com.mikaelsonbraz.serviceOrder.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ConfigDev {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Bean
    public void DBseeding(){
        if(ddl.equals("create")){
            dbService.DBseeding();
        }
    }
}

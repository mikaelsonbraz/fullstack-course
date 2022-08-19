package com.mikaelsonbraz.serviceOrder.config;

import com.mikaelsonbraz.serviceOrder.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class ConfigTest {

    @Autowired
    private DBService dbService;

    @Bean
    public void DBseeding(){
        dbService.DBseeding();
    }
}

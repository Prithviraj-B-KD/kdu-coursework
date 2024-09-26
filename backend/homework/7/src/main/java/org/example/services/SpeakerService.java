package org.example.services;


import org.example.entity.Speaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:/Users/prithvirajb/Downloads/spring-handson-1/src/main/resources/application.properties")

public class SpeakerService {

    @Value("${app.sonyName}")
    String sonyName;

    @Value("${app.boseName}")
    String boseName;

    @Value("${app.bosePrice}")
    double bosePrice;

    @Value("${app.sonyPrice}")
    double sonyPrice;

    @Bean("sony")
    public Speaker sony() {
        return new Speaker( sonyPrice,sonyName);
    }
    @Bean("bose")
    public Speaker bose(){
        return new Speaker(bosePrice,boseName);
    }
}

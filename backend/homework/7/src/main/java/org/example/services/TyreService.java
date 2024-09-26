package org.example.services;


import org.example.entity.Tyre;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:/Users/prithvirajb/Downloads/spring-handson-1/src/main/resources/application.properties")
public class TyreService {

    @Value("${app.mrfName}")
    String mrfName;

    @Value("${app.bridgeStoneName}")
    String bridgeStoneName;

    @Value("${app.mrfPrice}")
    double mrfPrice;

    @Value("${app.bridgeStonePrice}")
    double bridgeStonePrice;


    @Bean("mrf")
    public Tyre mrf(){
        return new Tyre(mrfPrice,mrfName);

    }
    @Bean("bridgestone")
    public Tyre bridgeStone(){
        return new Tyre(bridgeStonePrice,bridgeStoneName);
    }
}

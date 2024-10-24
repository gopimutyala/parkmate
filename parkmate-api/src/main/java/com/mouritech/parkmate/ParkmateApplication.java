package com.mouritech.parkmate;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParkmateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkmateApplication.class, args);
    }

    @Bean("parkmateModelMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}

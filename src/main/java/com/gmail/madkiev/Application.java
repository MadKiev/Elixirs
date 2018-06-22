package com.gmail.madkiev;

import com.gmail.madkiev.repository.InMemoryIngredientRepository;
import com.gmail.madkiev.repository.IngredientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.gmail.madkiev")
@SpringBootApplication
public class Application {
    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public IngredientRepository ingredientRepository(){
        return new InMemoryIngredientRepository();
    }

}

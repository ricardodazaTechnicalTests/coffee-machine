package com.intelygenz.coffe.machine;

import com.intelygenz.coffe.machine.services.CoffeeMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class CoffeeMachineApp implements CommandLineRunner {

    @Autowired
    private CoffeeMachineService coffeeMachineService;

    public static void main(String[] args) {
        SpringApplication.run(CoffeeMachineApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        coffeeMachineService.runCoffeMachine(args);
    }
}
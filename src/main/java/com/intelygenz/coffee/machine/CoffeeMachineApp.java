package com.intelygenz.coffee.machine;

import com.intelygenz.coffee.machine.services.CoffeeMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
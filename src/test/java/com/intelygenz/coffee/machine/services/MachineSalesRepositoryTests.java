package com.intelygenz.coffee.machine.services;

import com.intelygenz.coffee.machine.services.dao.MachineSalesRepository;
import com.intelygenz.coffee.machine.services.model.MachineSales;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MachineSalesRepositoryTests {

    @Autowired
    private MachineSalesRepository repository;

    @Test
    public void setUp() {
//        repository.deleteAll();
//        MachineSales sales = new MachineSales();
//        sales.setCoffe(0.4f);
//        sales.setTea(0.5f);
//        sales.setChocolate(0.6f);
//        repository.save(sales);
    }
}

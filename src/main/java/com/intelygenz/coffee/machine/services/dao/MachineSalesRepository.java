package com.intelygenz.coffee.machine.services.dao;

import com.intelygenz.coffee.machine.services.model.MachineSales;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MachineSalesRepository extends MongoRepository<MachineSales, String> {
}

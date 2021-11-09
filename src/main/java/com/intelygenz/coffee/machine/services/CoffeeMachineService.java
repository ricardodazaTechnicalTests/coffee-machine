package com.intelygenz.coffee.machine.services;

import com.intelygenz.coffee.machine.dto.InputArguments;
import com.intelygenz.coffee.machine.services.model.MachineSales;
import picocli.CommandLine.ParameterException;

public interface CoffeeMachineService {

    String runCoffeMachine(String[] args);

    InputArguments parseArguments(String[] args) throws ParameterException;

    MachineSales saveSale(InputArguments input);
}
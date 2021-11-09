package com.intelygenz.coffe.machine.services;

import com.intelygenz.coffe.machine.dto.InputArguments;
import picocli.CommandLine;
import picocli.CommandLine.ParameterException;

public interface CoffeeMachineService {

    String runCoffeMachine(String[] args);

    InputArguments parseArguments(String[] args) throws ParameterException;
}
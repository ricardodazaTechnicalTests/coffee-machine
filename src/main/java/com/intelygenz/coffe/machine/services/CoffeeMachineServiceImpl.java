package com.intelygenz.coffe.machine.services;

import com.intelygenz.coffe.machine.dto.InputArguments;
import com.intelygenz.coffe.machine.dto.OutputArguments;
import com.intelygenz.coffe.machine.exception.ValidateDrinkException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import picocli.CommandLine;
import picocli.CommandLine.ParameterException;

@Service
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    @Autowired
    private MakeDrinkCommand makeDrinkCommand;
    @Autowired
    private Output output;

    @Override
    public String runCoffeMachine(String[] args) {
        OutputArguments outputArguments = new OutputArguments();
        try {
            InputArguments input = parseArguments(args);
            outputArguments.setMessage(makeDrinkCommand.makeDrink(input));
        } catch (ParameterException | ValidateDrinkException e) {
            outputArguments.setMessage(e.getMessage());
            outputArguments.setError(true);
        } finally {
            output.printResultMessage(outputArguments);
            return outputArguments.getMessage();
        }
    }

    @Override
    public InputArguments parseArguments(String[] args) throws ParameterException{
        return CommandLine.populateCommand(new InputArguments(), args);
    }
}
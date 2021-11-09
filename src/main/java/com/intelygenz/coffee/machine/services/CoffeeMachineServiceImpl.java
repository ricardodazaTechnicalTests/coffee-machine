package com.intelygenz.coffee.machine.services;

import com.intelygenz.coffee.machine.dto.InputArguments;
import com.intelygenz.coffee.machine.dto.OutputArguments;
import com.intelygenz.coffee.machine.exception.ValidateDrinkException;
import com.intelygenz.coffee.machine.services.dao.MachineSalesRepository;
import com.intelygenz.coffee.machine.services.model.MachineSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import picocli.CommandLine;
import picocli.CommandLine.ParameterException;

import java.util.List;

import static com.intelygenz.coffee.machine.utils.Constants.*;

@Service
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    @Autowired
    private MakeDrinkCommand makeDrinkCommand;
    @Autowired
    private MachineSalesRepository machineSalesRepository;
    @Autowired
    private Output output;

    @Override
    public String runCoffeMachine(String[] args) {
        OutputArguments outputArguments = new OutputArguments();
        MachineSales sales = null;
        try {
            InputArguments input = parseArguments(args);
            outputArguments.setMessage(makeDrinkCommand.makeDrink(input));
            sales = saveSale(input);
        } catch (ParameterException | ValidateDrinkException e) {
            outputArguments.setMessage(e.getMessage());
            outputArguments.setError(true);
        } finally {
            output.printResultMessage(outputArguments);
            if(!ObjectUtils.isEmpty(sales)) {
                output.printEarnings(sales);
            }
            return outputArguments.getMessage();
        }
    }

    @Override
    public InputArguments parseArguments(String[] args) throws ParameterException{
        return CommandLine.populateCommand(new InputArguments(), args);
    }

    @Override
    public MachineSales saveSale(InputArguments input) {
        List<MachineSales> sales = machineSalesRepository.findAll();
        MachineSales sale;
        if(CollectionUtils.isEmpty(sales)) {
            sale = new MachineSales();
        } else {
            sale = sales.get(0);
        }
        switch (input.getDrinkType().toUpperCase()) {
            case TEA:
                Float teaEarnings = (sale.getTea() == null ? 0.0f : sale.getTea()) + input.getMoney();
                sale.setTea(teaEarnings);
                break;
            case COFFEE:
                Float coffeeEarnings = (sale.getCoffe() == null ? 0.0f : sale.getCoffe()) + input.getMoney();
                sale.setCoffe(coffeeEarnings);
                break;
            case CHOCOLATE:
                Float chocolateEarnings = (sale.getChocolate() == null ? 0.0f : sale.getChocolate()) + input.getMoney();
                sale.setChocolate(chocolateEarnings);
                break;
        }
        machineSalesRepository.save(sale);
        return sale;
    }
}
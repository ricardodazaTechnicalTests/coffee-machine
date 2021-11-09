package com.intelygenz.coffe.machine.services;

import com.intelygenz.coffe.machine.dto.InputArguments;
import com.intelygenz.coffe.machine.exception.ValidateDrinkException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakeDrinkCommandImpl implements MakeDrinkCommand {

    @Autowired
    private ValidationService validationService;

    @Override
    public String makeDrink(InputArguments input) throws ValidateDrinkException {
        validationService.validateDrinkType(input.getDrinkType());
        validationService.validatePrice(input.getDrinkType(), input.getMoney());
        return validationService.validateSugar(input);
    }
}
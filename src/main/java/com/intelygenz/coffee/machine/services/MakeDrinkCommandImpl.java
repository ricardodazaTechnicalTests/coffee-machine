package com.intelygenz.coffee.machine.services;

import com.intelygenz.coffee.machine.dto.InputArguments;
import com.intelygenz.coffee.machine.exception.ValidateDrinkException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakeDrinkCommandImpl implements MakeDrinkCommand {

    @Autowired
    private ValidationService validationService;

    @Override
    public String makeDrink(InputArguments input) throws ValidateDrinkException {
        validationService.validateDrinkType(input.getDrinkType());
        validationService.validatePrice(input);
        return validationService.validateSugar(input);
    }
}
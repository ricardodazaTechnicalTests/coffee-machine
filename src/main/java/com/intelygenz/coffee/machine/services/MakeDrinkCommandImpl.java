package com.intelygenz.coffee.machine.services;

import com.intelygenz.coffee.machine.dto.InputArguments;
import com.intelygenz.coffee.machine.exception.ValidateDrinkException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.intelygenz.coffee.machine.utils.Constants.*;

@Service
public class MakeDrinkCommandImpl implements MakeDrinkCommand {

    @Autowired
    private ValidationService validationService;

    @Override
    public String makeDrink(InputArguments input) throws ValidateDrinkException {
        validationService.validateDrinkType(input.getDrinkType());
        validationService.validatePrice(input);
        validationService.validateSugar(input);
        return buildResultMessage(input);
    }

    @Override
    public String buildResultMessage(InputArguments input) {
        Integer sugarsNo = input.getSugar();
        return String.format(ORDERED,
                input.getDrinkType(),
                input.isExtraHot() ? EXTRA_HOT : EMPTY,
                sugarsNo,
                sugarsNo > 0 ? SUGARS_STICK_INCLUDED : SUGAR);
    }
}
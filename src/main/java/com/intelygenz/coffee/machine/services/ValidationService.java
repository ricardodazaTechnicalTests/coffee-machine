package com.intelygenz.coffee.machine.services;

import com.intelygenz.coffee.machine.dto.InputArguments;
import com.intelygenz.coffee.machine.exception.ValidateDrinkException;

public interface ValidationService {

    boolean validateDrinkType(final String drinkType) throws ValidateDrinkException;
    void validatePrice(final InputArguments input) throws ValidateDrinkException;
    void validateSugar(final InputArguments input) throws ValidateDrinkException;
}

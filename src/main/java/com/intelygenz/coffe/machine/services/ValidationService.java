package com.intelygenz.coffe.machine.services;

import com.intelygenz.coffe.machine.dto.InputArguments;
import com.intelygenz.coffe.machine.exception.ValidateDrinkException;

public interface ValidationService {

    boolean validateDrinkType(final String drinkType) throws ValidateDrinkException;
    void validatePrice(final String drinkType, final Float money) throws ValidateDrinkException;
    String validateSugar(final InputArguments input) throws ValidateDrinkException;
}

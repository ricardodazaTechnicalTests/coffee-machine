package com.intelygenz.coffee.machine.services;

import com.intelygenz.coffee.machine.dto.InputArguments;
import com.intelygenz.coffee.machine.exception.ValidateDrinkException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.intelygenz.coffee.machine.utils.Constants.*;

@Service
public class ValidationServiceImpl implements ValidationService {

    private static Logger logger = LoggerFactory.getLogger(ValidationServiceImpl.class);

    public enum Drinks {
        COFFEE,
        CHOCOLATE,
        TEA
    }

    @Override
    public boolean validateDrinkType(String drinkType) throws ValidateDrinkException {
        for (Drinks drinks : Drinks.values()) {
            if (drinks.name().equals(drinkType.toUpperCase())) {
                return true;
            }
        }
        throw new ValidateDrinkException(DRINK_TYPE_ERROR_MESSAGE_VALIDATION);
    }

    @Override
    public void validatePrice(final InputArguments input) throws ValidateDrinkException {
        boolean isValid = true;
        Float price = 0.0f;
        Float money = input.getMoney();
        switch (input.getDrinkType().toUpperCase()) {
            case TEA:
                price = 0.4f;
                isValid = money >= price;
                break;
            case COFFEE:
                price = 0.5f;
                isValid = money >= price;
                break;
            case CHOCOLATE:
                price = 0.6f;
                isValid = money >= price;
                break;
        }
        if (!isValid)
            throw new ValidateDrinkException(String.format(DRINK_PRICE_VALIDATE_EXCEPTION, input.getDrinkType().toLowerCase(), price));
        input.setMoney(price);
    }


    @Override
    public void validateSugar(InputArguments input) throws ValidateDrinkException {
        Integer sugarsNo = input.getSugar();
        if (!(sugarsNo >= 0 && sugarsNo <= 2)) {
            throw new ValidateDrinkException(NUMBER_OF_SUGARS_VALIDATE_EXCEPTION);
        }
    }
}
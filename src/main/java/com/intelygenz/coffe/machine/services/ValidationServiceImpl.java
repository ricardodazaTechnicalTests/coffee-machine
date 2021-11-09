package com.intelygenz.coffe.machine.services;

import com.intelygenz.coffe.machine.dto.InputArguments;
import com.intelygenz.coffe.machine.exception.ValidateDrinkException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.intelygenz.coffe.machine.utils.Constants.*;

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
    public void validatePrice(final String drinkType, final Float money) throws ValidateDrinkException {
        boolean isValid = true;
        double price = 0.0;
        switch (drinkType.toUpperCase()) {
            case TEA:
                price = 0.4;
                isValid = money >= price;
                break;
            case COFFEE:
                price = 0.5;
                isValid = money >= price;
                break;
            case CHOCOLATE:
                price = 0.6;
                isValid = money >= price;
                break;
        }
        if(!isValid) throw new ValidateDrinkException(String.format(DRINK_PRICE_VALIDATE_EXCEPTION, drinkType.toLowerCase(), price));
    }


    @Override
    public String validateSugar(InputArguments input) throws ValidateDrinkException {
        String message = "";
        Integer sugarsNo = input.getSugar();
        if (validNumberOfSugar(sugarsNo)) {
            message = String.format(ORDERED,
                    input.getDrinkType(),
                    input.isExtraHot() ? EXTRA_HOT : EMPTY,
                    sugarsNo,
                    sugarsNo > 0 ? SUGARS_STICK_INCLUDED : SUGAR);
        } else {
            throw new ValidateDrinkException(NUMBER_OF_SUGARS_VALIDATE_EXCEPTION);
        }
        return message;
    }

    private boolean validNumberOfSugar(final Integer sugarsNo) {
        return sugarsNo >= 0 && sugarsNo <= 2;
    }
}
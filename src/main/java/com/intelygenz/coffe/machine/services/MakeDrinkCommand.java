package com.intelygenz.coffe.machine.services;

import com.intelygenz.coffe.machine.dto.InputArguments;
import com.intelygenz.coffe.machine.exception.ValidateDrinkException;

public interface MakeDrinkCommand {

  String makeDrink(InputArguments input) throws ValidateDrinkException;
}
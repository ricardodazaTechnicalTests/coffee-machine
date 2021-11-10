package com.intelygenz.coffee.machine.services;

import com.intelygenz.coffee.machine.dto.InputArguments;
import com.intelygenz.coffee.machine.exception.ValidateDrinkException;

public interface MakeDrinkCommand {

  String makeDrink(InputArguments input) throws ValidateDrinkException;

  String buildResultMessage(InputArguments input);
}
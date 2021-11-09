package com.intelygenz.coffee.machine.services;

import com.intelygenz.coffee.machine.dto.OutputArguments;
import com.intelygenz.coffee.machine.services.model.MachineSales;

public interface Output {

    void printResultMessage(OutputArguments ouput);

    void printEarnings(MachineSales sales);
}
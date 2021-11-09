package com.intelygenz.coffee.machine.services;

import com.intelygenz.coffee.machine.dto.OutputArguments;
import com.intelygenz.coffee.machine.services.model.MachineSales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class OutputImpl implements Output {

    private static Logger logger = LoggerFactory.getLogger(OutputImpl.class);
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public void printResultMessage(OutputArguments output) {
        if(output.isError()) {
            logger.error(output.getMessage());
        } else {
            logger.info(output.getMessage());
        }
    }

    @Override
    public void printEarnings(MachineSales sales) {
        double tea = (sales.getTea() == null ? 0.0 : sales.getTea());
        double coffee = sales.getCoffe() == null ? 0.0 : sales.getCoffe();
        double chocolate = sales.getChocolate() == null ? 0.0 : sales.getChocolate();
        logger.info("\n" +
                    "|  Drink  |Money|\n" +
                    "|---------|-----|\n" +
                    "|Tea      | " +  df.format(tea) + "|\n" +
                    "|Coffee   | " + df.format(coffee) + "|\n" +
                    "|Chocolate| " + df.format(chocolate) + "|\n");
    }
}
package com.intelygenz.coffe.machine.services;

import com.intelygenz.coffe.machine.dto.OutputArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OutputImpl implements Output {

    private static Logger logger = LoggerFactory.getLogger(OutputImpl.class);

    @Override
    public void printResultMessage(OutputArguments output) {
        if(output.isError()) {
            logger.error(output.getMessage());
        } else {
            logger.info(output.getMessage());
        }
    }
}
package com.intelygenz.coffee.machine.services;

import com.intelygenz.coffee.machine.dto.InputArguments;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MakeDrinkCommandTest {

    @Spy
    private MakeDrinkCommandImpl makeDrinkCommand;

    @Test
    public void buildResultMessage_coffee_1_1_false() {
        //given
        InputArguments input = new InputArguments("coffee", 1f, 1);
        input.setExtraHot(false);
        //when
        String resultMessage = makeDrinkCommand.buildResultMessage(input);
        //then
        assertEquals("You have ordered a coffee with 1 sugars (stick included)", resultMessage);
    }

    @Test
    public void buildResultMessage_coffee_1_1_true() {
        //given
        InputArguments input = new InputArguments("coffee", 1f, 1);
        input.setExtraHot(true);
        //when
        String resultMessage = makeDrinkCommand.buildResultMessage(input);
        //then
        assertEquals("You have ordered a coffee extra hot with 1 sugars (stick included)", resultMessage);
    }

    @Test
    public void buildResultMessage_coffee_1_0_false() {
        //given
        InputArguments input = new InputArguments("coffee", 1f, 0);
        input.setExtraHot(false);
        //when
        String resultMessage = makeDrinkCommand.buildResultMessage(input);
        //then
        assertEquals("You have ordered a coffee with 0 sugar", resultMessage);
    }

    @Test
    public void buildResultMessage_tea_1_1_false() {
        //given
        InputArguments input = new InputArguments("tea", 1f, 1);
        input.setExtraHot(false);
        //when
        String resultMessage = makeDrinkCommand.buildResultMessage(input);
        //then
        assertEquals("You have ordered a tea with 1 sugars (stick included)", resultMessage);
    }

    @Test
    public void buildResultMessage_tea_1_1_true() {
        //given
        InputArguments input = new InputArguments("tea", 1f, 1);
        input.setExtraHot(true);
        //when
        String resultMessage = makeDrinkCommand.buildResultMessage(input);
        //then
        assertEquals("You have ordered a tea extra hot with 1 sugars (stick included)", resultMessage);
    }

    @Test
    public void buildResultMessage_tea_1_0_false() {
        //given
        InputArguments input = new InputArguments("tea", 1f, 0);
        input.setExtraHot(false);
        //when
        String resultMessage = makeDrinkCommand.buildResultMessage(input);
        //then
        assertEquals("You have ordered a tea with 0 sugar", resultMessage);
    }

    @Test
    public void buildResultMessage_chocolate_1_1_false() {
        //given
        InputArguments input = new InputArguments("chocolate", 1f, 1);
        input.setExtraHot(false);
        //when
        String resultMessage = makeDrinkCommand.buildResultMessage(input);
        //then
        assertEquals("You have ordered a chocolate with 1 sugars (stick included)", resultMessage);
    }

    @Test
    public void buildResultMessage_chocolate_1_1_true() {
        //given
        InputArguments input = new InputArguments("chocolate", 1f, 1);
        input.setExtraHot(true);
        //when
        String resultMessage = makeDrinkCommand.buildResultMessage(input);
        //then
        assertEquals("You have ordered a chocolate extra hot with 1 sugars (stick included)", resultMessage);
    }

    @Test
    public void buildResultMessage_chocolate_1_0_false() {
        //given
        InputArguments input = new InputArguments("chocolate", 1f, 0);
        input.setExtraHot(false);
        //when
        String resultMessage = makeDrinkCommand.buildResultMessage(input);
        //then
        assertEquals("You have ordered a chocolate with 0 sugar", resultMessage);
    }
}
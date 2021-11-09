package com.intelygenz.coffe.machine.services;

import com.intelygenz.coffe.machine.dto.InputArguments;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeMachineServiceTest {

    @Spy
    private OutputImpl output;

    @Spy
    @InjectMocks
    private CoffeeMachineServiceImpl coffeeMachineService;

    @Test
    public void runCoffeMachine_validArgumentsWithE() {
        //given
        String[] args = {"tea", "1", "1", "-e"};
        //when
        String resultMessage = coffeeMachineService.runCoffeMachine(args);
        //then
        assertEquals(null, resultMessage);
    }

    @Test
    public void runCoffeMachine_validArgumentsWithExtraHot() {
        //given
        String[] args = {"tea", "1", "1", "--extra-hot"};
        //when
        String resultMessage = coffeeMachineService.runCoffeMachine(args);
        //then
        assertEquals(null, resultMessage);
    }

    @Test
    public void runCoffeMachine_invalidMoney() {
        //given
        String[] args = {"tea", "foo", "1", "-e"};
        //when
        String resultMessage = coffeeMachineService.runCoffeMachine(args);
        //then
        assertEquals("Invalid value for positional parameter at index 1 (<money>): 'foo' is not a float", resultMessage);
    }

    @Test
    public void runCoffeMachine_invalidSugar() {
        //given
        String[] args = {"tea", "1", "foo", "-e"};
        //when
        String resultMessage = coffeeMachineService.runCoffeMachine(args);
        //then
        assertEquals("Invalid value for positional parameter at index 2 (<sugar>): 'foo' is not an int", resultMessage);
    }

    @Test
    public void runCoffeMachine_invalidExtraHot() {
        //given
        String[] args = {"tea", "1", "1", "-exxx"};
        //when
        String resultMessage = coffeeMachineService.runCoffeMachine(args);
        //then
        assertEquals("Unknown option: '-xxx' (while processing option: '-exxx')", resultMessage);
    }

    @Test
    public void runCoffeMachine_invalidNumberOfArguments() {
        //given
        String[] args = {"tea", "-e"};
        //when
        String resultMessage = coffeeMachineService.runCoffeMachine(args);
        //then
        assertEquals("Missing required parameters: '<money>', '<sugar>'", resultMessage);
    }

    @Test
    public void runCoffeMachine_withoutArguments() {
        //given
        String[] args = {"-e"};
        //when
        String resultMessage = coffeeMachineService.runCoffeMachine(args);
        //then
        assertEquals("Missing required parameters: '<drinkType>', '<money>', '<sugar>'", resultMessage);
    }

    @Test
    public void runCoffeMachine_withoutArgumentsEitherOption() {
        //given
        String[] args = {};
        //when
        String resultMessage = coffeeMachineService.runCoffeMachine(args);
        //then
        assertEquals("Missing required parameters: '<drinkType>', '<money>', '<sugar>'", resultMessage);
    }

    @Test
    public void parseArguments_withoutExtraHot() {
        //given
        String[] args = {"tea", "1", "1"};
        //when
        InputArguments input = coffeeMachineService.parseArguments(args);
        //then
        assertEquals(input.isExtraHot(), false);
    }

    @Test
    public void parseArguments_withExtraHot() {
        //given
        String[] args = {"tea", "1", "1", "-e"};
        //when
        InputArguments input = coffeeMachineService.parseArguments(args);
        //then
        assertEquals(input.isExtraHot(), true);
    }
}

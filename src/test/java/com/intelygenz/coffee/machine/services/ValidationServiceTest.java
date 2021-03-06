package com.intelygenz.coffee.machine.services;

import com.intelygenz.coffee.machine.dto.InputArguments;
import com.intelygenz.coffee.machine.exception.ValidateDrinkException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ValidationServiceTest {

    @Spy
    private ValidationServiceImpl validationService;

    @Test
    public void makeDrink_coffee_1_1_false() throws ValidateDrinkException {
        //given
        InputArguments input = new InputArguments("coffee", 1f, 1);
        input.setExtraHot(false);
        //when
        boolean isValid = validationService.validateDrinkType(input.getDrinkType());
        validationService.validatePrice(input);
        validationService.validateSugar(input);
        //then
        assertEquals(true, isValid);
    }

    @Test
    public void makeDrink_coffee_1_1_true() throws ValidateDrinkException {
        //given
        InputArguments input = new InputArguments("coffee", 1f, 1);
        input.setExtraHot(true);
        //when
        boolean isValid = validationService.validateDrinkType(input.getDrinkType());
        validationService.validatePrice(input);
        validationService.validateSugar(input);
        //then
        assertEquals(true, isValid);
    }

    @Test
    public void makeDrink_coffee_1_0_false() throws ValidateDrinkException {
        //given
        InputArguments input = new InputArguments("coffee", 1f, 0);
        input.setExtraHot(false);
        //when
        boolean isValid = validationService.validateDrinkType(input.getDrinkType());
        validationService.validatePrice(input);
        validationService.validateSugar(input);
        //then
        assertEquals(true, isValid);
    }

    @Test
    public void makeDrink_coffee_01_1_false() throws ValidateDrinkException {
        //given
        InputArguments input = new InputArguments("coffee", 0.1f, 0);
        input.setExtraHot(false);
        //when
        boolean isValid = validationService.validateDrinkType(input.getDrinkType());
        try {
            validationService.validatePrice(input);
        } catch(ValidateDrinkException ex) {
            //then
            assertEquals(true, isValid);
            assertEquals("The coffee costs 0.5.", ex.getMessage());
        }
    }

    @Test
    public void makeDrink_tea_1_1_false() throws ValidateDrinkException {
        //given
        InputArguments input = new InputArguments("tea", 1f, 1);
        input.setExtraHot(false);
        //when
        boolean isValid = validationService.validateDrinkType(input.getDrinkType());
        validationService.validatePrice(input);
        validationService.validateSugar(input);
        //then
        assertEquals(true, isValid);
    }

    @Test
    public void makeDrink_tea_1_1_true() throws ValidateDrinkException {
        //given
        InputArguments input = new InputArguments("tea", 1f, 1);
        input.setExtraHot(true);
        //when
        boolean isValid = validationService.validateDrinkType(input.getDrinkType());
        validationService.validatePrice(input);
        validationService.validateSugar(input);
        //then
        assertEquals(true, isValid);
    }

    @Test
    public void makeDrink_tea_1_0_false() throws ValidateDrinkException {
        //given
        InputArguments input = new InputArguments("tea", 1f, 0);
        input.setExtraHot(false);
        //when
        boolean isValid = validationService.validateDrinkType(input.getDrinkType());
        validationService.validatePrice(input);
        validationService.validateSugar(input);
        //then
        assertEquals(true, isValid);
    }

    @Test
    public void makeDrink_tea_01_1_false() throws ValidateDrinkException {
        //given
        InputArguments input = new InputArguments("tea", 0.1f, 0);
        input.setExtraHot(false);
        //when
        boolean isValid = validationService.validateDrinkType(input.getDrinkType());
        try {
            validationService.validatePrice(input);
        } catch(ValidateDrinkException ex) {
            //then
            assertEquals(true, isValid);
            assertEquals("The tea costs 0.4.", ex.getMessage());
        }
    }

    @Test
    public void makeDrink_chocolate_1_1_false() throws ValidateDrinkException {
        //given
        InputArguments input = new InputArguments("chocolate", 1f, 1);
        input.setExtraHot(false);
        //when
        boolean isValid = validationService.validateDrinkType(input.getDrinkType());
        validationService.validatePrice(input);
        validationService.validateSugar(input);
        //then
        assertEquals(true, isValid);
    }

    @Test
    public void makeDrink_chocolate_1_1_true() throws ValidateDrinkException {
        //given
        InputArguments input = new InputArguments("chocolate", 1f, 1);
        input.setExtraHot(true);
        //when
        boolean isValid = validationService.validateDrinkType(input.getDrinkType());
        validationService.validatePrice(input);
        validationService.validateSugar(input);
        //then
        assertEquals(true, isValid);
    }

    @Test
    public void makeDrink_chocolate_1_0_false() throws ValidateDrinkException {
        //given
        InputArguments input = new InputArguments("chocolate", 1f, 0);
        input.setExtraHot(false);
        //when
        boolean isValid = validationService.validateDrinkType(input.getDrinkType());
        validationService.validatePrice(input);
        validationService.validateSugar(input);
        //then
        assertEquals(true, isValid);
    }

    @Test
    public void makeDrink_chocolate_01_1_false() throws ValidateDrinkException {
        //given
        InputArguments input = new InputArguments("chocolate", 0.1f, 0);
        input.setExtraHot(false);
        //when
        boolean isValid = validationService.validateDrinkType(input.getDrinkType());
        try {
            validationService.validatePrice(input);
        } catch (ValidateDrinkException ex) {
            //then
            assertEquals(true, isValid);
            assertEquals("The chocolate costs 0.6.", ex.getMessage());
        }
    }

    @Test
    public void makeDrink_foo_1_0_false() throws ValidateDrinkException {
        //given
        InputArguments input = new InputArguments("foo", 1f, 0);
        input.setExtraHot(false);
        //when
        try {
            validationService.validateDrinkType(input.getDrinkType());
        } catch(ValidateDrinkException ex) {
            //then
            assertEquals("The drink type should be tea, coffee or chocolate.", ex.getMessage());
        }
    }

    @Test
    public void makeDrink_chocolate_1_3_false() {
        //given
        InputArguments input = new InputArguments("chocolate", 1f, 3);
        input.setExtraHot(false);
        //when
        boolean isValid = false;
        try {
            isValid = validationService.validateDrinkType(input.getDrinkType());
            validationService.validatePrice(input);
            validationService.validateSugar(input);
        } catch (ValidateDrinkException ex) {
            //then
            assertEquals(true, isValid);
            assertEquals("The number of sugars should be between 0 and 2.", ex.getMessage());
        }
    }
}

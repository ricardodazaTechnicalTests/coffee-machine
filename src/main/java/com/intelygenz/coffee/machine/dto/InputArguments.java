package com.intelygenz.coffee.machine.dto;

import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

public class InputArguments {

    @Parameters
    private String drinkType;
    @Parameters
    private Float money;
    @Parameters(defaultValue = "0")
    private Integer sugar;
    @Option(names = {"-e", "--extra-hot"}, defaultValue = "false")
    private Boolean extraHot;

    public InputArguments() {
    }

    public InputArguments(String drinkType, Float money, Integer sugar) {
        this.drinkType = drinkType;
        this.money = money;
        this.sugar = sugar;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getSugar() {
        return sugar;
    }

    public void setSugar(Integer sugar) {
        this.sugar = sugar;
    }

    public Boolean isExtraHot() {
        return extraHot;
    }

    public void setExtraHot(Boolean extraHot) {
        this.extraHot = extraHot;
    }
}

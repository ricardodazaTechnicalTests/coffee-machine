package com.intelygenz.coffee.machine.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "c_machine_sales")
public class MachineSales {

    @Id
    public String id;
    private Float tea;
    private Float coffe;
    private Float chocolate;

    public MachineSales() {
    }

    public MachineSales(Float tea, Float coffe, Float chocolate) {
        this.tea = tea;
        this.coffe = coffe;
        this.chocolate = chocolate;
    }

    public Float getTea() {
        return tea;
    }

    public void setTea(Float tea) {
        this.tea = tea;
    }

    public Float getCoffe() {
        return coffe;
    }

    public void setCoffe(Float coffe) {
        this.coffe = coffe;
    }

    public Float getChocolate() {
        return chocolate;
    }

    public void setChocolate(Float chocolate) {
        this.chocolate = chocolate;
    }
}

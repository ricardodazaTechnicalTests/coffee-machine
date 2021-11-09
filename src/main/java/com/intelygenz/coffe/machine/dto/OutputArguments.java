package com.intelygenz.coffe.machine.dto;

public class OutputArguments {

    private String message;
    private Boolean error = false;

    public OutputArguments() {
    }

    public OutputArguments(String message, Boolean error) {
        this.message = message;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean isError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }
}

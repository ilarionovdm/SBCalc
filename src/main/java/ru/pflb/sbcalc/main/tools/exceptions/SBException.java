package ru.pflb.sbcalc.main.tools.exceptions;

public class SBException extends Exception {

    public SBException(String message) {
        super(message);
    }

    public SBException() {
        this("Another Error");
    }
}

package ru.pflb.sbcalc.main.tools.exceptions;

public class DivisionException extends SBException{

    public DivisionException(String message) {
        super(message);
    }

    public DivisionException() {
        this("Произошла ошибка деления");
    }
}

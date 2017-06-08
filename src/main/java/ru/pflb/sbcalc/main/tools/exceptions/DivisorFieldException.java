package ru.pflb.sbcalc.main.tools.exceptions;

public class DivisorFieldException extends SBException {

    public DivisorFieldException(String message) {
        super(message);
    }

    public DivisorFieldException() {
        this("Произошла ошибка ввода в поле Делителя");
    }
}

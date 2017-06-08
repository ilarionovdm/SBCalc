package ru.pflb.sbcalc.main.tools.exceptions;

public class DividendFieldException extends SBException{

    public DividendFieldException(String message){
        super(message);
    }

    public DividendFieldException() {
        this("Произошла ошибка ввода в поле Делимого числа");
    }
}

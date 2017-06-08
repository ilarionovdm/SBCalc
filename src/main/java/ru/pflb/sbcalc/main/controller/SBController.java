package ru.pflb.sbcalc.main.controller;

import ru.pflb.sbcalc.main.gui.SBCalcForm;
import ru.pflb.sbcalc.main.math_logic.MathLogic;
import ru.pflb.sbcalc.main.tools.exceptions.DividendFieldException;
import ru.pflb.sbcalc.main.tools.exceptions.DivisionException;
import ru.pflb.sbcalc.main.tools.exceptions.DivisorFieldException;
import ru.pflb.sbcalc.main.tools.exceptions.SBException;

public class SBController {

    public static void grabDataAndDivision(SBCalcForm form) throws SBException{
        double dividend, divisor, equal;

        try {
            dividend = Double.parseDouble(form.a.getText());
        } catch (Exception e){
            throw new DividendFieldException();
        }
        try {
            divisor = Double.parseDouble(form.b.getText());
        } catch (Exception e){
            throw new DivisorFieldException();
        }

        try {
            equal = MathLogic.getDivision(dividend, divisor);
        } catch (Exception e){
            throw new DivisionException();
        }
        form.c.setText(String.valueOf(equal));
    }
}

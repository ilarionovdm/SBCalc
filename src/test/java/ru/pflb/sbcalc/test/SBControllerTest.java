package ru.pflb.sbcalc.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.pflb.sbcalc.main.controller.SBController;
import ru.pflb.sbcalc.main.gui.SBCalcForm;
import ru.pflb.sbcalc.main.tools.exceptions.DividendFieldException;
import ru.pflb.sbcalc.main.tools.exceptions.SBException;

import static org.junit.Assert.*;

public class SBControllerTest {

    SBCalcForm sbCalcForm;

    @Before
    public void setUp() throws Exception {
        sbCalcForm = new SBCalcForm();
    }

    @After
    public void tearDown() throws Exception {
        sbCalcForm.dispose();
    }

    @Test
    public void test1_erase_DividendFieldException() {
        sbCalcForm.a.setText(String.valueOf(10));
        sbCalcForm.b.setText(String.valueOf(5));
        try {
            SBController.grabDataAndDivision(sbCalcForm);
        } catch (DividendFieldException dfe) {
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.fail();
        }
    }

}
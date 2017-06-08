package ru.pflb.sbcalc.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.pflb.sbcalc.main.gui.SBCalcForm;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class SBCalcFormTest {

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
    public void test1_correct_input(){
        sbCalcForm.a.setText(String.valueOf(10));
        sbCalcForm.b.setText(String.valueOf(5));
        MouseEvent me = new MouseEvent(sbCalcForm.equal, MouseEvent.MOUSE_CLICKED,
                System.currentTimeMillis(),
                0,
                sbCalcForm.equal.getX(), sbCalcForm.equal.getY(),
                1,
                false);
        for (MouseListener ml : sbCalcForm.equal.getMouseListeners()){
            ml.mouseClicked(me);
        }
        Double result = Double.parseDouble(sbCalcForm.c.getText());
        Assert.assertEquals(new Double(10/5), result);

    }

    @Test
    public void test2_dividend_not_present(){
        sbCalcForm.b.setText(String.valueOf(5));
        sbCalcForm.getComponents();
        final MouseEvent me = new MouseEvent(sbCalcForm.equal, MouseEvent.MOUSE_CLICKED,
                System.currentTimeMillis(),
                0,
                sbCalcForm.equal.getX(), sbCalcForm.equal.getY(),
                1,
                true);
        for (MouseListener ml : sbCalcForm.equal.getMouseListeners()){
            final MouseListener i = ml;
            Thread errorMessage = new Thread(new Runnable() {
                public void run() {
                    i.mouseClicked(me);
                }
            });
            errorMessage.start();
        }
        try {
            if (!sbCalcForm.hasFocus()) {
                Assert.assertTrue(true);
                return;
            }
        } catch (Exception e){
            Assert.fail();
        }
        Assert.fail();
    }
}
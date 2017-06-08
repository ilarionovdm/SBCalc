package ru.pflb.sbcalc.main.gui;

import ru.pflb.sbcalc.main.tools.exceptions.SBException;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static ru.pflb.sbcalc.main.controller.SBController.grabDataAndDivision;

public class SBCalcForm extends JFrame {
    private JPanel root;
    public JTextField a;
    public JTextField b;
    public JTextField c;
    public JButton equal;
    private SBCalcForm instance;

    public SBCalcForm() {
        setContentPane(root);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        instance = this;
        equal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    grabDataAndDivision(instance);
                } catch (SBException sbe){
                    JOptionPane.showMessageDialog(null, sbe.getMessage(), "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}

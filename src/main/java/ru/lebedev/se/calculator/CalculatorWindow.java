package ru.lebedev.se.calculator;

/**
 * @author Anatoly Lebedev
 * @version 1.0.1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.sqrt;

public final class CalculatorWindow extends JFrame {

    private final JTextField textField = new JTextField(100);
    private final JLabel label = new JLabel();
    private final JPanel buttonPanel = new JPanel();

    private final JButton b0 = new JButton("0");
    private final JButton b1 = new JButton("1");
    private final JButton b2 = new JButton("2");
    private final JButton b3 = new JButton("3");
    private final JButton b4 = new JButton("4");
    private final JButton b5 = new JButton("5");
    private final JButton b6 = new JButton("6");
    private final JButton b7 = new JButton("7");
    private final JButton b8 = new JButton("8");
    private final JButton b9 = new JButton("9");
    private final JButton dot = new JButton(".");
    private final JButton add = new JButton("+");
    private final JButton sub = new JButton("-");
    private final JButton equal = new JButton("=");
    private final JButton div = new JButton("/");
    private final JButton mul = new JButton("*");
    private final JButton sqrt = new JButton("\u221A");
    private final JButton x2 = new JButton("x^2");
    private final JButton clear = new JButton("C");
    private final JButton plusMinus = new JButton("\u00B1"); //\u00B1

    //-----------------------------------------------------------------------------------

    public CalculatorWindow() {
        setLayout(null);
        textField.setBounds(10, 10, 200, 30);
        textField.setHorizontalAlignment(4);
        textField.setText("0");
        label.setBounds(10, 40, 198, 20);
        label.setHorizontalAlignment(4);
        label.setText("Готов к расчетам");
        buttonPanel.setBounds(10, 60, 200, 210);
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        setTitle("Calc");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //-----------------------------------------------------------------------------------
        clear.setBackground(Color.PINK);
        buttonPanel.add(clear);
        buttonPanel.add(sqrt);
        buttonPanel.add(x2);
        buttonPanel.add(div);
        buttonPanel.add(b7);
        buttonPanel.add(b8);
        buttonPanel.add(b9);
        buttonPanel.add(mul);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(sub);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(add);
        buttonPanel.add(plusMinus);
        buttonPanel.add(b0);
        buttonPanel.add(dot);
        buttonPanel.add(equal);

        //-----------------------------------------------------------------------------------

        MegaListener ml = new MegaListener();
        add.addActionListener(ml);
        sub.addActionListener(ml);
        mul.addActionListener(ml);
        div.addActionListener(ml);
        equal.addActionListener(ml);
        b0.addActionListener(ml);
        b1.addActionListener(ml);
        b2.addActionListener(ml);
        b3.addActionListener(ml);
        b4.addActionListener(ml);
        b5.addActionListener(ml);
        b6.addActionListener(ml);
        b7.addActionListener(ml);
        b8.addActionListener(ml);
        b9.addActionListener(ml);
        dot.addActionListener(ml);
        plusMinus.addActionListener(ml);
        sqrt.addActionListener(ml);
        clear.addActionListener(ml);
        x2.addActionListener(ml);

        add(textField);
        add(label);
        add(buttonPanel);
        setSize(230, 320);
        setLocationRelativeTo(null); // выводим по центру
    }

    //-----------------------------------------------------------------------------------

    static double a = 0;
    static int op = 0;

    //-----------------------------------------------------------------------------------

    private class MegaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();

            if (cmd.equals("C")) {
                textField.setText("0"); // Устанавливаем в 0, во избежание ошибок при работе функций
                label.setText("Готов к расчетам");
            }

            if (cmd.equals("\u00B1")) {
                if (textField.getText().substring(0, 1).equals("-")) {
                    textField.setText(textField.getText().substring(1, textField.getText().length()));
                } else {
                    textField.setText("-".concat(textField.getText()));
                }
            }

            if (cmd.equals("x^2")) {
                a = Double.parseDouble(textField.getText());
                a *= a;
                textField.setText("" + a);
                label.setText(textField.getText());
            }

            if (cmd.equals("\u221A")) {
                a = Double.parseDouble(textField.getText());
                if (a >= 0) {
                    a = sqrt(a);
                    textField.setText("" + a);
                    label.setText(textField.getText());
                } else {
                    textField.setText("" + a);
                    label.setText("Только для значений >= 0");
                }
            }

            if (cmd.equals("+")) {
                a = Double.parseDouble(textField.getText());
                op = 1;
                label.setText(Double.toString(a) + " + "); // убираем ведущие нули
                textField.setText("");
            }

            if (cmd.equals("-")) {
                a = Double.parseDouble(textField.getText());
                op = 2;
                label.setText(Double.toString(a) + " - ");
                textField.setText("");
            }

            if (cmd.equals("*")) {
                a = Double.parseDouble(textField.getText());
                op = 3;
                label.setText(Double.toString(a) + " * ");
                textField.setText("");
            }

            if (cmd.equals("/")) {
                a = Double.parseDouble(textField.getText());
                op = 4;
                label.setText(Double.toString(a) + " / ");
                textField.setText("");
            }

            if (cmd.equals("=")) {
                double b = Double.parseDouble(textField.getText());
                double c = 0;
                switch (op) {
                    case 1:
                        c = a + b;
                        label.setText(label.getText() + b + " = " + c);
                        break;
                    case 2:
                        c = a - b;
                        label.setText(label.getText() + b + " = " + c);
                        break;
                    case 3:
                        c = a * b;
                        label.setText(label.getText() + b + " = " + c);
                        break;
                    case 4:
                        c = a / b;
                        label.setText(label.getText() + b + " = " + c);
                        break;
                    default:
                        c = 0;
                }
                textField.setText(Double.toString(c));
            }

            if (cmd.equals("0")) textField.setText(textField.getText().concat("0"));
            if (cmd.equals("1")) textField.setText(textField.getText().concat("1"));
            if (cmd.equals("2")) textField.setText(textField.getText().concat("2"));
            if (cmd.equals("3")) textField.setText(textField.getText().concat("3"));
            if (cmd.equals("4")) textField.setText(textField.getText().concat("4"));
            if (cmd.equals("5")) textField.setText(textField.getText().concat("5"));
            if (cmd.equals("6")) textField.setText(textField.getText().concat("6"));
            if (cmd.equals("7")) textField.setText(textField.getText().concat("7"));
            if (cmd.equals("8")) textField.setText(textField.getText().concat("8"));
            if (cmd.equals("9")) textField.setText(textField.getText().concat("9"));
            if (cmd.equals(".")) textField.setText(textField.getText().concat("."));
        }
    }
}

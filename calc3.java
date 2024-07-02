import java.awt.*;
import java.awt.event.*;

class Fdemo extends Frame implements ActionListener {
    TextField tx1;
    Button a[];
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
    String operator = "";
    double num1, num2, result;

    Fdemo() {
        setLayout(null);
        Font f = new Font("", Font.BOLD, 30);
        setFont(f);
        a = new Button[9];
        int i, j, k = 0;
        int w = 100, h = 100;
        int x = 100;
        int y = 150;
        int c = 0;

        for (i = 1; i <= 3; i++) {
            for (j = 1; j <= 3; j++) {
                c++;
                a[k] = new Button();
                a[k].setSize(w, h);
                a[k].setLocation(x, y);
                a[k].setLabel("" + c);
                add(a[k]);
                a[k].addActionListener(this);
                x += 100;
                k++;
            }
            x = 100;
            y += 100;
        }

        tx1 = new TextField(10);
        tx1.setSize(300, 50);
        tx1.setLocation(100, 50);
        add(tx1);

        b1 = new Button("+");
        b1.setSize(100, 100);
        b1.setLocation(400, 50);
        add(b1);
        b1.addActionListener(this);

        b2 = new Button("-");
        b2.setSize(100, 100);
        b2.setLocation(400, 150);
        add(b2);
        b2.addActionListener(this);

        b3 = new Button("/");
        b3.setSize(100, 100);
        b3.setLocation(400, 250);
        add(b3);
        b3.addActionListener(this);

        b4 = new Button("*");
        b4.setSize(100, 100);
        b4.setLocation(400, 350);
        add(b4);
        b4.addActionListener(this);

        b5 = new Button("%");
        b5.setSize(100, 100);
        b5.setLocation(400, 450);
        add(b5);
        b5.addActionListener(this);

        b6 = new Button("=");
        b6.setSize(100, 500);
        b6.setLocation(500, 50);
        add(b6);
        b6.addActionListener(this);

        b7 = new Button("0");
        b7.setSize(100, 100);
        b7.setLocation(100, 450);
        add(b7);
        b7.addActionListener(this);

        b8 = new Button("00");
        b8.setSize(100, 100);
        b8.setLocation(200, 450);
        add(b8);
        b8.addActionListener(this);

        b9 = new Button(".");
        b9.setSize(100, 100);
        b9.setLocation(300, 450);
        add(b9);
        b9.addActionListener(this);

        b10 = new Button("C");
        b10.setSize(100, 50);
        b10.setLocation(100, 100);
        add(b10);
        b10.addActionListener(this);

        b11 = new Button("ON");
        b11.setSize(100, 50);
        b11.setLocation(200, 100);
        add(b11);
        b11.addActionListener(this);

        b12 = new Button("OFF");
        b12.setSize(100, 50);
        b12.setLocation(300, 100);
        add(b12);
        b12.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("C")) {
            tx1.setText("");
        } else if (cmd.equals("ON")) {
            tx1.setEnabled(true);
        } else if (cmd.equals("OFF")) {
            tx1.setEnabled(false);
        } else if (cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/") || cmd.equals("%")) {
            num1 = Double.parseDouble(tx1.getText());
            operator = cmd;
            tx1.setText("");
        } else if (cmd.equals("=")) {
            num2 = Double.parseDouble(tx1.getText());

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        tx1.setText("Error");
                        return;
                    }
                    break;
                case "%":
                    result = num1 % num2;
                    break;
            }
            tx1.setText("" + result);
        } else {
            tx1.setText(tx1.getText() + cmd);
        }
    }

    public static void main(String[] ar) {
        Fdemo f = new Fdemo();
        f.setVisible(true);
        f.setSize(800, 800);
        f.setLocation(100, 100);
        Color c = new Color(192, 192, 192);
        f.setBackground(c);
    }
}

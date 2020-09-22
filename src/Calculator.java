import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JPanel panel;
    JTextField textField;

    JButton addButton,subButton,mulButton,divButton,decButton,equButton,delButton,clrButton,negButton;

    JButton[] numberButtons = new JButton[10];
    JButton[] functionalButtons = new JButton[9];

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Font font = new Font("Arial", Font.BOLD,30);

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont( font );

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");

        functionalButtons[0] = addButton;
        functionalButtons[1] = subButton;
        functionalButtons[2] = mulButton;
        functionalButtons[3] = divButton;
        functionalButtons[4] = decButton;
        functionalButtons[5] = equButton;
        functionalButtons[6] = delButton;
        functionalButtons[7] = clrButton;
        functionalButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionalButtons[i].addActionListener(this);
            functionalButtons[i].setFont(font);
            functionalButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout( new GridLayout(4,4,10,10) );

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numberButtons.length; i++) {
            if ( e.getSource() == numberButtons[i] )
                textField.setText(textField.getText().concat(String.valueOf(i)));
        }
        if ( e.getSource() == decButton )
            textField.setText(textField.getText().concat("."));

        if ( e.getSource() == addButton ) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if ( e.getSource() == subButton ) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if ( e.getSource() == mulButton ) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if ( e.getSource() == divButton ) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if ( e.getSource() == equButton ) {
            num2 = Double.parseDouble(textField.getText());

            switch ( operator ) {
                case '+' :
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*' :
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if ( e.getSource() == delButton ) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if ( e.getSource() == clrButton ) {
            textField.setText("");
        }

        if ( e.getSource() == negButton ) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

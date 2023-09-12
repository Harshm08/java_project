import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[]  numButtons = new  JButton[10];
    JButton[]  funButtons = new  JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    Font font1  = new Font("Comic Sans MS",Font.BOLD,30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

   Calculator(){
         frame  = new JFrame("Calculator");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
         frame.setSize(420,520);
         frame.setLayout(null);

         textfield = new JTextField();
         textfield.setBounds(50,20,300,50);
         textfield.setFont(font1);
         textfield.setEditable(false);

         addButton = new JButton("+");
         subButton = new JButton("-");
         mulButton = new JButton("*");
         divButton = new JButton("/");
         decButton = new JButton(".");
         equButton = new JButton("=");
         delButton = new JButton("del");
         clrButton = new JButton("clr");

         funButtons[0]   = addButton;
         funButtons[1]   = subButton;
         funButtons[2]   = mulButton;
         funButtons[3]   = divButton;
         funButtons[4]   = decButton;
         funButtons[5]   = equButton;
         funButtons[6]   = delButton;
         funButtons[7]   = clrButton;

        for(int i = 0;i < 8; i++){
            funButtons[i].addActionListener(this);
            funButtons[i].setFont(font1);
            funButtons[i].setFocusable(false);
        }

         for(int i = 0;i < 10; i++){
          numButtons[i]  = new JButton(String.valueOf(i));
          numButtons[i].addActionListener(this);
          numButtons[i].setFont(font1);
          numButtons[i].setFocusable(false);
        }

        delButton.setBounds(45,400,150,58);
        clrButton.setBounds(205,400,150,58);

         panel  = new JPanel();
         panel.setBounds(50,100,300,300);
         panel.setLayout(new GridLayout(4,4,10,10));
        // panel.setBackground(Color.BLACK);

         panel.add(numButtons[1]);
         panel.add(numButtons[2]);
         panel.add(numButtons[3]);
         panel.add(addButton);

         panel.add(numButtons[4]);
         panel.add(numButtons[5]);
         panel.add(numButtons[6]);
         panel.add(subButton);

         panel.add(numButtons[7]);
         panel.add(numButtons[8]);
         panel.add(numButtons[9]);
         panel.add(mulButton);

         panel.add(decButton);
         panel.add(numButtons[0]);
         panel.add(equButton);
         panel.add(divButton);

         frame.add(panel);
         frame.add(delButton);
         frame.add(clrButton);
         frame.add(textfield);
         frame.setVisible(true);
   }

   public static void main(String[] arg)
   {
       Calculator calc = new Calculator();
   }

    @Override
     public void actionPerformed(ActionEvent e){
            for(int i = 0 ; i < 10; i++){
                 if(e.getSource() == numButtons[i]){
                    textfield.setText(textfield.getText().concat(String.valueOf(i)));
                 }
            }

              if(e.getSource() == decButton){
                    textfield.setText(textfield.getText().concat("."));
              }

             if(e.getSource() == addButton){
                     num1 = Double.parseDouble(textfield.getText());
                     operator = '+';
                     textfield.setText("");
             }
             if(e.getSource() == subButton){
                     num1 = Double.parseDouble(textfield.getText());
                     operator = '-';
                     textfield.setText("");
             }
             if(e.getSource() == mulButton){
                     num1 = Double.parseDouble(textfield.getText());
                     operator = '*';
                     textfield.setText("");
             }
             if(e.getSource() == divButton){
                     num1 = Double.parseDouble(textfield.getText());
                     operator = '/';
                     textfield.setText("");
             }

             if(e.getSource() == equButton){
                     num2 = Double.parseDouble(textfield.getText());

                     switch(operator){
                          case '+' : result = num1 + num2;
                                         break;
                          case '-' : result = num1 - num2;
                                         break;
                          case '*' : result = num1 * num2;
                                         break;
                          case '/' : result = num1 / num2;
                                         break;
                     }
                     textfield.setText(String.valueOf(result));
                     num1 = result;
              }

              if(e.getSource() == clrButton){
                    textfield.setText("");
             }
              if(e.getSource() == delButton){
                    String st = textfield.getText();
                    textfield.setText("");
                   
                    for(int i = 0; i < st.length()-1 ; i++){
                            textfield.setText(textfield.getText() + st.charAt(i));
                    }
             }
      }
}

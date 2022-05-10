package Immobiliser;

import javax.swing.JTextArea;
public class TextAreas {
    public JTextArea letrehoz(){
        JTextArea tf1 = new JTextArea();
        tf1.setBounds(620, 310, 300, 100);
        tf1.setRows(6); //Rows number.
        tf1.setVisible(true); //Can we see it?
        tf1.setEditable(false); //The user can/can't change the text.
        return tf1;
    }
}//end

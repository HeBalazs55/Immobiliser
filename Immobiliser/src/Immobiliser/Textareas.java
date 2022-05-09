package Immobiliser;

import javax.swing.JTextArea;

public class Textareas {
    public JTextArea letrehoz(){
        JTextArea tf1 = new JTextArea();
        tf1.setBounds(620, 310, 300, 100);  //Helyzete
        tf1.setRows(6); //Hány sort jelenítsen meg
        tf1.setVisible(true); //Láthatóság
        tf1.setEditable(false); //A felhasználó nem tudja módosítani a tartalmát

        return tf1;
    }
}//vége

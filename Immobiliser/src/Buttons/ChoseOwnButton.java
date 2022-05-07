package Buttons;

import Immobiliser.Chose;
import Immobiliser.Simulation;

import javax.swing.JButton;
import java.awt.Font;

public class ChoseOwnButton extends Button {

    public ChoseOwnButton(String na, Integer[] bo, String te, Boolean f) {
        super(na, bo, te, f);
    }
    public JButton letrehoz(){
        JButton gomb = new JButton();
        gomb.setBounds(getBound1(), getBound2(), getBound3(), getBound4());
        gomb.setText(getText());
        gomb.setFont(new Font("Comic Sans",Font.BOLD, 20));
        gomb.setFocusable(getFocusable());
        gomb.addActionListener((event) -> Chose.close());
        gomb.addActionListener((event) -> new Simulation());
        return gomb;
    }
}

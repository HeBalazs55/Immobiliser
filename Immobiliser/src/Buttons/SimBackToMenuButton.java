package Buttons;

import Immobiliser.Simulation;
import Immobiliser.Menu;

import javax.swing.JButton;
import java.awt.Font;

public class SimBackToMenuButton extends Button {

    public SimBackToMenuButton(String na, Integer[] bo, String te, Boolean f) {
        super(na, bo, te, f);
    }
    public JButton letrehoz(){
        JButton gomb = new JButton();
        gomb.setBounds(getBound1(), getBound2(), getBound3(), getBound4());
        gomb.setText(getText());
        gomb.setFont(new Font("Comic Sans",Font.BOLD, 14));
        gomb.setFocusable(getFocusable());
        //gomb.addActionListener((event) -> Simulation.close());
        gomb.addActionListener((event) -> new Menu());
        return gomb;
    }
}

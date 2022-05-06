package Buttons;

import Immobiliser.Menu;

import javax.swing.JButton;
import java.awt.Font;

public class MenuExitButton extends Buttons {

    public MenuExitButton(String na, Integer[] bo, String te, Boolean f) {
        super(na, bo, te, f);
    }
    public JButton letrehoz(){
        JButton gomb = new JButton();
        gomb.setBounds(getBound1(), getBound2(), getBound3(), getBound4());
        gomb.setText(getText());
        gomb.setFont(new Font("Comic Sans",Font.BOLD, 20));
        gomb.setFocusable(getFocusable());
        gomb.addActionListener((event) -> Menu.close());
        gomb.addActionListener((event) -> System.exit(0));
        return gomb;
    }
}

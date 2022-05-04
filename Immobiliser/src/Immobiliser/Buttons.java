package Immobiliser;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JButton{
    private String name;
    private Integer[] bounds;
    private String text;
    private Boolean focusable;

    public Buttons(String na, Integer[] bo, String te, Boolean f){
        name = na; bounds = bo; text = te; focusable = f;

    }
    public JButton letrehoz(){
        JButton gomb = new JButton();
        gomb.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        gomb.setText(text);
        gomb.setFont(new Font("Comic Sans",Font.BOLD, 20));
        gomb.setFocusable(focusable);
        return gomb;
    }
}

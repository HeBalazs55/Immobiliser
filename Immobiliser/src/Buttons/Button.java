package Buttons;

import javax.swing.JButton;
import java.awt.Font;


abstract public class Button extends JButton{
    private String name;
    private Integer[] bounds;
    private String text;
    private Boolean focusable;

    public Button(String na, Integer[] bo, String te, Boolean f){
        name = na; bounds = bo; text = te; focusable = f;

    }
    public String getName(){return name;}
    public Integer getBound1() {return bounds[0];}
    public Integer getBound2() {return bounds[1];}
    public Integer getBound3() {return bounds[2];}
    public Integer getBound4() {return bounds[3];}
    public String getText() {return text;}
    public Boolean getFocusable() {return focusable;}
    public JButton letrehoz(){
        JButton gomb = new JButton();
        gomb.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        gomb.setText(text);
        gomb.setFont(new Font("Comic Sans",Font.BOLD, 20));
        gomb.setFocusable(focusable);
        return gomb;
    }
}

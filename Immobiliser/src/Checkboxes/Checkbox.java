package Checkboxes;

import javax.swing.*;

public class Checkbox {
    private String text;
    private Integer[] bounds;

    public Checkbox(String te, Integer[] bo){
        text = te; bounds = bo;
    }
    public String getText(){return text;}

    public Integer getBound1(){return bounds[0];}
    public Integer getBound2(){return bounds[1];}
    public Integer getBound3(){return bounds[2];}
    public Integer getBound4(){return bounds[3];}

    public JCheckBox letrehoz(){
        JCheckBox c = new JCheckBox(getText());
        c.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        c.setFocusable(false);
        return c;
    }
}//end

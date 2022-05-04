package Immobiliser;

import javax.swing.*;

public class Checkboxes extends JFrame{

    protected static JCheckBox c1;
    protected static JCheckBox c2;

    public static JCheckBox C1(){
        c1 = new JCheckBox("Gyenge védelem");
        c1.setBounds(630,200,130,20);
        c1.addActionListener((event) -> c2.setSelected(false));
        c1.addActionListener((event) -> Textareas.setTF1(FileRead.elsosor("src\\gyenge.txt")));
        return c1;
    }

    public static JCheckBox C2(){
        c2 = new JCheckBox("Közepes védelem");
        c2.setBounds(630,250,130,20);
        c2.addActionListener((event) -> c1.setSelected(false));
        c2.addActionListener((event) -> Textareas.setTF1(FileRead.elsosor("src\\eros.txt")));
        return c2;
    }
}

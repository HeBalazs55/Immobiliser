package Immobiliser;

import Buttons.*;
import Checkboxes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chose implements ActionListener {
    ChoseDraw ChoseDraw;
    static JFrame ChoseFrame;

    //----------CHECKBOXOK------------
    Integer C1Bounds[] = {630,200,130,20};
    Checkbox C1= new Checkbox("Gyenge védelem", C1Bounds);
    JCheckBox gyenge;

    Integer C2Bounds[] = {630,250,130,20};
    Checkbox C2 = new Checkbox("Erős védelem", C2Bounds);
    JCheckBox eros;

    public Chose(){
        ChoseFrame = new JFrame("Indításgátló");
        ChoseDraw = new ChoseDraw();

        //---------GOMBOK------------
        //----Előre összeállított szim. indítása gomb
        Integer Startbounds[] = {810, 210, 110, 50};
        ChoseStartButton SB = new ChoseStartButton("Indítás", Startbounds, "Indítás", false);

        //----Saját szim. összeállítása gomb
        Integer OwnStartbounds[] = {660, 480, 200, 100};
        ChoseOwnButton OB = new ChoseOwnButton("Sajat", OwnStartbounds, "<html>Saját csomag<br />összeállítása</html>", false);

        //----Vissza lépés a menübe gomb
        Integer BackToMenuBounds[] = {510, 615, 80, 40};
        ChoseBackButton BB = new ChoseBackButton("Vissza", BackToMenuBounds, "Vissza", false);

        //----------CHECKBOXOK------------
        gyenge = C1.letrehoz();
        gyenge.addActionListener(this);

        eros = C2.letrehoz();
        eros.addActionListener(this);

        //---------Választás Frame összerakása-----------
        ChoseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ha jobb felül az x-re kattintunk bezáródik az ablak, nem csak tálcázódik
        ChoseFrame.add(ChoseDraw);
        ChoseFrame.pack();
        ChoseFrame.setLayout(null);
        ChoseFrame.add(SB.letrehoz());
        ChoseFrame.add(OB.letrehoz());
        ChoseFrame.add(BB.letrehoz());
        ChoseFrame.add(gyenge);
        ChoseFrame.add(eros);
        ChoseFrame.add(Textareas.TF1());
        ChoseFrame.setLocationRelativeTo(null); //a képernyő középen fog megjelenni
        ChoseFrame.setVisible(true); //az ablak megjelenik
    }
    public static void close(){
        ChoseFrame.dispose();
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==gyenge){
            eros.setSelected(false);
            Textareas.setTF1(FileRead.elsosor("src\\gyenge.txt"));
        }
        if(e.getSource()==eros){
            gyenge.setSelected(false);
            Textareas.setTF1(FileRead.elsosor("src\\eros.txt"));
        }
    }
}//end

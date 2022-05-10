package Immobiliser;

import Buttons.*;
import Checkboxes.Checkbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chose extends JFrame implements ActionListener {
    ChoseDraw ChoseDraw;
    FileRead Reader = new FileRead();
    TextAreas TF1 = new TextAreas();
    JTextArea TextA;

    //-----------------------------------------------------------------------------------------------------------------------------
    //----------------------------------------------------------CHECKBOXOK---------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    Integer[] C1Bounds = {630,200,130,20};
    Checkbox C1= new Checkbox("Gyenge védelem", C1Bounds);
    JCheckBox Weak;

    Integer[] C2Bounds = {630,250,130,20};
    Checkbox C2 = new Checkbox("Erős védelem", C2Bounds);
    JCheckBox Strong;

    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------BUTTONS-----------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    //Buttons created global
    Integer[] Startbounds = {810, 210, 110, 50};
    ChoseStartButton SB = new ChoseStartButton("Indítás", Startbounds, "Indítás", false);
    JButton StartButton;


    Integer[] OwnStartbounds = {660, 480, 200, 100};
    ChoseOwnButton OB = new ChoseOwnButton("Saját", OwnStartbounds, "<html>Saját csomag<br />összeállítása</html>", false);
    JButton OwnButton;


    Integer[] BackToMenuBounds = {510, 615, 80, 40};
    ChoseBackButton BMB = new ChoseBackButton("Vissza", BackToMenuBounds, "Vissza", false);
    JButton BackToMenuButton;

    public Chose(){
        ChoseDraw = new ChoseDraw();
        TextA = TF1.letrehoz();
        //-----------------------------------------------------------------------------------------------------------------------------
        //-----------------------------------------------------------BUTTONS-----------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------------------------
        StartButton = SB.letrehoz();
        StartButton.addActionListener(this);

        OwnButton = OB.letrehoz();
        OwnButton.addActionListener(this);

        BackToMenuButton = BMB.letrehoz();
        BackToMenuButton.addActionListener(this);
        BackToMenuButton.setFont(new Font("Comic Sans", Font.BOLD, 14));
        //-----------------------------------------------------------------------------------------------------------------------------
        //-----------------------------------------------------------CHECKBOXOK--------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------------------------
        Weak = C1.letrehoz();
        Weak.addActionListener(this);

        Strong = C2.letrehoz();
        Strong.addActionListener(this);
        //-----------------------------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------Chose Frame Build-----------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //If you click on the X in the right-top corner, the program will close.
        this.setTitle("Indításgátló"); //The name of the Frame.
        this.add(ChoseDraw);
        this.pack(); //Frame and the JPanel will fit to each other
        this.setLayout(null); //The layout on the frame
        this.add(StartButton);
        this.add(OwnButton);
        this.add(BackToMenuButton);
        this.add(Weak);
        this.add(Strong);
        this.add(TextA);
        this.setLocationRelativeTo(null);  //It will appear in the middle of the screen
        this.setVisible(true); //The window appear
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==Weak){
            TextA.setText("");
            String[] Components = Reader.FirstRow("src\\weak.txt");
            Strong.setSelected(false);
            for (String s : Components) {
                TextA.append(s + "\n");
            }
        }
        if(e.getSource()==Strong){
            TextA.setText("");
            String[] Components = Reader.FirstRow("src\\strong.txt");
            Weak.setSelected(false);
            for (String s : Components) {
                TextA.append(s + "\n");
            }
        }
        if(e.getSource()==StartButton) {
            if (Weak.isSelected()) {
                SimLayeredPane.setLoad(Reader.ComponentYesNo("src\\weak.txt"));
                dispose();
                new Simulation();
            } else if (Strong.isSelected()) {
                SimLayeredPane.setLoad(Reader.ComponentYesNo("src\\strong.txt"));
                dispose();
                new Simulation();
            }
        }
        if (e.getSource() == OwnButton) {
            Integer[] noLoad = {0,0,0,0,0,0};
            SimLayeredPane.setLoad(noLoad);
            dispose();
            new Simulation();
        }
        if (e.getSource() == BackToMenuButton) {
            dispose();
            new Menu();
        }
    }//ActionPerformer end
}//end

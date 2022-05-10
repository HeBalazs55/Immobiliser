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
    Textareas TF1 = new Textareas();
    JTextArea TextA;

    //-----------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------CHECKBOXOK--------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    Integer[] C1Bounds = {630,200,130,20};
    Checkbox C1= new Checkbox("Gyenge védelem", C1Bounds);
    JCheckBox Weak;

    Integer[] C2Bounds = {630,250,130,20};
    Checkbox C2 = new Checkbox("Erős védelem", C2Bounds);
    JCheckBox Strong;

    //-----------------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------GOMBOK----------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------
    //GlobÃ¡lisan lÃ©tre hozzuk a Gombokat
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
        //-------------------------------------------------------------GOMBOK----------------------------------------------------------
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ha jobb felÃ¼l az x-re kattintunk bezÃ¡rÃ³dik az ablak, nem csak tÃ¡lcÃ¡zÃ³dik.
        this.setTitle("IndÃ­tÃ¡sgÃ¡tlÃ³"); //A Frame neve. Ez jelenik meg bal felÃ¼l ha az ablak megnyÃ­lik.
        this.add(ChoseDraw);
        this.pack(); //Frame Ã©s JPanel illeszkedÃ©sÃ©t intÃ©zÅ‘ parancs
        this.setLayout(null); //ElrendezÃ©s a frame-en.
        this.add(StartButton);
        this.add(OwnButton);
        this.add(BackToMenuButton);
        this.add(Weak);
        this.add(Strong);
        this.add(TextA);
        this.setLocationRelativeTo(null); //a kÃ©pernyÅ‘ kÃ¶zÃ©pen fog megjelenni
        this.setVisible(true); //az ablak megjelenik
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==Weak){
            TextA.setText("");
            String[] komponensek = Reader.FirstRow("src\\weak.txt");
            Strong.setSelected(false);
            for (String s : komponensek) {
                TextA.append(s + "\n");
            }
        }
        if(e.getSource()==Strong){
            TextA.setText("");
            String[] komponensek = Reader.FirstRow("src\\strong.txt");
            Weak.setSelected(false);
            for (String s : komponensek) {
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

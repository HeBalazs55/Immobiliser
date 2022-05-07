package Immobiliser;

import Buttons.SimBackButton;
import Buttons.SimBackToMenuButton;
import Buttons.SimIgnitionButton;
import Buttons.SimStartButton;
import Checkboxes.Checkbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Simulation  implements ActionListener{
    SimulationDraw SimD;
    static JFrame SimFrame;
    String hozza = "Hozzáad";
    String torol = "Töröl";

    JLabel motorjobb;
    JLabel motorbal;

//--------------------------------------------------------------------------------------------------------------------------------------------
    //##########################
    //##########GOMBOK##########
    //##########################
    //Gyújtás gomb deklarálása
    Integer IgnitionBounds[] = {280, 275, 100, 40};
    SimIgnitionButton IB = new SimIgnitionButton("Gyújtás", IgnitionBounds, "Gyújtás", false);
    JButton gyujtas;

    //Indítás gomb deklarálása
    Integer StartBounds[] = {280, 335, 100, 40};
    SimStartButton SB = new SimStartButton("Indítás", StartBounds, "Start", false);
    JButton inditas;
    //--------------------------------------------------------------------------------------------------------------------------------------------
    //##############################
    //##########CHECKBOXOK##########
    //##############################
    Integer[] C1Bounds = {1280, 130 ,85 , 15};
    Checkbox C1 = new Checkbox(hozza, C1Bounds);
    JCheckBox CodeYes;

    Integer[] C2Bounds = {1390, 130, 85, 15};
    Checkbox C2 = new Checkbox(torol, C2Bounds);
    JCheckBox CodeNo;
    //------------------------------------------------------
    Integer[] C3Bounds = {1280, 240, 85, 15};
    Checkbox C3 = new Checkbox(hozza, C3Bounds);
    JCheckBox KeyYes;
    Integer[] C4Bounds = {1390, 240, 85, 15};
    Checkbox C4 = new Checkbox(torol, C4Bounds);
    JCheckBox KeyNo;
    //------------------------------------------------------
    Integer[] C5Bounds = {1280,350,85,15};
    Checkbox C5 = new Checkbox(hozza, C5Bounds);
    JCheckBox FingerYes;

    Integer[] C6Bounds = {1390,350,85,15};
    Checkbox C6 = new Checkbox(torol, C6Bounds);
    JCheckBox FingerNo;
    //------------------------------------------------------
    Integer[] C7Bounds = {1280, 460, 85, 15};
    Checkbox C7 = new Checkbox(hozza, C7Bounds);
    JCheckBox PhoneYes;

    Integer[] C8Bounds = {1390, 460, 85, 15};
    Checkbox C8 = new Checkbox(torol, C8Bounds);
    JCheckBox PhoneNo;
    //------------------------------------------------------
    Integer[] C9Bounds = {1280, 570, 85, 15};
    Checkbox C9 = new Checkbox(hozza, C9Bounds);
    JCheckBox MoveYes;

    Integer[] C10Bounds = {1390, 570, 85, 15};
    Checkbox C10 = new Checkbox(torol, C10Bounds);
    JCheckBox MoveNo;
    //------------------------------------------------------
    Integer[] C11Bounds = {1280, 680, 85, 15};
    Checkbox C11 = new Checkbox(hozza, C11Bounds);
    JCheckBox AlarmYes;

    Integer[] C12Bounds = {1390, 680, 85, 15};
    Checkbox C12 = new Checkbox(torol, C12Bounds);
    JCheckBox AlarmNo;

    //--------------------------------------------------------------------------------------------------------------------------------------------
    public Simulation(){
        SimFrame = new JFrame("Indításgátló");
        SimD = new SimulationDraw();

        ImageIcon motorsoundjobb = new ImageIcon("motorsound1.png");
        motorjobb = new JLabel();
        motorjobb.setIcon(motorsoundjobb);
        motorjobb.setEnabled(false);
        motorjobb.setBounds(1070,280, 48,90);
        motorjobb.setVisible(true);

        ImageIcon motorsoundbal = new ImageIcon("motorsound2.png");
        motorbal = new JLabel();
        motorbal.setIcon(motorsoundbal);
        motorbal.setEnabled(false);
        motorbal.setBounds(890,280, 48,90);
        motorbal.setVisible(true);
        //--------------------------------------------------------------------------------------------------------------------------------------------
        //######Gombok létrehozása#######
        gyujtas = IB.letrehoz();
        gyujtas.setBackground(Color.RED);
        gyujtas.addActionListener(this);
        gyujtas.setFont(new Font("Comis Sans", Font.BOLD, 16));

        inditas = SB.letrehoz();
        inditas.addActionListener(this);

        Integer BackToChoseBounds[] = {40, 740, 80, 40};
        SimBackButton BB = new SimBackButton("Vissza", BackToChoseBounds, "Vissza", false);

        //Kilépés gomb
        Integer BackToMenuBounds[] = {140, 740, 180, 40};
        SimBackToMenuButton BM = new SimBackToMenuButton("Vissza a menübe", BackToMenuBounds, "Vissza a menübe", false);
//--------------------------------------------------------------------------------------------------------------------------------------------
        //########Checkboxok létrehozása##########
        CodeYes = C1.letrehoz();
        CodeYes.addActionListener(this);
        CodeNo = C2.letrehoz();
        CodeNo.addActionListener(this);

        KeyYes = C3.letrehoz();
        KeyYes.addActionListener(this);
        KeyNo = C4.letrehoz();
        KeyNo.addActionListener(this);

        FingerYes = C5.letrehoz();
        FingerYes.addActionListener(this);
        FingerNo = C6.letrehoz();
        FingerNo.addActionListener(this);

        PhoneYes = C7.letrehoz();
        PhoneYes.addActionListener(this);
        PhoneNo = C8.letrehoz();
        PhoneNo.addActionListener(this);

        MoveYes = C9.letrehoz();
        MoveYes.addActionListener(this);
        MoveNo = C10.letrehoz();
        MoveNo.addActionListener(this);

        AlarmYes = C11.letrehoz();
        AlarmYes.addActionListener(this);
        AlarmNo = C12.letrehoz();
        AlarmNo.addActionListener(this);
//--------------------------------------------------------------------------------------------------------------------------------------------
        //###################################
        //###SZIMULÁCIÓS FRAME ÖSSZERAKÁSA###
        //###################################
        SimFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ha jobb felül az x-re kattintunk bezáródik az ablak, nem csak tálcázódik
        SimFrame.add(SimD);
        SimFrame.pack();
        SimFrame.setLayout(null);
        SimFrame.add(gyujtas);
        SimFrame.add(inditas);
        SimFrame.add(CodeYes);
        SimFrame.add(CodeNo);
        SimFrame.add(KeyYes);
        SimFrame.add(KeyNo);
        SimFrame.add(FingerYes);
        SimFrame.add(FingerNo);
        SimFrame.add(PhoneYes);
        SimFrame.add(PhoneNo);
        SimFrame.add(MoveYes);
        SimFrame.add(MoveNo);
        SimFrame.add(AlarmYes);
        SimFrame.add(AlarmNo);
        SimFrame.add(BB.letrehoz());
        SimFrame.add(BM.letrehoz());
        SimFrame.setLocationRelativeTo(null); //a képernyő középen fog megjelenni
        SimFrame.setVisible(true); //az ablak megjelenik
        SimFrame.add(motorjobb);
        SimFrame.add(motorbal);
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------
    public static void close(){SimFrame.dispose();}
    //--------------------------------------------------------------------------------------------------------------------------------------------
    public void actionPerformed(ActionEvent e){
        //Gyújtás gomb parancsok
        if(e.getSource()==gyujtas){
            Color piros = Color.RED;
            if (gyujtas.getBackground() == piros){
                gyujtas.setBackground(Color.GREEN);
            }else{
                gyujtas.setBackground(Color.RED);
                motorjobb.setEnabled(false);
                motorbal.setEnabled(false);
            }
        }
        //Indítás gomb parancsok
        if(e.getSource()==inditas){
            Color zold = Color.GREEN;
            if(gyujtas.getBackground() == zold){
                motorjobb.setEnabled(true);
                motorbal.setEnabled(true);
            }
        }
        //------------------------------------------------------
        //Chechbox parancsok
        if(e.getSource()==CodeYes){
            CodeNo.setSelected(false);
        }
        if(e.getSource()==CodeNo){
            CodeYes.setSelected(false);
        }
        //------------------------------------------------------
        if(e.getSource()==KeyYes){
            KeyNo.setSelected(false);
        }
        if(e.getSource()==KeyNo){
            KeyYes.setSelected(false);
        }
        //------------------------------------------------------
        if(e.getSource()==FingerYes){
            FingerNo.setSelected(false);
        }
        if(e.getSource()==FingerNo){
            FingerYes.setSelected(false);
        }
        //------------------------------------------------------
        if(e.getSource()==PhoneYes){
            PhoneNo.setSelected(false);
        }
        if(e.getSource()==PhoneNo){
            PhoneYes.setSelected(false);
        }
        //------------------------------------------------------
        if(e.getSource()==MoveYes){
            MoveNo.setSelected(false);
        }
        if(e.getSource()==MoveNo){
            MoveYes.setSelected(false);
        }
        //------------------------------------------------------
        if(e.getSource()==AlarmYes){
            AlarmNo.setSelected(false);
        }
        if(e.getSource()==AlarmNo){
            AlarmYes.setSelected(false);
        }
    }
}//end

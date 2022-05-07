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
import java.awt.geom.Area;

public class Simulation  extends JFrame implements ActionListener{
    private SimulationDraw SimD;//Panel
    String hozza = "Hozzáad";
    String torol = "Töröl";

    //Képek
    JLabel motorjobb;
    JLabel motorbal;
    JLabel alarmon;
    JLabel alarmoff;
    JLabel speedometer;
    JLabel keysensor;
    JLabel carkey;

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
        SimD = new SimulationDraw();

        //#############################################
        //####Gombra vagy checkboxra aktiváló képek####
        //#############################################
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

        //----------------------------------------------------------------------------------
        ImageIcon AlarmonImage = new ImageIcon("alarmon.png");
        alarmon = new JLabel();
        alarmon.setIcon(AlarmonImage);
        alarmon.setEnabled(false);
        alarmon.setBounds(130,100, 112,112);
        alarmon.setVisible(true);

        ImageIcon AlarmoffImage = new ImageIcon("alarmoff.png");
        alarmoff = new JLabel();
        alarmoff.setIcon(AlarmoffImage);
        alarmoff.setEnabled(false);
        alarmoff.setBounds(242,100, 112,112);
        alarmoff.setVisible(true);

        //----------------------------------------------------------------------------------

        ImageIcon SpeedometerImage = new ImageIcon("speedometer.png");
        speedometer = new JLabel();
        speedometer.setIcon(SpeedometerImage);
        speedometer.setEnabled(false);
        speedometer.setBounds(720, 95, 128, 128);
        speedometer.setVisible(true);

        //----------------------------------------------------------------------------------
        ImageIcon KeysensorImage = new ImageIcon("keysensor.png");
        keysensor = new JLabel();
        keysensor.setIcon(KeysensorImage);
        //keysensor.setEnabled(false);
        keysensor.setBounds(120, 600, 56,74);
        keysensor.setVisible(false);

        ImageIcon CarKeyImage = new ImageIcon("carkey.png");
        carkey = new JLabel();
        carkey.setIcon(CarKeyImage);
        //carkey.setEnabled(false);
        carkey.setBounds(250,500,60,100);
        carkey.setVisible(true);

        //----------------------------------------------------------------------------------




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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //this.setSize(1540,800);
        this.add(SimD);
        this.pack();
        this.setLayout(null);
        this.add(keysensor);
        this.add(gyujtas);
        this.add(inditas);
        this.add(BB.letrehoz());
        this.add(BM.letrehoz());
        this.add(CodeYes);
        this.add(CodeNo);
        this.add(KeyYes);
        this.add(KeyNo);
        this.add(FingerYes);
        this.add(FingerNo);
        this.add(PhoneYes);
        this.add(PhoneNo);
        this.add(MoveYes);
        this.add(MoveNo);
        this.add(AlarmYes);
        this.add(AlarmNo);
        this.add(motorjobb);
        this.add(motorbal);
        this.add(alarmon);
        this.add(alarmoff);
        this.add(speedometer);
        this.add(carkey);
        this.setLocationRelativeTo(null); //a képernyő középen fog megjelenni





    }
    //--------------------------------------------------------------------------------------------------------------------------------------------
    //public static void close(){SimFrame.dispose();}
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
                if(AlarmYes.isSelected()){
                alarmon.setEnabled(true);
                alarmoff.setEnabled(false);
                }
            }else{
                if (AlarmYes.isSelected()) {
                    alarmon.setEnabled(false);
                    alarmoff.setEnabled(true);
                }
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
            keysensor.setVisible(true);
            carkey.setVisible(true);
        }
        if(e.getSource()==KeyNo){
            KeyYes.setSelected(false);
            keysensor.setVisible(false);

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
            speedometer.setEnabled(true);
        }
        if(e.getSource()==MoveNo){
            MoveYes.setSelected(false);
            speedometer.setEnabled(false);
        }
        //------------------------------------------------------
        if(e.getSource()==AlarmYes){
            AlarmNo.setSelected(false);
            alarmon.setEnabled(true);
            alarmoff.setEnabled(false);
        }
        if(e.getSource()==AlarmNo){
            AlarmYes.setSelected(false);
            alarmon.setEnabled(false);
            alarmoff.setEnabled(false);
        }
    }
    public Boolean checkCollision(JLabel a, JLabel b){
        Area AreaA = new Area(a.getBounds());
        Area AreaB = new Area(b.getBounds());

        return AreaA.intersects(AreaB.getBounds2D());
    }

}//end

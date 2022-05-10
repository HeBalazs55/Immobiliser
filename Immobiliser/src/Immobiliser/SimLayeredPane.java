package Immobiliser;

import Buttons.SimCodeSubmitButton;
import Buttons.SimIgnitionButton;
import Buttons.SimPhoneSubmitButton;
import Buttons.SimStartButton;
import Checkboxes.Checkbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.*;

public class SimLayeredPane extends JLayeredPane implements ActionListener{
    final String Add = "Hozzáad";
    final String Delete = "Töröl";

    public static Integer[] Load = {0,0,0,0,0,0};
    public static void setLoad(Integer[] list){
        for(int i = 0; i<list.length; i++){
            Load[i] = list[i];
        }
    }
    public int WrongStart = 0;
    public int getWrongStart() {return WrongStart;}
    public void WrongStartPlusOne() {
    	WrongStart+=1;
    }
    public void WrongStartZero() {
    	WrongStart = 0;
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------
    JLabel Battery; JLabel Motor; JLabel Background; JLabel MotorRight; JLabel MotorLeft;

    File EngineSoundFile = new File("motorsound.wav");
    AudioInputStream EngineSoundStream;
    Clip clip;
    FloatControl gainControl;

    //--------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------
    JTextField CarCode; String carcodestring = ""; Integer carcodeint = 0; Boolean CodeDone = false;

    Integer[] CodeSubmitBounds = {440, 540, 60,20};
    SimCodeSubmitButton CSB = new SimCodeSubmitButton("Kód", CodeSubmitBounds, "Kód", false);
    JButton CodeSubmit;

    public Boolean getCarCode(int code) {
        return code == (1234);
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------
    JLabel CarKey; Boolean KeyDone = false;
    ImageIcon CarKeyImage = new ImageIcon("CarKey.png");
    Point KeyImageCorner;
    Point prevPt;

    JLabel KeySensor;
    //--------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------
    static JLabel Finger; static JLabel FingerPass; Boolean FingerDone = false;
    public static void setFinger(Boolean f){Finger.setVisible(f);}

    public static void setFingerPass(Boolean f){FingerPass.setVisible(f);}
    //--------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------
    JLabel Phone; Boolean PhoneDone = false;
    Integer[] PhoneSubmitBounds = {885, 655, 60,20};
    SimPhoneSubmitButton PSB = new SimPhoneSubmitButton("Jóváhagy", PhoneSubmitBounds, "Start", false);
    JButton PhoneSubmit;

    //--------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------
    JLabel Speedometer; Boolean SpeedDone = false;
    Timer SpeedTimer = new Timer();

    TimerTask SpeedTask = new TimerTask() {
        @Override
        public void run() {
            SpeedDone = true;
        }
    };

    //--------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------
    JLabel AlarmOn; JLabel AlarmOff;
    
    
    ArrayList<Boolean> EnabledList;
    ArrayList<Boolean> DoneList;


    //##################################################################################################################
    //################################################----BUTTONS----###################################################
    //##################################################################################################################
    //Gy�jt�s gomb deklar�l�sa
    Integer[] IgnitionBounds = {280, 275, 100, 40};
    SimIgnitionButton IB = new SimIgnitionButton("Gyújtás", IgnitionBounds, "Gyújtás", false);
    JButton gyujtas;

    //Ind�t�s gomb deklar�l�sa
    Integer[] StartBounds = {280, 335, 100, 40};
    SimStartButton SB = new SimStartButton("Indítás", StartBounds, "Start", false);
    JButton inditas;

    //--------------------------------------------------------------------------------------------------------------------------------------------
    //##################################################################################################################
    //##############################################----CHECKBOXOK----##################################################
    //##################################################################################################################
    Integer[] C1Bounds = {1280, 130 ,85 , 15};
    Checkboxes.Checkbox C1 = new Checkboxes.Checkbox(Add, C1Bounds);
    JCheckBox CodeYes;

    Integer[] C2Bounds = {1390, 130, 85, 15};
    Checkboxes.Checkbox C2 = new Checkboxes.Checkbox(Delete, C2Bounds);
    JCheckBox CodeNo;
    //------------------------------------------------------
    Integer[] C3Bounds = {1280, 240, 85, 15};
    Checkboxes.Checkbox C3 = new Checkboxes.Checkbox(Add, C3Bounds);
    JCheckBox KeyYes;
    Integer[] C4Bounds = {1390, 240, 85, 15};
    Checkboxes.Checkbox C4 = new Checkboxes.Checkbox(Delete, C4Bounds);
    JCheckBox KeyNo;
    //------------------------------------------------------
    Integer[] C5Bounds = {1280,350,85,15};
    Checkboxes.Checkbox C5 = new Checkboxes.Checkbox(Add, C5Bounds);
    JCheckBox FingerYes;

    Integer[] C6Bounds = {1390,350,85,15};
    Checkboxes.Checkbox C6 = new Checkboxes.Checkbox(Delete, C6Bounds);
    JCheckBox FingerNo;
    //------------------------------------------------------
    Integer[] C7Bounds = {1280, 460, 85, 15};
    Checkboxes.Checkbox C7 = new Checkboxes.Checkbox(Add, C7Bounds);
    JCheckBox PhoneYes;

    Integer[] C8Bounds = {1390, 460, 85, 15};
    Checkboxes.Checkbox C8 = new Checkboxes.Checkbox(Delete, C8Bounds);
    JCheckBox PhoneNo;
    //------------------------------------------------------
    Integer[] C9Bounds = {1280, 570, 85, 15};
    Checkboxes.Checkbox C9 = new Checkboxes.Checkbox(Add, C9Bounds);
    JCheckBox MoveYes;

    Integer[] C10Bounds = {1390, 570, 85, 15};
    Checkboxes.Checkbox C10 = new Checkboxes.Checkbox(Delete, C10Bounds);
    JCheckBox MoveNo;
    //------------------------------------------------------
    Integer[] C11Bounds = {1280, 680, 85, 15};
    Checkboxes.Checkbox C11 = new Checkboxes.Checkbox(Add, C11Bounds);
    JCheckBox AlarmYes;

    Integer[] C12Bounds = {1390, 680, 85, 15};
    Checkboxes.Checkbox C12 = new Checkbox(Delete, C12Bounds);
    JCheckBox AlarmNo;

    //##################################################################################################################
    //########################################----MAGA A LAYER DEKLARALASA----##########################################
    //##################################################################################################################
    SimLayeredPane(){
        //#################################
        //#############HATTER##############
        //#################################
        ImageIcon BackgroundImage = new ImageIcon("background.PNG");
        Background = new JLabel(BackgroundImage);
        Background.setOpaque(true);
        Background.setBounds(0, 0, 1530,800);
        Background.setVisible(true);

        ImageIcon MotorImage = new ImageIcon("engine.png");
        Motor = new JLabel(MotorImage);
        Motor.setOpaque(true);
        Motor.setBounds(930, 260, 144,144);
        Motor.setVisible(true);


        ImageIcon BatteryImage = new ImageIcon("battery.png");
        Battery = new JLabel(BatteryImage);
        Battery.setOpaque(true);
        Battery.setBounds(80, 265, 115,115);
        Battery.setVisible(true);


        //#############################################
        //####Gombra vagy checkboxra aktivalodo kepek####
        //#############################################
        ImageIcon motorsoundjobb = new ImageIcon("motorsound1.png");
        MotorRight = new JLabel(motorsoundjobb);
        MotorRight.setOpaque(true);
        MotorRight.setBounds(1070,280, 48,90);
        MotorRight.setVisible(false);

        ImageIcon motorsoundbal = new ImageIcon("motorsound2.png");
        MotorLeft = new JLabel(motorsoundbal);
        MotorLeft.setOpaque(true);
        MotorLeft.setBounds(890,280, 48,90);
        MotorLeft.setVisible(false);


        //----------------------------------------------------------------------------------
        CarCode = new JTextField();
        CarCode.setBounds(430,520,80,20);
        CarCode.setVisible(Load[0] != 0);


        CodeSubmit = CSB.letrehoz();
        CodeSubmit.setFont(new Font("Comic Sans", Font.BOLD, 10));
        CodeSubmit.addActionListener(this);
        CodeSubmit.setVisible(Load[0] != 0);


        //----------------------------------------------------------------------------------

        ImageIcon KeySensorImage = new ImageIcon("keysensor.png");
        KeySensor = new JLabel(KeySensorImage);
        KeySensor.setOpaque(true);
        KeySensor.setBounds(250,520,56,74);
        KeySensor.setVisible(false);
        KeySensor.setVisible(Load[1] != 0);

        CarKey = new JLabel(CarKeyImage);
        CarKey.setOpaque(true);
        CarKey.setBounds(120, 600, 60,100);
        CarKey.setVisible(false);
        CarKey.setVisible(Load[1] != 0);
        KeyImageCorner = new Point(0,0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();

        //----------------------------------------------------------------------------------

        ImageIcon PhoneImage = new ImageIcon("phone.png");
        Phone = new JLabel(PhoneImage);
        Phone.setOpaque(true);
        Phone.setBounds(850,520,125,223);
        Phone.setVisible(false);
        Phone.setVisible(Load[2] != 0);

        PhoneSubmit = PSB.letrehoz();
        PhoneSubmit.setFont(new Font("Comic Sans", Font.BOLD, 10));
        PhoneSubmit.addActionListener(this);
        PhoneSubmit.setVisible(false);
        PhoneSubmit.setVisible(Load[2] != 0);

        //----------------------------------------------------------------------------------

        ImageIcon FingerImage = new ImageIcon("finger.png");
        Finger = new JLabel(FingerImage);
        Finger.setOpaque(true);
        Finger.setBounds(630,520,64,64);
        Finger.setVisible(false);
        Finger.setVisible(Load[3] != 0);

        ImageIcon FingerImagePass = new ImageIcon("fingerpass.png");
        FingerPass = new JLabel(FingerImagePass);
        FingerPass.setOpaque(true);
        FingerPass.setBounds(630,520,66,66);
        FingerPass.setVisible(false);
        FingerPass.setVisible(Load[3] != 0);

        //----------------------------------------------------------------------------------

        ImageIcon SpeedometerImage = new ImageIcon("Speedometer.png");
        Speedometer = new JLabel(SpeedometerImage);
        Speedometer.setOpaque(true);
        Speedometer.setBounds(720, 95, 128, 128);
        Speedometer.setVisible(false);
        Speedometer.setVisible(Load[4] != 0);


        //----------------------------------------------------------------------------------
        ImageIcon AlarmOnImage = new ImageIcon("AlarmOn.png");
        AlarmOn = new JLabel(AlarmOnImage);
        AlarmOn.setOpaque(true);
        AlarmOn.setEnabled(false);
        AlarmOn.setBounds(130,100, 112,112);
        AlarmOn.setVisible(false);
        AlarmOn.setVisible(Load[5] != 0);

        ImageIcon AlarmOffImage = new ImageIcon("AlarmOff.png");
        AlarmOff = new JLabel(AlarmOffImage);
        AlarmOff.setOpaque(true);
        AlarmOff.setEnabled(false);
        AlarmOff.setBounds(242,100, 112,112);
        AlarmOff.setVisible(false);
        AlarmOff.setVisible(Load[5] != 0);

//--------------------------------------------------------------------------------------------------------------------------------------------

        //######Gombok letrehozasa#######
        gyujtas = IB.letrehoz();
        gyujtas.setBackground(Color.RED);
        gyujtas.addActionListener(this);
        gyujtas.setFont(new Font("Comic Sans", Font.BOLD, 16));

        inditas = SB.letrehoz();
        inditas.addActionListener(this);

//--------------------------------------------------------------------------------------------------------------------------------------------
        //########Checkboxok letrehozasa##########
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

        //##################################################################################################################
        //################################----OBJECTEK HOZZAADASA A LAYEREDPANE-HEZ----#####################################
        //##################################################################################################################
        this.add(Background, JLayeredPane.DEFAULT_LAYER);
        this.add(Battery, JLayeredPane.PALETTE_LAYER);
        this.add(Motor, JLayeredPane.PALETTE_LAYER);
        this.add(gyujtas, JLayeredPane.PALETTE_LAYER);
        this.add(inditas, JLayeredPane.PALETTE_LAYER);
        this.add(CodeSubmit, JLayeredPane.PALETTE_LAYER);

        //-------Checkboxok hozzaadasa a LayeredPane-hez---------
        this.add(CodeYes, JLayeredPane.PALETTE_LAYER);
        this.add(CodeNo, JLayeredPane.PALETTE_LAYER);
        this.add(KeyYes, JLayeredPane.PALETTE_LAYER);
        this.add(KeyNo, JLayeredPane.PALETTE_LAYER);
        this.add(FingerYes, JLayeredPane.PALETTE_LAYER);
        this.add(FingerNo, JLayeredPane.PALETTE_LAYER);
        this.add(PhoneYes, JLayeredPane.PALETTE_LAYER);
        this.add(PhoneNo, JLayeredPane.PALETTE_LAYER);
        this.add(MoveYes, JLayeredPane.PALETTE_LAYER);
        this.add(MoveNo, JLayeredPane.PALETTE_LAYER);
        this.add(AlarmYes, JLayeredPane.PALETTE_LAYER);
        this.add(AlarmNo, JLayeredPane.PALETTE_LAYER);
        this.add(MotorRight, JLayeredPane.PALETTE_LAYER);
        this.add(MotorLeft, JLayeredPane.PALETTE_LAYER);

        //-------Kepek hozzaadasa a LayeredPane-hez------------
        this.add(CarCode, JLayeredPane.PALETTE_LAYER);
        this.add(PhoneSubmit, JLayeredPane.PALETTE_LAYER);
        this.add(Finger, JLayeredPane.PALETTE_LAYER);
        this.add(FingerPass, JLayeredPane.PALETTE_LAYER);
        this.add(Phone, JLayeredPane.PALETTE_LAYER);
        this.add(KeySensor,JLayeredPane.MODAL_LAYER);
        this.add(CarKey, JLayeredPane.DRAG_LAYER);
        this.add(Speedometer, JLayeredPane.PALETTE_LAYER);
        this.add(AlarmOn, JLayeredPane.PALETTE_LAYER);
        this.add(AlarmOff, JLayeredPane.PALETTE_LAYER);
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);


        EnabledList = new ArrayList<>();
        DoneList = new ArrayList<>();

    }
    private void playSound(){
        {
            try {
                EngineSoundStream = AudioSystem.getAudioInputStream(EngineSoundFile);
            } catch (UnsupportedAudioFileException e) {
                System.err.println("Hibás audio fájl formátum!");
            } catch (IOException e) {
                e.getMessage();
            }
        }
        {
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException e) {
                System.err.println("Nem lehet elérni az audio fájlt");
            }
        }
        try {
            clip.open(EngineSoundStream);
        } catch (LineUnavailableException e) {
            System.err.println("Nem lehet elérni az audio fájlt");
        } catch (IOException e) {
            System.err.println("A fájlt nem lehet lejátszani! Nincs hangszóró!");
        }
        gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-15.0f);
        clip.start();
    }

    private class ClickListener extends MouseAdapter {

        public void mousePressed(MouseEvent e){
            prevPt = e.getPoint();
        }
    }
    private class DragListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e){
            Point currentPt = e.getPoint();
            KeyImageCorner.translate(
                    (int)(currentPt.getX()-prevPt.getX()),
                    (int)(currentPt.getY()-prevPt.getY())
            );
            prevPt = currentPt;
            CarKey.setLocation(e.getPoint().x, e.getPoint().y);
        }
    }

    //##################################################################################################################
    //#############################################----ACTION PERFORMER----#############################################
    //##################################################################################################################
    public void actionPerformed(ActionEvent e){
        //Gyujtas gomb parancsok
        if(e.getSource()==gyujtas){
            Color piros = Color.RED;
            if(gyujtas.getBackground() == piros){
                gyujtas.setBackground(Color.GREEN);

                if(FingerPass.isVisible()){
                    FingerDone = true;
                }
                if(checkCollision(CarKey, KeySensor)){
                    KeyDone = true;
                }
                EnabledList.add(CarCode.isVisible());
                EnabledList.add(CarKey.isVisible());
                EnabledList.add(FingerPass.isVisible());
                EnabledList.add(Phone.isVisible());
                EnabledList.add(Speedometer.isVisible());

                DoneList.add(CodeDone);
                DoneList.add(KeyDone);
                DoneList.add(FingerDone);
                DoneList.add(PhoneDone);
                DoneList.add(SpeedDone);

            }else{
                gyujtas.setBackground(Color.RED);
                MotorRight.setVisible(false);
                MotorLeft.setVisible(false);
                CodeDone = false; KeyDone = false; FingerDone = false; PhoneDone = false; SpeedDone = false;
                EnabledList.clear();
                DoneList.clear();
            }
        }
        //Inditas gomb parancsok
        if(e.getSource()==inditas){
            Color zold = Color.GREEN;
            //Ha zold
            if(gyujtas.getBackground() == zold) {
                if(EnabledList.equals(DoneList)){
                    AlarmOn.setEnabled(true);
                    AlarmOff.setEnabled(false);
                	WrongStartZero();
                    MotorLeft.setVisible(true);
                    MotorRight.setVisible(true);
                    playSound();
                }
                WrongStartPlusOne();
                if(getWrongStart()>3 && AlarmOn.isVisible()) {
                	AlarmOn.setEnabled(false);
                	AlarmOff.setEnabled(true);
                }
            }
        }
        //A feladatok gombjai
        if(e.getSource()==CodeSubmit){
            carcodestring = CarCode.getText();
            carcodeint = Integer.parseInt(carcodestring);
            if(getCarCode(carcodeint)){CodeDone = true; CarCode.setEditable(false);}
        }
        if(e.getSource()==PhoneSubmit){
            PhoneDone = true;
        }
        //------------------------------------------------------
        //Chechbox parancsok
        if(e.getSource()==CodeYes){
            CodeNo.setSelected(false);
            CarCode.setVisible(true);
            CodeSubmit.setVisible(true);
        }
        if(e.getSource()==CodeNo){
            CodeYes.setSelected(false);
            CarCode.setVisible(false);
            CodeSubmit.setVisible(false);
            CodeDone = false;
        }
        //------------------------------------------------------
        if(e.getSource()==KeyYes){
            KeyNo.setSelected(false);
            KeySensor.setVisible(true);
            CarKey.setVisible(true);
            CarKey.setBounds(120, 600, 60,100);
        }
        if(e.getSource()==KeyNo){
            KeyYes.setSelected(false);
            KeySensor.setVisible(false);
            CarKey.setVisible(false);
            KeyDone = false;
        }
        //------------------------------------------------------
        if(e.getSource()==FingerYes){
            FingerNo.setSelected(false);
            Finger.setVisible(true);
        }
        if(e.getSource()==FingerNo){
            FingerYes.setSelected(false);
            Finger.setVisible(false);
            FingerPass.setVisible(false);
            FingerDone = false;
        }
        //------------------------------------------------------
        if(e.getSource()==PhoneYes){
            PhoneNo.setSelected(false);
            Phone.setVisible(true);
            PhoneSubmit.setVisible(true);
        }
        if(e.getSource()==PhoneNo){
            PhoneYes.setSelected(false);
            Phone.setVisible(false);
            PhoneSubmit.setVisible(false);
            PhoneDone = false;
        }
        //------------------------------------------------------
        if(e.getSource()==MoveYes){
            MoveNo.setSelected(false);
            Speedometer.setVisible(true);
            SpeedTimer.schedule(SpeedTask, 5*1000);
        }
        if(e.getSource()==MoveNo){
            MoveYes.setSelected(false);
            Speedometer.setVisible(false);
            SpeedTimer.purge();
            SpeedDone = false;
        }
        //------------------------------------------------------
        if(e.getSource()==AlarmYes){
            AlarmNo.setSelected(false);
            AlarmOn.setVisible(true);
            AlarmOff.setVisible(true);
            AlarmOn.setEnabled(true);
            AlarmOff.setEnabled(false);
        }
        if(e.getSource()==AlarmNo){
            AlarmYes.setSelected(false);
            AlarmOn.setVisible(false);
            AlarmOff.setVisible(false);
            AlarmOn.setEnabled(false);
            AlarmOff.setEnabled(false);
        }
    }
    public Boolean checkCollision(JLabel a, JLabel b){
        Area AreaA = new Area(a.getBounds());
        Area AreaB = new Area(b.getBounds());
        return AreaA.intersects(AreaB.getBounds2D());
    }

}//end
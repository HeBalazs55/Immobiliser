package Immobiliser;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SimulationDraw extends JPanel{
    protected Boolean motorindul = false;
    Image battery;
    Image engine;

    SimulationDraw(){

        battery = new ImageIcon("battery.png").getImage();
        engine = new ImageIcon("engine.png").getImage();
        this.setPreferredSize(new Dimension(1920,1080)); //szélesség-hosszúság
    }
    public void setMotorIndul(Boolean f){motorindul = f;}
    public void paint(Graphics g){
        Graphics2D toll = (Graphics2D) g;

        //---------------Keret létrehozása---------------
        toll.setBackground(Color.WHITE);
        toll.setStroke(new BasicStroke(5));
        toll.setPaint(Color.BLACK);
        //  x,  y, széles,magas, görbítések
        toll.drawRoundRect(10, 10, 1510, 780, 50, 50);
        //--------------------Rajzok---------------------
        toll.drawLine(120, 325, 950, 325);
        toll.drawLine(1200, 10, 1200,790);
        toll.drawLine(1200,70,1520 ,70);

        //-------------Gyújtás és Indítás gomb keret---------------
        toll.drawRoundRect(270, 255, 120, 140, 50, 50);

        //--------------------Rajzok---------------------
        toll.drawLine(120, 325, 950, 325);
        toll.drawLine(1200, 10, 1200,790);
        toll.drawLine(1200,70,1520 ,70);


        //------------Ikonok beillesztése----------------
        toll.drawImage(battery, 80, 265, null);
        toll.drawImage(engine, 930, 260, null);

        //Menu checkbox szövegek
        toll.setFont(new Font("Comic Sans", Font.BOLD, 35));
        toll.drawString("Komponensek", 1245, 55);

        toll.setFont(new Font("Comic Sans", Font.BOLD, 25));
        toll.drawString("Számkód", 1305, 110);

        toll.setFont(new Font("Comic Sans", Font.BOLD, 25));
        toll.drawString("Kulcs érzékelő", 1275, 220);

        toll.setFont(new Font("Comic Sans", Font.BOLD, 25));
        toll.drawString("Ujjlenyomat érzékelő", 1235, 330);

        toll.setFont(new Font("Comic Sans", Font.BOLD, 25));
        toll.drawString("Telefonos jóváhagyás", 1230, 440);

        toll.setFont(new Font("Comic Sans", Font.BOLD, 25));
        toll.drawString("Mozgásérzékelő", 1265, 550);

        toll.setFont(new Font("Comic Sans", Font.BOLD, 25));
        toll.drawString("Riasztó", 1315, 660);

        //----------------Motor indul--------------------
        if(motorindul) {
            toll.drawLine(925, 235, 905, 210); //balra 2. vonal
            toll.drawLine(965, 235, 945, 190); //balra 1. vonal
            toll.drawLine(1005, 235, 1005, 170); //Középső vonal
            toll.drawLine(1045, 235, 1065, 190); //jobra 1. vonal
            toll.drawLine(1085, 235, 1105, 210); //jobra 2. vonal
        }
    }
}//end

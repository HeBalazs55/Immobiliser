package Immobiliser;

import java.awt.Image;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SimulationDraw extends JPanel{
    Image battery;
    Image engine;

    SimulationDraw(){

        battery = new ImageIcon("battery.png").getImage();
        engine = new ImageIcon("engine.png").getImage();
        this.setPreferredSize(new Dimension(1920,1080)); //szélesség-hosszúság
    }
    public void paint(Graphics g){
        Graphics2D toll = (Graphics2D) g;

        //---------------Keret létrehozása---------------
        toll.setBackground(Color.WHITE);
        toll.setStroke(new BasicStroke(5));
        toll.setPaint(Color.BLACK);
        //  x,  y, széles,magas, görbítések
        toll.drawRoundRect(10, 10, 1510, 780, 50, 50);
        //--------------------Rajzok---------------------
        toll.drawLine(120, 360, 910, 360);

        //------------Ikonok beillesztése----------------
        toll.drawImage(battery, 100, 300, null);
        toll.drawImage(engine, 930, 260, null);

        //----------------Motor indul--------------------
        if(true){
            //x1,y1,x2,y2
            toll.drawLine(925, 235, 905, 210); //balra 2.
            toll.drawLine(965, 235, 945, 190); //balra 1.
            toll.drawLine(1005, 235, 1005, 170); //Középső
            toll.drawLine(1045, 235, 1065, 190); //jobra 1.
            toll.drawLine(1085, 235, 1105, 210); //jobra 2.
        }

    }
}//end

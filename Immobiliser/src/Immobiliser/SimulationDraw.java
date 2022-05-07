package Immobiliser;

import java.awt.*;
import javax.swing.*;

public class SimulationDraw extends JPanel{
    Image battery;
    Image engine;

    SimulationDraw(){
        this.setPreferredSize(new Dimension(1540,800)); //szélesség-hosszúság
    }

    public void paint(Graphics g){
        Graphics2D toll = (Graphics2D) g;

        //---------------Keret létrehozása------------------------------------------------------------------------------
        toll.setBackground(Color.WHITE);
        toll.setStroke(new BasicStroke(5));
        toll.setPaint(Color.BLACK);
        //  x,  y, széles,magas, görbítések
        toll.drawRoundRect(10, 10, 1510, 780, 50, 50);

        //--------------------Vonalak-----------------------------------------------------------------------------------
        toll.drawLine(120, 325, 887, 325); //battery----motor összekötő
        toll.drawLine(1200, 10, 1200,790); //jobb oldali menü cím elválasztó
        toll.drawLine(1200, 70, 1520,70); //jobb oldali menő elválasztó
        toll.drawLine(450 , 325, 450, 155); //függőleges riasztó vonal
        toll.drawLine(355, 155, 450, 155); //vízszintes riasztó vonal
        toll.drawLine(550, 325, 550, 160); //függőleges speedometer vonal
        toll.drawLine(550,160,715,160); //vízszintes speedometer vonal

        //-------------Gyújtás és Indítás gomb keret--------------------------------------------------------------------
        toll.drawRoundRect(270, 255, 120, 140, 50, 50);


        //------------Ikonok beillesztése-------------------------------------------------------------------------------
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
    }

}//end

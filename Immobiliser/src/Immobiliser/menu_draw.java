package Immobiliser;

import java.awt.*;
import javax.swing.*;

public class menu_draw extends JPanel{

    menu_draw(){

        this.setPreferredSize(new Dimension(1920,1080)); //szélesség-hosszúság
    }


    public void paint(Graphics g){
        Graphics2D toll = (Graphics2D) g;

        //---------------Keret létrehozása---------------
        toll.setStroke(new BasicStroke(5));
        //  x,  y, széles,magas, görbítések
        toll.drawRoundRect(615, 95, 300, 500, 50, 50);

        //--------------------Szövegek--------------------------------------
        toll.setPaint(Color.blue);
        toll.setFont(new Font("Comic Sans", Font.BOLD, 25));
        toll.drawString("Gépjármű indításgátló ", 635, 145);
        toll.drawString("szimuláció", 700, 170);//65-el beljebb, 25-el lejjebb

        toll.setPaint(Color.black);
        toll.setFont(new Font("Comic Sans", Font.BOLD, 10));
        toll.drawString("Készítette: Hegyi Balázs", 0, 790);


    }

}//vége

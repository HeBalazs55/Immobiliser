package Immobiliser;

import java.awt.*;
import javax.swing.*;

public class MenuDraw extends JPanel{

    MenuDraw(){

        this.setPreferredSize(new Dimension(1540,800)); //Width-Height
    }

    public void paint(Graphics g){
        Graphics2D toll = (Graphics2D) g;

        //---------------Menu RoundRect---------------
        toll.setStroke(new BasicStroke(5));
        toll.drawRoundRect(615, 95, 300, 500, 50, 50);

        //--------------------Strings--------------------------------------
        toll.setPaint(Color.blue);
        toll.setFont(new Font("Comic Sans", Font.BOLD, 25));
        toll.drawString("Gépjármű indításgátló ", 635, 145);
        toll.drawString("szimuláció", 700, 170);

        toll.setPaint(Color.black);
        toll.setFont(new Font("Comic Sans", Font.BOLD, 10));
        toll.drawString("Készítette: Hegyi Balázs", 0, 790);


    }

}//end

package Immobiliser;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import javax.swing.JPanel;

public class ChoseDraw extends JPanel{

    ChoseDraw(){
        this.setPreferredSize(new Dimension(1920,1080)); //szélesség-hosszúság
    }
    public void paint(Graphics g){
        Graphics2D toll = (Graphics2D) g;

        toll.setStroke(new BasicStroke(5));
        //x,y,szélesség,magasság,görbítések
        toll.drawRoundRect(475, 25, 600, 650, 50, 50);
    }
}//end

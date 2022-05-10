package Immobiliser;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import javax.swing.JPanel;

public class ChoseDraw extends JPanel{

    ChoseDraw(){
        this.setPreferredSize(new Dimension(1540,800));} //Width-Height
    public void paint(Graphics g){
        Graphics2D toll = (Graphics2D) g;
        toll.setStroke(new BasicStroke(5));
        toll.drawRoundRect(475, 25, 600, 650, 50, 50);
    }
}//end

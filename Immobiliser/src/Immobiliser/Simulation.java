package Immobiliser;

import Buttons.SimBackButton;
import Buttons.SimBackToMenuButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Simulation  extends JFrame implements ActionListener , KeyListener {

    SimLayeredPane SimLP;

    final String hozza = "Hozzáad";
    final String torol = "Töröl";

    Integer[] BackToChoseBounds = {40, 740, 80, 40};
    SimBackButton BB = new SimBackButton("Vissza", BackToChoseBounds, "Vissza", false);
    JButton visszavalasztani;

    Integer[] BackToMenuBounds = {140, 740, 180, 40};
    SimBackToMenuButton BM = new SimBackToMenuButton("Vissza a menübe", BackToMenuBounds, "Vissza a menübe", false);
    JButton visszaamenube;
    //--------------------------------------------------------------------------------------------------------------------------------------------
    public Simulation(){
        //SimD = new SimulationDraw();
        SimLP = new SimLayeredPane();

        visszavalasztani = BB.letrehoz();
        visszavalasztani.addActionListener(this);
        visszavalasztani.setFont(new Font("Comis Sans", Font.BOLD, 14));

        visszaamenube = BM.letrehoz();
        visszaamenube.addActionListener(this);
        visszaamenube.setFont(new Font("Comic Sans",Font.BOLD, 14));

        SimLP.add(visszavalasztani,JLayeredPane.PALETTE_LAYER);
        SimLP.add(visszaamenube, JLayeredPane.PALETTE_LAYER);

//--------------------------------------------------------------------------------------------------------------------------------------------
        //###################################
        //###SZIMULÁCIÓS FRAME ÖSSZERAKÁSA###
        //###################################

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(SimLP);
        this.addKeyListener(this);

        this.setSize(1550,840);
        this.setLocationRelativeTo(null); //a képernyő középen fog megjelenni
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------
    public void close(){dispose();}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == visszavalasztani) {
            close();
            new Chose();
        }
        if (e.getSource() == visszaamenube) {
            close();
            new Menu();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'f': SimLayeredPane.setFinger(false);
            SimLayeredPane.setFingerPass(true);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}//end

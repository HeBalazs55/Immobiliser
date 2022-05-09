package Immobiliser;

import Buttons.SimBackButton;
import Buttons.SimBackToMenuButton;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Simulation  extends JFrame implements ActionListener , KeyListener {
    SimLayeredPane SimLP;
    Integer[] BackToChoseBounds = {40, 740, 80, 40};
    SimBackButton BB = new SimBackButton("Vissza", BackToChoseBounds, "Vissza", false);
    JButton BackToChose;

    Integer[] BackToMenuBounds = {140, 740, 180, 40};
    SimBackToMenuButton BM = new SimBackToMenuButton("Vissza a menübe", BackToMenuBounds, "Vissza a menübe", false);
    JButton BackToMenu;
    //--------------------------------------------------------------------------------------------------------------------------------------------
    
    public Simulation(){
        //A Layered Pane példányosítása ami a Simulation Frame-re fog kerülni.
        SimLP = new SimLayeredPane();

        //Vissza a Menübe és Vissza választani gombok deklarálása
        BackToChose = BB.letrehoz();
        BackToChose.addActionListener(this);
        BackToChose.setFont(new Font("Comis Sans", Font.BOLD, 14));

        BackToMenu = BM.letrehoz();
        BackToMenu.addActionListener(this);
        BackToMenu.setFont(new Font("Comic Sans",Font.BOLD, 14));

        //A gombok hozzá adása a SimLP Layered Pane-hez
        SimLP.add(BackToChose,JLayeredPane.PALETTE_LAYER);
        SimLP.add(BackToMenu, JLayeredPane.PALETTE_LAYER);

//--------------------------------------------------------------------------------------------------------------------------------------------
        //#########################################################################
        //##################----SZIMULÁCIÓS FRAME ÖSSZERAKÁSA----##################
        //#########################################################################
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(SimLP);
        this.addKeyListener(this);
        this.setSize(1550,840);
        this.setLocationRelativeTo(null); //a képernyő középen fog megjelenni
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------
    //A Simulation Framet bezáró parancs
    public void close(){dispose();}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BackToChose) {
            close();
            new Chose();
        }
        if (e.getSource() == BackToMenu) {
            close();
            new Menu();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()=='f'){
            SimLayeredPane.setFinger(false);
            SimLayeredPane.setFingerPass(true);
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}//end

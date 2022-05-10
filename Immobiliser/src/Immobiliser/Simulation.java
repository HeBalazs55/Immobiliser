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
        //Create the Layered Pane witch we add to the Frame
        SimLP = new SimLayeredPane();

        //Back to Menu and Back to Chose buttons
        BackToChose = BB.letrehoz();
        BackToChose.addActionListener(this);
        BackToChose.setFont(new Font("Comis Sans", Font.BOLD, 14));

        BackToMenu = BM.letrehoz();
        BackToMenu.addActionListener(this);
        BackToMenu.setFont(new Font("Comic Sans",Font.BOLD, 14));

        //Add the buttons to the SimLP
        SimLP.add(BackToChose,JLayeredPane.PALETTE_LAYER);
        SimLP.add(BackToMenu, JLayeredPane.PALETTE_LAYER);

//--------------------------------------------------------------------------------------------------------------------------------------------
        //#########################################################################
        //######################----SIMULATION FRAME BUILD----#####################
        //#########################################################################
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Indításgátló");
        this.setVisible(true);
        this.add(SimLP);
        this.addKeyListener(this);
        this.setSize(1550,840);
        this.setLocationRelativeTo(null); //It will appear in the middle of the screen
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BackToChose) {
            dispose();
            new Chose();
        }
        if (e.getSource() == BackToMenu) {
            dispose();
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

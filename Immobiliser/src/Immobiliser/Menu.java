package Immobiliser;

import Buttons.MenuExitButton;
import Buttons.MenuStartButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    //Start gomb
    Integer[] b1bounds = {680,250,175,75};
    MenuStartButton B1 = new MenuStartButton("Start", b1bounds, "Szimulálás", false);
    JButton SB = B1.letrehoz();

    //Exit b
    Integer[] b2bounds = {680,400,175,75};
    MenuExitButton B2 = new MenuExitButton("Exit", b2bounds, "Kilépés", false);
    JButton EB = B2.letrehoz();
    //--------------------------------------------------------------------------------------------------------------------------------------------
    public Menu(){
        //Menu JFrame components
        MenuDraw MenuD = new MenuDraw();
        SB.addActionListener(this);
        EB.addActionListener(this);
        //#########################################################################
        //######################----MENU FRAME BUILD----#####################
        //#########################################################################
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//If we clicked 
        this.setTitle("Indításgátló");
        this.add(MenuD);
        this.pack();
        this.setLayout(null);
        this.add(SB);
        this.add(EB);
        this.setLocationRelativeTo(null); //The windows will be appear in the middle of the screen
        this.setVisible(true); //The windows will be visible
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==SB){new Chose(); dispose();}
        if(e.getSource()==EB){System.exit(0);}
    }

}//end

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

    //Kilépés gomb
    Integer[] b2bounds = {680,400,175,75};
    MenuExitButton B2 = new MenuExitButton("Exit", b2bounds, "Kilépés", false);
    JButton EB = B2.letrehoz();
    //--------------------------------------------------------------------------------------------------------------------------------------------
    public Menu(){
        //A menü megrajzolásához tartozó JPanel példányosítása
        MenuDraw MenuD = new MenuDraw();
        SB.addActionListener(this);
        EB.addActionListener(this);
        //#########################################################################
        //######################----MENÜ FRAME ÖSSZERAKÁSA----#####################
        //#########################################################################
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ha jobb felül az x-re kattintunk bezáródik az ablak, nem csak tálcázódik
        this.setTitle("Indításgátló");
        this.add(MenuD);
        this.pack();
        this.setLayout(null);
        this.add(SB);
        this.add(EB);
        this.setLocationRelativeTo(null); //az ablak középen fog megjelenni
        this.setVisible(true); //az ablak megjelenik
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------
    public void close(){dispose();}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==SB){new Chose(); close();}
        if(e.getSource()==EB){close(); System.exit(0);}
    }

}//end

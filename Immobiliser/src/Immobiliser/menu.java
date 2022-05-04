package Immobiliser;

import javax.swing.*;

public class menu{
    menu_draw MenuR;
    static JFrame MenuFrame;

    menu(){
        MenuFrame = new JFrame("Indításgátló");
        MenuR = new menu_draw();

        MenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ha jobb felül az x-re kattintunk bezáródik az ablak, nem csak tálcázódik
        MenuFrame.add(MenuR);
        MenuFrame.pack();
        MenuFrame.setLayout(null);
        //this.setSize(400,500);
        MenuFrame.add(buttons.START());
        MenuFrame.add(buttons.KILEPES());
        MenuFrame.setLocationRelativeTo(null); //az ablak középen fog megjelenni
        MenuFrame.setVisible(true); //az ablak megjelenik
    }
    public static void close(){MenuFrame.dispose();}
}

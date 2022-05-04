package Immobiliser;


import javax.swing.*;

public class Menu {
    MenuDraw MenuR;
    static JFrame MenuFrame;

    Menu(){
        MenuFrame = new JFrame("Indításgátló");
        MenuR = new MenuDraw();

        MenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ha jobb felül az x-re kattintunk bezáródik az ablak, nem csak tálcázódik
        MenuFrame.add(MenuR);
        MenuFrame.pack();
        MenuFrame.setLayout(null);
        //this.setSize(400,500);
        MenuFrame.add(Buttons.START());
        MenuFrame.add(Buttons.KILEPES());
        MenuFrame.setLocationRelativeTo(null); //az ablak középen fog megjelenni
        MenuFrame.setVisible(true); //az ablak megjelenik
    }
    public static void close(){MenuFrame.dispose();}
}//end

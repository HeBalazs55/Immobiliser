package Immobiliser;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu implements ActionListener {
    MenuDraw MenuR;
    static JFrame MenuFrame;
    Buttons b1;
    Buttons b2;
    JButton b1b;
    JButton b2b;


    Menu(){
        MenuFrame = new JFrame("Indításgátló");
        MenuR = new MenuDraw();

        //Szimulálás gomb
        Integer b1bounds[] = {680,250,175,75};
        b1 = new Buttons("Szimulálás", b1bounds, "Szimulálás", false);

        //Kilépés gomb
        Integer b2bounds[] = {680,400,175,75};
        b2 = new Buttons("Exit", b2bounds, "Kilépés", false);

        MenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ha jobb felül az x-re kattintunk bezáródik az ablak, nem csak tálcázódik
        MenuFrame.add(MenuR);
        MenuFrame.pack();
        MenuFrame.setLayout(null);
        MenuFrame.add(b1.letrehoz());
        MenuFrame.add(b2.letrehoz());
        //MenuFrame.add(StaticButtons.START());
        //MenuFrame.add(StaticButtons.KILEPES());
        MenuFrame.setLocationRelativeTo(null); //az ablak középen fog megjelenni
        MenuFrame.setVisible(true); //az ablak megjelenik

        b2b = b2.letrehoz();
    }
    public static void close(){MenuFrame.dispose();}

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            close(); new Chose();
        }
        if(e.getSource() == b2b){
            System.exit(0);
        }
    }
}//end

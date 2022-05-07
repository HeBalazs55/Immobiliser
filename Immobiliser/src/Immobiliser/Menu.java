package Immobiliser;

import Buttons.MenuExitButton;
import Buttons.MenuStartButton;

import javax.swing.JFrame;

public class Menu{
    static JFrame MenuFrame;
    /*
  Azért kell itt statikusan létre hozni, mert így lehet
  elérhetővé tenni a program bezárását máshonnan.
     */


    public Menu(){
        MenuFrame = new JFrame("Indításgátló");
        MenuDraw MenuR = new MenuDraw();

        //Start gomb
        Integer b1bounds[] = {680,250,175,75};
        MenuStartButton B1 = new MenuStartButton("Start", b1bounds, "Szimulálás", false);

        //Kilépés gomb
        Integer b2bounds[] = {680,400,175,75};
        MenuExitButton B2 = new MenuExitButton("Exit", b2bounds, "Kilépés", false);

        MenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ha jobb felül az x-re kattintunk bezáródik az ablak, nem csak tálcázódik
        MenuFrame.add(MenuR);
        MenuFrame.pack();
        MenuFrame.setLayout(null);
        MenuFrame.add(B1.letrehoz());
        MenuFrame.add(B2.letrehoz());
        MenuFrame.setLocationRelativeTo(null); //az ablak középen fog megjelenni
        MenuFrame.setVisible(true); //az ablak megjelenik

    }
    public static void close(){MenuFrame.dispose();}
}//end

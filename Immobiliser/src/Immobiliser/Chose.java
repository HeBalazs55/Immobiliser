package Immobiliser;

import Buttons.*;

import javax.swing.JFrame;

public class Chose {
    ChoseDraw ChoseDraw;
    static JFrame ChoseFrame;

    public Chose(){
        ChoseFrame = new JFrame("Indításgátló");
        ChoseDraw = new ChoseDraw();

        //---------GOMBOK------------
        //----Előre összeállított szim. indítása gomb
        Integer Startbounds[] = {810, 210, 110, 50};
        ChoseStartButton SB = new ChoseStartButton("Indítás", Startbounds, "Indítás", false);

        //----Saját szim. összeállítása gomb
        Integer OwnStartbounds[] = {660, 480, 200, 100};
        ChoseOwnButton OB = new ChoseOwnButton("Sajat", OwnStartbounds, "<html>Saját virtualizáció<br />összeállítása</html>", false);

        //----Vissza lépés a menübe gomb
        Integer BackToMenuBounds[] = {510, 615, 80, 40};
        ChoseBackButton BB = new ChoseBackButton("Vissza", BackToMenuBounds, "Vissza", false);

        //Választás Frame összerakása
        ChoseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ha jobb felül az x-re kattintunk bezáródik az ablak, nem csak tálcázódik
        ChoseFrame.add(ChoseDraw);
        ChoseFrame.pack();
        ChoseFrame.setLayout(null);
        ChoseFrame.add(SB.letrehoz());
        ChoseFrame.add(OB.letrehoz());
        ChoseFrame.add(BB.letrehoz());
        ChoseFrame.add(Checkboxes.C1());
        ChoseFrame.add(Checkboxes.C2());
        ChoseFrame.add(Textareas.TF1());
        ChoseFrame.setLocationRelativeTo(null); //a képernyő középen fog megjelenni
        ChoseFrame.setVisible(true); //az ablak megjelenik

    }
    public static void close(){
        ChoseFrame.dispose();
    }
    
}//end

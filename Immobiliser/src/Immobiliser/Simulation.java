package Immobiliser;

import Buttons.MenuExitButton;
import Buttons.MenuStartButton;
import Buttons.SimulationBackButton;
import Buttons.SimulationBackToMenuButton;

import javax.swing.JFrame;

public class Simulation{
    SimulationDraw SimD;
    static JFrame SimFrame;

    public Simulation(){
        SimFrame = new JFrame("Indításgátló");
        SimD = new SimulationDraw();

        //Gombok létrehozása
        Integer BackToChoseBounds[] = {40, 740, 80, 40};
        SimulationBackButton BB = new SimulationBackButton("Vissza", BackToChoseBounds, "Vissza", false);

        //Kilépés gomb
        Integer BackToMenuBounds[] = {140, 740, 140, 40};
        SimulationBackToMenuButton BM = new SimulationBackToMenuButton("Vissza a menübe", BackToMenuBounds, "Vissza a menübe", false);



        SimFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ha jobb felül az x-re kattintunk bezáródik az ablak, nem csak tálcázódik
        SimFrame.add(SimD);
        SimFrame .pack();
        SimFrame.setLayout(null);
        SimFrame.add(BB.letrehoz());
        SimFrame.add(BM.letrehoz());
        SimFrame.setLocationRelativeTo(null); //a képernyő középen fog megjelenni
        SimFrame.setVisible(true); //az ablak megjelenik
    }
    public static void close(){
        SimFrame.dispose();
    }
}//end

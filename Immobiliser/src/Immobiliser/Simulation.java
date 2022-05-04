package Immobiliser;

import javax.swing.JFrame;

public class Simulation{
    SimulationDraw SimD;
    static JFrame SimFrame;

    Simulation(){
        SimFrame = new JFrame("Indításgátló");
        SimD = new SimulationDraw();

        SimFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ha jobb felül az x-re kattintunk bezáródik az ablak, nem csak tálcázódik
        SimFrame.add(SimD);
        SimFrame .pack();
        SimFrame.setLayout(null);
        SimFrame.add(Buttons.SZVISSZA());
        SimFrame.add(Buttons.MENUVISSZA());
        SimFrame.setLocationRelativeTo(null); //a képernyő középen fog megjelenni
        SimFrame.setVisible(true); //az ablak megjelenik
    }
    public static void close(){
        SimFrame.dispose();
    }
}//end

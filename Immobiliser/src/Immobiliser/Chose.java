package Immobiliser;

import javax.swing.JFrame;

public class Chose {
    ChoseDraw ChoseDraw;
    static JFrame ChoseFrame;

    Chose(){
        ChoseFrame = new JFrame("Indításgátló");
        ChoseDraw = new ChoseDraw();

        ChoseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ha jobb felül az x-re kattintunk bezáródik az ablak, nem csak tálcázódik
        ChoseFrame.add(ChoseDraw);
        ChoseFrame.pack();
        ChoseFrame.setLayout(null);
        ChoseFrame.add(StaticButtons.VVISSZA());
        ChoseFrame.add(StaticButtons.SAJAT());
        ChoseFrame.add(StaticButtons.INDITAS());
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

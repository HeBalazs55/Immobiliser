package Immobiliser;

import java.awt.Font;

import javax.swing.JButton;

public class buttons{

    private static String szt = "Comic Sans"; //Gombok szövegének betűstílusa
    private static Boolean f = false; //A gombokban lévő szövegnek ne legyen kerete
    private static Integer vm = 12; //A ,,Vissza" gombok szövegének mérete
    protected static JButton szimulalasg; //Átlépés a választásba gomb a menü Framen
    protected static JButton kilepesg; //Kilépés gomb a menü Framen

    protected static JButton sajatg; //Saját szimuláció indítása gomb a választás Framen
    protected static JButton inditasg; //Kiválasztott szimuláció indítása a választás Framen
    protected static JButton vvisszag; //Vissza a menübe gomb a választás Framen

    protected static JButton szvisszag; //Vissza a választásba gomb a szimulálás Framen
    protected static JButton mvisszag; //Vissza lépés a menübe gomb a szimulálás Framen

    //----------------------Menü gombjai---------------------------------
    public static JButton START(){
        szimulalasg = new JButton();
        szimulalasg.setBounds(680, 250, 175, 75);
        szimulalasg.setText("Szimulálás");
        szimulalasg.setFont(new Font(szt,Font.BOLD, 20));
        szimulalasg.addActionListener((event) -> menu.close());
        szimulalasg.addActionListener((event) -> new valasztas());
        szimulalasg.setFocusable(f);

        return szimulalasg;
    }
    public static JButton KILEPES(){
        kilepesg = new JButton();
        kilepesg.setBounds(680, 400, 175, 75);
        kilepesg.setText("Exit");
        kilepesg.setFont(new Font(szt,Font.BOLD, 20));
        kilepesg.setFocusable(f);
        kilepesg.addActionListener((event) -> System.exit(0));
        return kilepesg;
    }
    //----------------------Választás gombjai---------------------------------

    public static JButton VVISSZA(){
        vvisszag = new JButton();
        vvisszag.setBounds(510, 615, 80, 40);
        vvisszag.setText("Vissza");
        vvisszag.setFont(new Font(szt,Font.BOLD, vm));
        vvisszag.setFocusable(f);
        vvisszag.addActionListener((event) -> valasztas.close());
        vvisszag.addActionListener((event) -> new menu());

        return vvisszag;
    }

    public static JButton SAJAT(){
        sajatg = new JButton();
        sajatg.setBounds(660, 480, 200, 100);
        sajatg.setText("<html>Saját virtualizáció<br />összeállítása</html>");
        sajatg.setFont(new Font(szt,Font.BOLD, 15));
        sajatg.setFocusable(f);
        sajatg.addActionListener((event) -> valasztas.close());
        sajatg.addActionListener((event) -> new szimulacio());
        return sajatg;
    }

    public static JButton INDITAS(){
        inditasg = new JButton();
        inditasg.setBounds(810, 210, 110, 50);
        inditasg.setText("Indítás");
        inditasg.setFont(new Font(szt,Font.BOLD, 15));
        inditasg.setFocusable(f);
        inditasg.addActionListener((event) -> valasztas.close());
        inditasg.addActionListener((event) -> new szimulacio());

        return inditasg;
    }

    //----------------------Szimuláció gombjai---------------------------------
    public static JButton SZVISSZA(){
        szvisszag = new JButton();
        szvisszag.setBounds(40, 740, 80, 40);
        szvisszag.setText("Vissza");
        szvisszag.setFont(new Font(szt,Font.BOLD, vm));
        szvisszag.setFocusable(f);
        szvisszag.addActionListener((event) -> szimulacio.close());
        szvisszag.addActionListener((event) -> new valasztas());

        return szvisszag;
    }

    public static JButton MENUVISSZA(){
        mvisszag = new JButton();
        mvisszag.setBounds(140, 740, 140, 40);
        mvisszag.setText("Vissza a Menübe");
        mvisszag.setFont(new Font(szt,Font.BOLD, vm));
        mvisszag.setFocusable(f);
        mvisszag.addActionListener((event) -> szimulacio.close());
        mvisszag.addActionListener((event) -> new menu());

        return mvisszag;
    }

}//vége


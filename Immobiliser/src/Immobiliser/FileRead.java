package Immobiliser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {
    private static String fileadat ="";
    private static File beolvasottf;
    private static Scanner in;

    //-----A fájlban tárolt komponensek neveit írja csak ki-----------------
    public static String elsosor(String s){
        try{
            beolvasottf = new File(s);
            in = new Scanner(beolvasottf, "UTF-8");
            fileadat = in.nextLine();
            in.close();

        }catch(FileNotFoundException e){
            System.out.println("Szar van a levesben");
        }
        return fileadat;
    }

    //------A fájlban tárolt komponensek van benne/nincs benne beolvasása-----
    public static String beolvasas(String s){
        try{
            beolvasottf = new File(s);
            in = new Scanner(beolvasottf);
            in.nextLine();
            while(in.hasNextLine()){
                fileadat = fileadat+in.nextLine()+"\n";
            }

        }catch(FileNotFoundException e){
            System.out.println("Szar van a levesben");
        }
        return fileadat;
    }
}//end

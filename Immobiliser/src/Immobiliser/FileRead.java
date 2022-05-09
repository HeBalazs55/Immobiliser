package Immobiliser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {
    private Scanner in;

    //-----A fájlban tárolt komponensek neveit írja csak ki-----------------
    public String[] FirstRow(String s){
        File beolvasottf;
        String elsosor = "";
        try{
            beolvasottf = new File(s);
            in = new Scanner(beolvasottf, "UTF-8");
            elsosor = in.nextLine();
            in.close();

        }catch(FileNotFoundException e){
            System.out.println("Szar van a levesben");
        }
        String[] fileadat;
        fileadat = elsosor.split(", ");

        return fileadat;
    }

    //------A fájlban tárolt komponensek van benne/nincs benne beolvasása--------
    public int[] ComponentYesNo(String s){
        File beolvasottf;

        int[] fileadat = new int[6];
        try{
            beolvasottf = new File(s);
            in = new Scanner(beolvasottf);
            in.nextLine();
            for(int i=0; i<6; i++){
                fileadat[i] = Integer.parseInt(in.nextLine());
            }
            in.close();
        }catch(FileNotFoundException e){
            System.out.println("Szar van a levesben");
        }
        return fileadat;
    }
}//end

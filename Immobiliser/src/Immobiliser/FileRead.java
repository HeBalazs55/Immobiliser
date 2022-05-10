package Immobiliser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {
    private Scanner in;

    //-----Give back the first row of the file in a String[]-----------------
    public String[] FirstRow(String s){
        File beolvasottf;
        String elsosor = "";
        try{
            beolvasottf = new File(s);
            in = new Scanner(beolvasottf, "UTF-8");
            elsosor = in.nextLine();
            in.close();

        }catch(FileNotFoundException e){
            System.err.println("Nincs ilyen fájl");
        }
        String[] fileadat;
        fileadat = elsosor.split(", ");

        return fileadat;
    }

    //------Give back the component settings (0-no/1-yes) from the file--------
    public Integer[] ComponentYesNo(String s){
        File beolvasottf;

        Integer[] fileadat = new Integer[6];
        try{
            beolvasottf = new File(s);
            in = new Scanner(beolvasottf);
            in.nextLine();
            for(int i=0; i<6; i++){
                fileadat[i] = Integer.parseInt(in.nextLine());
            }
            in.close();
        }catch(FileNotFoundException e){
            System.err.println("Nincs ilyen fájl!");
        }
        return fileadat;
    }
}//end

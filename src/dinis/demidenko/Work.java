package dinis.demidenko;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by dende on 23.10.2016.
 */
public class Work {
    public void writeFile(File file, String text){
        String res = readFile(file);
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.println(res + text);
            pw.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public String readFile(File file){
        String res = "";
        try {
            Scanner sc = new Scanner(file);
            for(;sc.hasNextLine();){
                res = res + sc.nextLine() + System.lineSeparator();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }
    public String saveInAraay(File file, String[] arr){
        arr = readFile(file).split(System.lineSeparator());
        String res = "";
        res = "<!DOCTYPE html><html><head><link href=\"styles.css\" type=\"text/css\""
                + " rel=\"stylesheet\"><meta charset = \"UTF-8\"><title>Результат</title></head>"
                + "<body>";
        if(file.length() == 3){
            System.out.println(33);
        }else{
            for(int i = 0; i < arr.length; i++){
                if( arr[i].equals("")){
                    System.out.println(123);
                    continue;
                }
                res = res + "<div class=\"divSave\">" + arr[i] + "</div>";
            }
        }
        res = res + "<div id=\"ssilkaRes\"><a"
                + " href=\"index.html\"><p id=\"ssi\">Назад</p></a></div>" + "</body>";
        return res;
    }

    public String saveInAraayDB(File file, String[] arr){
        arr = readFile(file).split(System.lineSeparator());
        String res = "";
        res = "<!DOCTYPE html><html><head><link href=\"styles.css\" type=\"text/css\""
                + " rel=\"stylesheet\"><meta charset = \"UTF-8\"><title>Результат</title></head>"
                + "<body>";
        if(file.length() == 3){
            System.out.println(33);
        }else{
            for(int i = 0; i < arr.length; i++){
                if( arr[i].equals("")){
                    System.out.println(123);
                    continue;
                }
                res = res + "<div class=\"divSave\">" + arr[i] + "</div>";
            }
        }
        res = res + "<div id=\"ssilkaRes\"><a"
                + " href=\"index.html\"><p id=\"ssi\">Назад</p></a></div>" + "</body>";
        return res;
    }

}

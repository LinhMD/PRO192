/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websitevisits;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class FileDAO {
    public static ArrayList<LogEntry> ReadFile(String fileName){
        ArrayList<LogEntry> list = new ArrayList<>();
        FileReader f = null;
        BufferedReader bf = null;
        try{
            f = new FileReader(fileName);
            bf = new BufferedReader(f);
            while(bf.ready()){
                String[] arr = bf.readLine().split(" - - |\"|:| -| ");
                LogEntry temp = new LogEntry(arr[0], arr[1].substring(1), arr[9], Integer.parseInt(arr[11]), Integer.parseInt(arr[12]));
                list.add(temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(f != null) f.close();
                if(bf != null) bf.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }
}

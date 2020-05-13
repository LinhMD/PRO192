/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.TreeSet;

/**
 *
 * @author USER
 */
public class WordManager {
    TreeSet<String> Words;
    public WordManager(){
        this.Words = new TreeSet<>();
    }
    public void loadData(){
        FileReader f = null;
        BufferedReader bf = null;
        try{
            f = new FileReader("in.txt");
            bf = new BufferedReader(f);
            while(bf.ready()){
                String temp = bf.readLine();
                String [] arr = temp.split(" ");
                for (String s : arr) {
                    char end = s.charAt(s.length()-1);
                    if(!Character.isAlphabetic(end))
                        s = s.substring(0, s.length()-1);
                    this.Words.add(s.toLowerCase());
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(f != null) f.close();
                if(bf != null) bf.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void printWordLength(){
        PrintWriter p = null;
        try{
            p = new PrintWriter("out2.txt");
            for (String Word : Words) {
                p.println(Word + "  "+ Word.length());
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(p != null) p.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void getSuggestion(String prefix){
        if(prefix.isEmpty())
            return;
        PrintWriter p = null;
        try{
            p = new PrintWriter("out1.txt");
            for (String Word : Words) {
                if(Word.matches("^" + prefix + "[a-z']*"))
                    p.print(Word + ", ");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(p != null) p.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void printAll(){
        for (String Word : Words) {
            System.out.println(Word);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class PE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WordManager obj = new WordManager();
        obj.loadData();
        obj.printWordLength();
        String prefix;
        Scanner s;
        do{
            System.out.println("input prefix:");
            s = new Scanner(System.in);
            prefix = s.nextLine();
        }while(prefix.isEmpty() || prefix.isBlank());
        obj.getSuggestion(prefix.toLowerCase());
    }
    
}

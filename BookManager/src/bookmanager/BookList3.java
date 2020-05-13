/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmanager;

import DTO.Book;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author USER
 */
public class BookList3 {
    TreeSet <Book> list;
    public BookList3(){
        list = new TreeSet<>();
    }

    public boolean addBook(Book x){
        return list.add(x);
    }
    public void displayAll(){
        Iterator<Book> Temp =  list.iterator();
        while(Temp.hasNext()){
            Book b = Temp.next();
            System.out.println(b.toString());
        }
    }
    public Book findBook(int id){
      for(Book b: list){
          if (b.getId() == id){
              return b;
          }
      }
      return null;
    }
    public boolean updateBook(int id){
      Book pos = findBook(id);
        if (pos != null){
            String newName;
            Scanner sc = new Scanner(System.in);
            System.out.print("\nInput new name: ");
            newName = sc.nextLine();
            pos.setTitle(newName);
            return true;
        }else{
            System.out.println("\nBook does not exist");
            return false;
        }
    }
    public boolean removeBook(int id){
      //pos la vi tri tim thay trong list
        Book pos = findBook(id);
        if(pos == null) return false;      
        list.remove(pos);
        return true;
    }
    
}

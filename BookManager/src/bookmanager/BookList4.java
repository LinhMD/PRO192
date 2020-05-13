/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmanager;

import DTO.Book;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class BookList4 {
    HashSet<Book> list;
    public BookList4(){
        list = new HashSet<>();
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
    public void sort(){
        Object[] arr = list.toArray();
        Arrays.sort(arr);
        for(Object o: arr)
            System.out.println(o.toString() );
    }
    public void sortByName(){
        Book [] arr = new Book[list.size()];
        arr = list.toArray(arr);
        Arrays.sort(arr, Book.byTitle);
        for (Book book : arr) {
            System.out.println(book.toString());
        }
    }
}

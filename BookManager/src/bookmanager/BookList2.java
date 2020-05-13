/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmanager;

import DTO.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class BookList2 {
    List <Book>list;
    public BookList2(){
        list = new ArrayList();
    }
        public boolean addBook(Book B){
      list.add(B);
      return true;
  }
    
    public void displayAll(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
//        for (Book book : list) {
//            System.out.println(book.toString());
//        }
      }
    public int findBook(int id){
      for(int i = 0; i < list.size(); i++){
          if (list.get(i).getId() == id){
              return i;
          }
      }
      return -1;
    }
     public boolean updateBook(int id){
      int pos = findBook(id);
      if (pos >= 0){
          String newName;
          Scanner sc = new Scanner(System.in);
          System.out.print("\nInput new name: ");
          newName = sc.nextLine();
          list.get(pos).setTitle(newName);
          return true;
      }else{
          System.out.println("\nBook does not exist");
          return false;
      }
    }
     public boolean removeBook(int id){
      //pos la vi tri tim thay trong list
      int pos = findBook(id);
      if(pos < 0) return false;      
      list.remove(pos);
      return true;
  }
     
    public void sort(){ //chi hoat dong duoc khi co ham compareTo
        Collections.sort(list); //neu list chua cac bien primitive thi ko loi
        
    }
    public void sortBytitle(){
        Collections.sort(list, Book.byTitle);
    }
    
}

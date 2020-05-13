/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmanager;

import DTO.Book;
import java.util.Scanner;
/**
 *
 * @author USER
 */
public class BookList {
    Book [] List;
    int count;
    int SIZE = 10;
    public BookList(){
        List = new Book[SIZE];
        count = 0;
    }
    public boolean checkID(int id){
        for (int i = 0; i < count; i++)
            if(this.List[i].getId() == id)
                return false;
        return true;
    }
    public int userInputNewID(){
        boolean check;
        int id;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("Input an id");
            check = checkID(id = input.nextInt());
            if(!check)
                System.out.println("id invalid");
        }while (!check);
        return id;
    }
    public boolean addBook(Book B){
        this.List[count] = B;
        return true;
    }
    public BookList displayAll(){
        for (int i = 0; i < count; i++){
            System.out.println(this.List[i].toString());
        }
        return this;
    }
    public int findBookPos(int id){
        for(int i = 0; i < this.count; i++){
            if( this.List[i].getId() == id){
                return i;
            }    
        }
        return -1;
    }
    public Book findBook(int id){
        int pos = this.findBookPos(id);
        if(pos != 1){
            return this.List[pos];
        }else return null;
    }
    public boolean updateById(int id){
        int pos = findBookPos(id);
        Scanner input = new Scanner(System.in);
        if (pos != -1){
            this.List[pos].setTitle(input.nextLine());
            return true;
        }else
            return false;
    }
    public Book removeBook(int id){
        int pos = findBookPos(id);
        Book temp = this.findBook(id);
        if (pos != -1){
            for (int i = pos; i < this.count; i++){
                this.List[i] = this.List[i + 1];
            }
        }
        return temp;
    }
    
    public BookList sortBook(){
        for (int i = 0; i < count; i++)
            for(int j = i; j > count; j++)
                if(this.List[j].getId() < this.List[i].getId()){
                    Book temp;
                    temp = this.List[i];
                    this.List[j] = this.List[i];
                    this.List[i] = temp;
                }
        return this;
    }
    
}

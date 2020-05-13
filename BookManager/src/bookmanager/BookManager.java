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
public class BookManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BookList  obj = new BookList();
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. add a book");
            System.out.println("2. display books");
            System.out.println("3. find book"); 
            System.out.println("4. update book");
            System.out.println("5. remove book");
            System.out.println("6. sort");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    int id;
                    String title;
                    System.out.println("input id:");
                    id = obj.userInputNewID();
                    sc = new Scanner(System.in);
                    title = sc.nextLine();
                    Book b = new Book(id, title);
                    if(obj.addBook(b))
                        System.out.println("added");
                    else
                        System.out.println("add fail");
                    break;
                case 2:
                    obj.displayAll();
                    break;
                case 3:
                    System.out.println("Input ID:");
                    if(obj.findBookPos(input.nextInt()) != 1)
                        System.out.println("Book Found");
                    else
                        System.out.println("Book not Found");
                    break;
                case 4:
                    System.out.println("Input ID:");
                    if(obj.updateById(input.nextInt()))
                        System.out.println("update successfully");
                    else
                        System.out.println("update unsuccessfully");
                    break;
                case 5:
                    System.out.println("Input ID");
                    if(obj.removeBook(input.nextInt()) != null)
                        System.out.println("remove successfully");
                    else
                        System.out.println("action fail");
                case 6:
                    obj.sortBook().displayAll();
                    break;
                default:
                    System.out.println("bye!!");
                    break;       
            }
        }while(choice <= 6);
    }
    
}

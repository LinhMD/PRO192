/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Comparator;

/**
 *
 * @author USER
 */
public class Book implements Comparable<Book>{
    private int id;
    private String title;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Book() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + '}';
    }

    @Override
    public int compareTo(Book o) {
        if(id > o.getId())
            return 1;
        else if (id < o.getId())
            return -1;
        return 0;
    }
    //so sanh 2 book dua vao title
    public static Comparator<Book> byTitle = new Comparator<Book>(){
        //comparator la mot inteface, muon new ta tao lop nac danh
        @Override
        public int compare(Book o1, Book o2) {
            if(o1.getTitle().compareTo(o2.getTitle()) > 0){
                return 1;
            }
            else if(o1.getTitle().compareTo(o2.getTitle()) < 0)
                return -1;
            else 
                return 0;
        }
        
    };
    
    
}

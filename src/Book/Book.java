package Book;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


public class Book {

    private int x, y;
    private int place;
    private int lastePage;
    private List<String> page;
    private int width = 80;
    private int height = 100;
    private Boolean isOpen = false;

    public Book (){
        page = new ArrayList<String>();
        page.add(0,"file:resources\\Bookicon.png");
        place = 0;
        x = 50;
        y = 50;
    }


    public void insertPage (String path){
       page.add(path);
    }

    public String getImage(){
        return page.get(place);
    }

    private void OpenBook(){
        page.remove(0);
        page.add(0,"file:resources\\Bookcover.png");
        x = 445;
        y = 100;
        width = 390;
        height = 600;
        isOpen = true;
    }
    private void CloseBook(){
        page.remove(0);
        page.add(0,"file:resources\\Bookicon.png");
        x = 50;
        y = 50;
        width = 80;
        height = 100;
        isOpen = false;
    }
    public void clickBook(){
        if(isOpen && place == page.size()-1){
            Next();
            CloseBook();
        }
        else if(isOpen){
            Next();
        }
        else
        {
            OpenBook();
        }
    }

    private void Next (){

        place++;

        if (place == page.size()){
            place = 0;
        }
    }

//    public void Open(){
//        isOpen = true;
//    }
//    public void Close();




    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }




}

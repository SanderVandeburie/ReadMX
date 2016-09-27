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
    private int width = 390;
    private int height = 600;
    private Boolean isOpen = false;

    public Book (int xpos, int ypos){

        page = new ArrayList<String>();
        place = 0;
        x = xpos;
        y = ypos;
    }


    public void InsertPage (String path){
       page.add(path);
    }

    private void OpenBook(){
        //todo add cover image
        x = 445;
        y = 100;
        width = 390;
        height = 600;
        isOpen = true;
    }
    private void CloseBook(){
        //todo add bookIcon
        x = 50;
        y = 550;
        width = 200;
        height = 200;
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




}

package Book;


import java.awt.Graphics;
import javax.swing.*;


public class Book {

    private int x, y;
    private int place;
    private String[] page;


    public Book (int xpos, int ypos){

        page = new String[7];
        place = 0;
        x = xpos;
        y = ypos;
    }

    public Book (){

        //page = new  [7];
        place = 0;
        //page1 = new ImageIcon (getClass().getResource ("1.jpg"));

        //x = page.getIconWidth;
       // y = page.getIconHeight;

    }

    public void InsertPage (String Path){

        for (int i=0; i<7; i++){

            if (page[i] == null){

                page[i] = Path;

                i =7;
            }

        }

    }

    public void Next (){

        place++;

        if (place == 7){

            place = 0;
        }
    }
    public void Previous (){

        place--;

        if (place == 7){

            place = 0;
        }
    }

   // public ImageIcon getPage (){

        //return page[place];

   // }



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

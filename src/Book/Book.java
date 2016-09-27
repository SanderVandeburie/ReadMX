package Book;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marisela Poot
 */
import javafx.scene.image.Image;
public class Book {

    private Page[] Pages;
    private Image coverImage;

    public Book(String coverImagePath) {
        Pages = new Page [5];
        coverImage =  new Image(coverImagePath);
    }


}


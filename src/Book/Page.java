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

public class Page {
    
   private Image bookpage;
   
   public Page(String imagepots){
       
       this.bookpage = new Image (imagepots);
 
   }
   
   
   public Image Showpage() {
       
       return bookpage;       
       
   }
     
    
    
    
}

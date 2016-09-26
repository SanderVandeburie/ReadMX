package Visual;

import javafx.scene.image.Image;

/**
 * Created by yodi on 27/09/2016.
 */
public class Item {
    private int id;
    private int xpos;
    private int ypos;
    private int width;
    private int height;
    private Image image;

    public Item(int id, int xpos,int ypos,String imagePath){
        this.id = id;
        this.xpos = xpos;
        this.ypos = ypos;
        this.image = new Image(imagePath);
        this.width = (int)image.getWidth();
        this.height = (int)image.getHeight();
    }
}

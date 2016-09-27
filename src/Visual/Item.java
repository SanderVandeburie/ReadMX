package Visual;

import javafx.scene.image.Image;

/**
 * Created by yodi on 27/09/2016.
 */
public class Item {
    private int id;
    private int xpos;

    public int getXpos() {
        return xpos;
    }
    public int getYpos() {
        return ypos;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public String getImage() {
        return image;
    }

    private int ypos;
    private int width;
    private int height;
    private String image;


    public Item(int id, int xpos,int ypos,String imagePath,int width,int height){
        this.id = id;
        this.xpos = xpos;
        this.ypos = ypos;
        this.image = new String(imagePath);
        this.width = width;
        this.height = height;
    }

    public void interactWith(Item item)
    {

    }
}

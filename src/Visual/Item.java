package Visual;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.scene.image.Image;

/**
 * Created by yodi on 27/09/2016.
 */
public class Item {
    private int xpos;


    private boolean collectable;

    public int getXpos() {
        return xpos;
    }
    public boolean isCollectable() {
        return collectable;
    }
    public int getYpos() {
        return ypos;
    }
    public void setXpos(int x){
        this.xpos = x;
    }
    public void setYpos(int y){
        this.ypos = y;
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
    public void setImage(String path){
        image =  path;
    }

    private int ypos;
    private int width;
    private int height;
    private String image;


    public Item(int xpos,int ypos,String imagePath,int width,int height,boolean collectable){
        this.xpos = xpos;
        this.ypos = ypos;
        this.image = new String(imagePath);
        this.width = width;
        this.height = height;
        this.collectable = collectable;
    }



    public Boolean interactWith(Item item)
    {
        return false;
    }
}

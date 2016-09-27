package Visual.Items;

import Visual.Item;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by yodi on 27/09/2016.
 */
public class Painting extends Item {
    public Painting(int xpos, int ypos, String imagePath, int width, int height,boolean collectable,boolean dropable) {
        super(xpos, ypos, imagePath, width, height, collectable,dropable);
    }
    //@Override
    //public Boolean interactWith(Item item){

    //}
}

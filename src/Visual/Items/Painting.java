package Visual.Items;

import Visual.Item;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by yodi on 27/09/2016.
 */
public class Painting extends Item {
    public Painting(int id, int xpos, int ypos, String imagePath, int width, int height) {
        super(id, xpos, ypos, imagePath, width, height);
    }
    @Override
    public Boolean interactWith(Item item){
        if(item instanceof Cane){
            return true;
        }
        else{
            return false;
        }
    }
}

package Visual.Items;

import Game.Player;
import Visual.Item;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by yodi on 27/09/2016.
 */
public class Painting extends Item {
    private String KeyId = "Cane";

    public Painting(int xpos, int ypos, String imagePath, int width, int height,boolean collectable) {
        super(xpos, ypos, imagePath, width, height);
    }
    @Override
    public Boolean interactWith(Item item){
        if(item instanceof Key){
            Player.addToInventory(new Key("path to string image","C"));
            return true;
        }
        else{
            return false;
        }
    }
}

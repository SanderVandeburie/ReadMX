package Visual.Items;

import Game.Inventory;
import Game.Player;
import Visual.Item;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by yodi on 27/09/2016.
 */
public class Painting extends Item {
    private String keyId;



    public Painting(int xpos, int ypos, String imagePath, int width, int height,String key) {
        super(xpos, ypos, imagePath, width, height);
        keyId = key;
    }


    @Override
    public Boolean interactWith(Item key){
        if(key instanceof Key){
            if(keyId.matches(((Key) key).getKeyId()))
            {
                key.dropOutOfInventory();
                Player.addToInventory(new Key(0,0,"file:resources\\Key.png","C"));
                return true;
            }
        }
        return false;
    }
}

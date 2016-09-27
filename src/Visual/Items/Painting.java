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


    private Item next;

    public Painting(int xpos, int ypos, String imagePath, int width, int height,String key, Item next,boolean collectable,boolean dropable) {
        super(xpos, ypos, imagePath, width, height);
        this.next = next;
    }

    public Item getNext() {
        return next;
    }

    @Override
    public Boolean interactWith(Item key){
        if(key instanceof Key){
            if(keyId.matches(((Key) key).getKeyId()))
            {
                key.dropOutOfInventory();
                //todo
                //Player.addToInventory(new Key(0,0,"some string path","C"));
                return true;
            }
        }
        return false;
    }
}

package Visual.Items;

import Visual.Item;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by yodi on 27/09/2016.
 */
public class Painting extends Item {
    private String keyId;

    public Boolean getOpen() {
        return isOpen;
    }

    private Boolean isOpen;
    private Item next;

    public Painting(int xpos, int ypos, String imagePath, int width, int height,String key, Item next,boolean collectable,boolean dropable) {
        super(xpos, ypos, imagePath, width, height, collectable,dropable);
        isOpen = false;
        this.next = next;
    }
    private void open(){
        isOpen = true;
    }

    public Item getNext() {
        return next;
    }

    @Override
    public Boolean interactWith(Item key){
        if(key instanceof Key){
            if(keyId.matches(((Key) key).getKeyId()))
            {
                open();
                return true;
            }
        }
        return false;
    }
}

package Visual.Items;

import Visual.Item;
import Visual.Room;

/**
 * Created by yodi on 27/09/2016.
 */
public class Door extends Item {
    private String keyId;

    public Boolean getOpen() {
        return isOpen;
    }

    private Boolean isOpen;
    private int next;
    public Door(int xpos,int ypos,String imagePath,int width,int height,String keyId,int next,boolean collectable,boolean dropable){
        super(xpos,ypos,imagePath, width, height);
        this.keyId = keyId;
        isOpen = false;
        this.next = next;
    }
    private void open(){
        isOpen = true;
    }

    public int getNextRoom() {
        return next;
    }


    @Override
    public Boolean interactWith(Item key){
        if(key instanceof Key){
            if(keyId.matches(((Key) key).getKeyId()))
            {
                open();
                key.dropOutOfInventory();
                return true;
            }
        }
        return false;
    }
}

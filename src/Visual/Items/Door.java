package Visual.Items;

import Visual.Item;
import Visual.Room;

/**
 * Created by yodi on 27/09/2016.
 */
public class Door extends Item {
    private String keyId;
    private Boolean isOpen;
    private Room next;
    public Door(int id,int xpos,int ypos,String imagePath,int width,int height,String keyId,Room next){
        super(id,xpos,ypos,imagePath, width, height);
        this.keyId = keyId;
        isOpen = false;
        this.next = next;
    }
    private void open(){
        isOpen = true;
    }

    public Room getNextRoom() {
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

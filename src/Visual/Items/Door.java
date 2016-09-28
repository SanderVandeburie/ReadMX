package Visual.Items;

import Visual.Item;
import Visual.Room;
import Game.Game;

/**
 * Created by yodi on 27/09/2016.
 */
public class Door extends Item {
    private String keyId;
    private Game  game;

    public Boolean getOpen() {
        return isOpen;
    }

    private Boolean isOpen;
    private int next;
    public Door(int xpos,int ypos,String imagePath,int width,int height,String keyId,int next,Game game){
        super(xpos,ypos,imagePath, width, height);
        isOpen = false;
        if(keyId.matches("open"))
        {
            isOpen = true;
        }
        this.keyId = keyId;
        this.next = next;
        this.game = game;
    }
    private void open(){
        isOpen = true;
        game.setCurrentRoom(next);
        super.setImage("file:resources\\Door-open.png");
    }

    public int getNextRoom() {
        return next;
    }

    @Override
    public Boolean clicked(){
        if(isOpen)
        {
            open();
        }
        return false;
    }

    @Override
    public Boolean interactWith(Item key){
        if(key instanceof Key){
            if(keyId.matches(((Key) key).getKeyId()))
            {
                open();
                key.dropOutOfInventory();
                return false;
            }
        }
        return false;
    }
}

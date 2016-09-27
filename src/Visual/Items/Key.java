package Visual.Items;

import Game.Player;
import Visual.Item;

/**
 * Created by yodi on 27/09/2016.
 */
public class Key extends Item {
    private String keyId;
    public Key(String imagePath,String keyId){
        super(0,0,imagePath,100,100);
        this.keyId = keyId;
    }

    @Override
    public Boolean clicked(){
        Player.addToInventory(this);
        return true;
    }

    public String getKeyId(){
        return keyId;
    }
}

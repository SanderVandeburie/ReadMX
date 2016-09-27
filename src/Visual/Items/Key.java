package Visual.Items;

import Visual.Item;

/**
 * Created by yodi on 27/09/2016.
 */
public class Key extends Item {
    private String keyId;
    public Key(int xpos, int ypos,String imagePath,String keyId){
        super(xpos,ypos,imagePath,100,100);
        this.keyId = keyId;
    }

    public String getKeyId(){
        return keyId;
    }
}

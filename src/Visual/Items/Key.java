package Visual.Items;

import Visual.Item;

/**
 * Created by yodi on 27/09/2016.
 */
public class Key extends Item {
    private String keyId;
    public Key(int xpos, int ypos,String imagePath,int width,int height,String keyId,boolean collectable){
        super(xpos,ypos,imagePath,width,height,collectable);
        this.keyId = keyId;
    }


    public String getKeyId(){
        return keyId;
    }
}

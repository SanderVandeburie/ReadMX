package Visual.Items;

import Visual.Item;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by yodi on 27/09/2016.
 */
public class Key extends Item {
    private String keyId;
    private String selectImage;
    private String normalImage;
    private Boolean selected = false;
    public Key(int xpos, int ypos,String imagePath,String keyId){
        super(xpos,ypos,imagePath,100,100);
        this.normalImage = imagePath;
        this.keyId = keyId;
        this.selectImage = imagePath.replaceAll(".png","-glow.png");
    }

    public String getKeyId(){
        return keyId;
    }
    public void select(){
        if(selected)
        {
            super.setImage(normalImage);
            selected = false;
        }
        else{
            super.setImage(selectImage);
            selected = true;
        }
    }

}

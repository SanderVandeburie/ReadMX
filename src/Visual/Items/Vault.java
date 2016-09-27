package Visual.Items;

import Game.Inventory;
import Visual.Item;

/**
 * Created by yodi on 27/09/2016.
 */
public class Vault extends Item {
    private int first = 0;
    private int seccond = 0;
    private int third = 0;
    private int fourth = 0;
    private int Solution1 = 2;
    private int Solution2 = 7;
    private int Solution3 = 5;
    private int Solution4 = 0;
    public Vault(int xpos, int ypos, String imagePath, int width, int height) {
        super(xpos, ypos, imagePath, width, height);

    }
    public void turnFirst(){
        first = (first+1)%10;
        check();
    }
    public void turnSeccond(){
        seccond = (seccond+1)%10;
        check();
    }
    public void turnThird(){
        third = (third+1)%10;
        check();
    }
    public void turnFourth(){
        fourth = (fourth+1)%10;
        check();
    }
    private void check(){
        Boolean res = true;
        if(first != Solution1)
        {
            res = false;
        }
        if(seccond != Solution2)
        {
            res = false;
        }
        if(third != Solution3)
        {
            res = false;
        }
        if(fourth != Solution4)
        {
            res = false;
        }
        if (res){
            Inventory.addItem(new Key(0,0,"string Path",100,100,"B"));
            //todo string aan passen
            super.setImage("newstring");
        }
    }
    public void onClick(int xpos,int ypos)
    {
        int x = xpos - super.getXpos();
        int y = ypos - super.getYpos();
    }
}

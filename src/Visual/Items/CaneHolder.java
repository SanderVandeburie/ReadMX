package Visual.Items;

import Game.Inventory;
import Game.Player;
import Visual.Item;

public class CaneHolder extends Item {
    private  Boolean gotCane = true;
    public CaneHolder(int xpos, int ypos, String imagePath, int width, int height) {
        super(xpos, ypos, imagePath, width, height);
    }

    //todo delete
//    @Override
//    public Boolean interactWith(Item item) {
//        setImage("file:resources\\Cane-holder-minus-cane.png");
//        return true;
//    }

    @Override
    public Boolean clicked()
    {
        if(gotCane){
            Player.addToInventory(new Key(0,0,"file:resources\\Cane.png","cane"));
            setImage("file:resources\\Cane-holder-minus-cane.png");
            gotCane = false;
        }
        return false;
    }
}


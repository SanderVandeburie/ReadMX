package Visual.Items;

import Visual.Item;

public class CaneHolder extends Item {
    public CaneHolder(int xpos, int ypos, String imagePath, int width, int height, boolean collectable,boolean dropable) {
        super(xpos, ypos, imagePath, width, height, collectable,dropable);
    }

    @Override
    public Boolean interactWith(Item item) {
        setImage("file:resources\\Cane-holder-minus-cane.png");
        return true;
    }

    @Override
    public Item GetItem() {
        Item cane = new Key(0,0,"file:resources\\Cane.png",80,80,"cane",false,true);
        this.Collected();
        return cane;
    }
}


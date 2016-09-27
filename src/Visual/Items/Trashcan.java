package Visual.Items;

import Visual.Item;

public class Trashcan extends Item {
    public Trashcan(int xpos, int ypos, String imagePath, int width, int height,boolean collectable,boolean dropable) {
        super(xpos, ypos, imagePath, width, height, collectable,dropable);
    }

    @Override
    public Boolean interactWith(Item item) {
        setImage("file:resources\\Trash-no-page.png");
        return false;
    }
}


package Visual.Items;

import Game.Player;
import Visual.Item;

public class Moose extends Item {
    private String page;
    public Moose(int xpos, int ypos, String imagePath, int width, int height) {
        super(xpos, ypos, imagePath, width, height);
        this.page = page;
    }

    @Override
    public Boolean clicked(){
        setImage("file:resources\\Moose.png");
        Player.addToInventory(new Key(0,0,"file:resources\\Knife.png","knif"));
        return false;
    }
}


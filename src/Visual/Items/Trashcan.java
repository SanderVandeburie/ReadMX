package Visual.Items;

import Game.Player;
import Visual.Item;

public class Trashcan extends Item {
    private String page;
    public Trashcan(int xpos, int ypos, String imagePath, int width, int height,String page) {
        super(xpos, ypos, imagePath, width, height);
        this.page = page;
    }

    @Override
    public Boolean clicked(){
        setImage("file:resources\\Trash-no-page.png");
        Player.addPage(page);
        return false;
    }
}


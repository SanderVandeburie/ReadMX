package Visual.Items;

import Game.Player;
import Visual.Item;

public class Trashcan extends Item {
    public Trashcan(int xpos, int ypos, String imagePath, int width, int height) {
        super(xpos, ypos, imagePath, width, height);
    }

    @Override
    public Boolean clicked(){
        setImage("file:resources\\Trash-no-page.png");
        //todo add page
        //Player.addPage('');
        return false;
    }
}


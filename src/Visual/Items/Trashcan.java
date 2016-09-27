package Visual.Items;

import Game.Player;
import Visual.Item;

public class Trashcan extends Item {
    public Trashcan(int xpos, int ypos, String imagePath) {
        super(xpos, ypos, imagePath, 390, 411);
    }

    @Override
    public Boolean clicked() {
        setImage("file:resources\\Trash-no-page.png");
        //todo add page resourdes
        //Player.addPage();
        return false;
    }
}


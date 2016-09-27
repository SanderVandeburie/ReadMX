package Visual.Items;

import Game.Inventory;
import Visual.Item;

/**
 * Created by yodi on 27/09/2016.
 */
public class Vault extends Item {
    private int[] input =  new int[4];
    private int[] solution = new int[4];
    public Vault(int xpos, int ypos, String imagePath, int width, int height,boolean collectable) {
        super(xpos, ypos, imagePath, width, height, collectable);
        solution[0] = 2;
        solution[1] = 7;
        solution[2] = 5;
        solution[3] = 0;
    }
    public void addInput(int id){
        input[id] = (input[id] +1 ) %10;
        check();
    }
    private void check(){
        Boolean res = true;
        for(int i = 0; i < input.length; i ++){
            if(input[i] != solution[i]){
                res = false;
            }
        }
        if (res){
            Inventory.addItem(new Key(0,0,"string Path",100,100,"B",false));
            //todo string aan passen
            super.setImage("newstring");
        }
    }
    public void onClick(int xpos,int ypos)
    {
        int x = xpos - super.getXpos();
        int y = ypos - super.getYpos();
        int id = (x-186)/33;
        if(id > 0 && id < 4){
            addInput(id);
        }

    }
}

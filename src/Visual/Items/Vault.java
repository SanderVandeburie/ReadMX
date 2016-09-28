package Visual.Items;

import Game.Inventory;
import Game.Player;
import Visual.Item;

/**
 * Created by yodi on 27/09/2016.
 */
public class Vault extends Item {
    private int[] input =  new int[4];
    private int[] solution = new int[4];
    private Boolean zoom = false;
    private int Ox;
    private  int Oy;
    private int width;
    private int height;
    public Vault(int xpos, int ypos, String imagePath, int width, int height,boolean collectable) {
        super(xpos, ypos, imagePath, width, height);
        solution[0] = 2;
        solution[1] = 7;
        solution[2] = 5;
        solution[3] = 0;
        Ox = xpos;
        Oy = ypos;
        width = width;
        height = height;
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
            //Player.addToInventory(new Key(0,0,"string Path","B"));
            Player.addPage("file:resources\\p17.jpg");
            super.setImage("newstring");
        }
    }

    @Override
    public Boolean clicked(){
        if(!zoom){
            super.setXpos(380);
            super.setYpos(34);
            super.setWidth(521);
            super.setHeight(732);
        }
        else{
            super.setXpos(Ox);
            super.setYpos(Oy);
            super.setWidth(width);
            super.setHeight(height);
        }
        return  false;
    }

    public void Click(int xpos,int ypos)
    {
        int x = xpos - super.getXpos();
        int y = ypos - super.getYpos();
        int id = (x-186)/33;
        if(id > 0 && id < 4){
            addInput(id);
        }

    }
}

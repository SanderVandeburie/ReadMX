package Game;

import Visual.Item;
import Visual.Items.Key;

public class Inventory {
    private static Item[] items;

    public Inventory(){
        items = new Item[5];
    }
    public static void addItem(Item toAdd){
        for(int i = 0;i<items.length;i++)
        {
            if(items[i] == null){
                items[i] =  toAdd;
                items[i].setXpos(1180);
                items[i].setYpos(100*i+100);
            }
        }
    }

    public void removeItem(Item toRemove){
        for(int i = 0;i<items.length;i++)
        {
            if(items[i] == toRemove){
                items[i] =  null;
            }
        }
    }
    public Item getItemOn(int ypos){
        return items[(ypos/100)-1];
    }

}

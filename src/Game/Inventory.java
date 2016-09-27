package Game;

import Visual.Item;
import Visual.Items.Key;

public class Inventory {
    public static Item[] getItems() {
        return items;
    }

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
                items[i].setYpos(35 + ((100+158) *i));
                i = items.length;
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
        if(items[(ypos/160)] != null)
            return items[(ypos/160)];
        else
            return null;
    }

}

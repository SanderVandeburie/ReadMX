package Visual;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yodi on 27/09/2016.
 */
public class View {
    private List<Item> items ;

    public String getBackground() {
        return background;
    }
    public List<Item> getItems() {
        return items;
    }

    private String background;

    public View(String backgroundpath){
        this.background = background;
        items =  new ArrayList<Item>();

    }

    public void addItem(Item item) {
        items.add(item);


    }

    public Item findItem(int x, int y){

        Item tmp = null;

        for (Item item : items)
        {
            if (x > item.getXpos() && x < (item.getXpos() + item.getWidth() ) && y < (item.getYpos() + item.getHeight()) && y > item.getYpos())
            {
               tmp = item;
            }
        }

    return  tmp;

    }



}



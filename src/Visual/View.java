package Visual;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yodi on 27/09/2016.
 */
public class View {
    private List<Item> items ;

    public Image getBackground() {
        return background;
    }
    public List<Item> getItems() {
        return items;
    }

    private Image background;

    public View(String backgroundpath){
        this.background = new Image(backgroundpath);
        items =  new ArrayList<Item>();

    }

    public void addItem(Item item) {
        items.add(item);


    }



}



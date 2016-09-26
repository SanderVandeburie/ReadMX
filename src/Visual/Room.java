package Visual;

/**
 * Created by yodi on 27/09/2016.
 */
import javafx.scene.image.Image;
public class Room {
    private int id;
    private View[] views;

    public Room(int id){
        this.id = id;
        views = new View[4];
    }

    public void setViews(View[] views){
        this.views = views;
    }

}

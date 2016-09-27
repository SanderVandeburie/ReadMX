package Visual;

import javafx.scene.image.Image;
public class Room {
    private int id;
    private View[] views;

    public void setCurrentView(int currentView) {
        this.currentView = currentView;
    }

    private int currentView;

    public Room(int id){
        this.id = id;
        views = new View[4];
    }

    public void setViews(View[] views){
        this.views = views;

    }

    public View GetCurrentView()
    {
        return views[currentView -1];
    }

}

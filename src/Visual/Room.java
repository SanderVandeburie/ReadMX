package Visual;

public class Room {

    int currentView;
    View[] views;

    public View GetCurrentView(){
        return views[currentView-1];
    }
}

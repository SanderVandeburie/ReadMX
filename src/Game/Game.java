package Game;

import Visual.Item;
import Visual.Items.Key;
import Visual.Room;
import Book.Book;
import Visual.View;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public final class Game extends Application{

    int currentRoom;
    Book book;
    Room[] rooms;
    Item currentHolding;
    Stage stage;
    Item tmp;
    private Inventory inventory;
    Group root;
    Scene theScene;
    Canvas canvas;
    GraphicsContext gc;
    Image img;

    public Game(Stage stage) throws Exception {
        this.stage = stage;
        this.inventory =  new Inventory();
        Init();
        LoadGame();




        //GetCurrentRoom().GetCurrentView().addMouseListener(this);
        //addMouseListener(this);
    }

    private void Init(){

        rooms = new Room[1];

        CreateRoom1();
        //CreateRoom2();
        //CreateRoom3();
        //CreateRoom4();
        //CreateRoom5();

    }

    private void CreateRoom1() {
        Room room = new Room(1);

        View[] views = new View[4];

        View view1 = new View("file:resources\\WallRoom1.jpg",1);

        Item item1v1 = new Item(1,880,100,"file:resources\\Door-closed.png",250,600);
        view1.addItem(item1v1);
        views[0] = view1;

        View view2 = new View("file:resources\\WallRoom1.jpg",2);

        Item item2v1 = new Item(2,100,400,"file:resources\\Desk.png",500,300);
        Item item2v2 = new Item(2,100,600,"file:resources\\Trash-with-page.png",100,50);
        view2.addItem(item2v1);
        view2.addItem(item2v2);
        views[1] = view2;

        View view3 = new View("file:resources\\WallRoom1.jpg",3);

        Item item3v1 = new Item(3,300,100,"file:resources\\Window.jpg",300,500);
        view3.addItem(item3v1);
        views[2] = view3;

        View view4 = new View("file:resources\\WallRoom1.jpg",4);

        Item item4v1 = new Item(4,880,500,"file:resources\\Vault.png",200,200);
        Item item4v2 = new Item(5,70, 200,"file:resources\\RomanPoster.png",300,200);
        view4.addItem(item4v1);
        view4.addItem(item4v2);
        views[3] = view4;

        room.setViews(views);
        rooms[0] = room;
    }
    private void CreateRoom2() {

    }
    private void CreateRoom3() {

    }
    private void CreateRoom4() {

    }
    private void CreateRoom5() {

    }

    private void LoadGame() throws Exception {
        currentRoom = 1;
        GetCurrentRoom().setCurrentView(1);
        start(stage);
    }
    @Override
    public void start(Stage theStage) throws Exception {
        root = null;
        theScene = null;
        canvas = null;
        img = null;
        gc = null;

        root = new Group();
        theScene = new Scene( root );
        canvas = new Canvas( 1280, 800);

        theStage.setTitle( "Dreadle" );
        theStage.setScene( theScene );

        root.getChildren().add( canvas );

        gc = canvas.getGraphicsContext2D();

        theScene.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                tmp = GetCurrentRoom().GetCurrentView().findItem((int) event.getX(),(int) event.getY());
                ViewChange((int) event.getX(),(int) event.getY());
                if(tmp != null)
                {
                    tmp.interactWith(currentHolding);
                };
            }
        });

        Paint();

        theStage.show();
    }
    private void Paint(){
        img = new Image(GetCurrentRoom().GetCurrentView().getBackground(),1180, 800, false, false);
        gc.drawImage( img, 0, 0 );

        for (Item item : GetCurrentRoom().GetCurrentView().getItems())
        {
            img = new Image(item.getImage(),item.getWidth(),item.getHeight(),false,false);
            gc.drawImage(img, item.getXpos(), item.getYpos());
        }

        img = new Image("file:resources\\Previous.png",150,100,false,false);
        gc.drawImage(img, 20, 650);
        img = new Image("file:resources\\Next.png",150,100,false,false);
        gc.drawImage(img, 1000, 650);
    }

    private Room GetCurrentRoom(){
        return rooms[currentRoom-1];    }

    private void ViewChange(int x, int y){
        CheckNext(x,y);
        CheckPrevious(x,y);
    }
    private void CheckPrevious(int x , int y){
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX() < 1180){
            inRoom(e);
        }
        else{
            inIventory(e);
        }


    }
    private void inIventory(MouseEvent e){
        if(currentHolding == inventory.getItemOn(e.getY())){
            currentHolding = null;
        }
        else{
            currentHolding = inventory.getItemOn(e.getY());
        }
    }
    private void inRoom(MouseEvent e){
        View currentView = GetCurrentRoom().GetCurrentView();
        Item clicked = currentView.findItem(e.getX(),e.getY());
        if(currentHolding != null){
            if(clicked.interactWith(currentHolding))
            {
                inventory.removeItem(clicked);
            }
        }
        else{
            inventory.addItem(clicked);
            currentView.dropItem(clicked);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

        private void CheckPrevious ( int x, int y)
        {
            if (y > 650 && y < 750 && x < 120 && x > 20) {
                GoPrevious();
            }
        }

    private void CheckNext(int x, int y) {
        if (y > 650 && y < 750 && x < 1100 && x > 1000) {
            GoNext();
        }
    }

    private void GoPrevious() {
        if (GetCurrentRoom().GetCurrentView().getId() == 1)
            GetCurrentRoom().setCurrentView(4);
        else
            GetCurrentRoom().setCurrentView(GetCurrentRoom().GetCurrentView().getId() - 1);

        Paint();
    }

    private void GoNext() {
        if (GetCurrentRoom().GetCurrentView().getId() == 4)
            GetCurrentRoom().setCurrentView(1);
        else
            GetCurrentRoom().setCurrentView(GetCurrentRoom().GetCurrentView().getId() + 1);

        Paint();
    }
}

}

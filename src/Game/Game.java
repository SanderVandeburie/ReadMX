package Game;

import Visual.Item;
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

public final class Game extends Application implements MouseListener{

    int currentRoom;
    Book book;
    Room[] rooms;
    Item currentHolding;
    Stage stage;
    Item tmp;

    public Game(Stage stage) {
        this.stage = stage;

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

        View[] views = new View[1];

        View view1 = new View("Wall_1");

        Item item1v1 = new Item(1,600,500,"file:resources\\Vault.png",200,200);
        Item item1v2 = new Item(1,100, 100,"file:resources\\Painting.jpg",150,300);
        view1.addItem(item1v1);
        view1.addItem(item1v2);
        views[0] = view1;

        /*View view2 = new View("Wall_2");

        Item item2v1 = new Item(1,1,1,"Chair");
        Item item2v2 = new Item(1,1,1,"Thrashcan");
        view1.addItem(item2v1);
        view1.addItem(item2v2);
        views[0] = view2;

        View view3 = new View("Wall_3");

        Item item3v1 = new Item(1,1,1,"Vault");
        view1.addItem(item3v1);
        views[0] = view3;

        View view4 = new View("Wall_1");

        Item item4v1 = new Item(1,1,1,"Coathanger");
        Item item4v2 = new Item(1,1,1,"Door");
        Item item4v3 = new Item(1,1,1,"Plant");
        view1.addItem(item4v1);
        view1.addItem(item4v2);
        view1.addItem(item4v3);
        views[0] = view4;*/

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

    private void LoadGame(){

        currentRoom = 1;
        GetCurrentRoom().setCurrentView(1);
        Draw(stage);
    }

    private void Draw(Stage theStage)
    {
        theStage.setTitle( "Canvas Example" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        theScene.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                tmp = GetCurrentRoom().GetCurrentView().findItem((int) event.getX(),(int) event.getY());
                if(tmp != null)
                {
                    tmp.interactWith(currentHolding);
                };
            }
        });

        Canvas canvas = new Canvas( 1000, 800 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image wall = new Image("file:resources\\Wall1.jpg",1000, 800, false, false);
        gc.drawImage( wall, 0, 0 );
        Image painting = new Image("file:resources\\Painting.jpg",150, 300, false, false);
        gc.drawImage( painting, 100, 100 );
        Image vault = new Image("file:resources\\Vault.png",200, 200, false, false);
        gc.drawImage( vault, 600, 500 );

        theStage.show();


    }

    private Room GetCurrentRoom(){
        return rooms[currentRoom-1];
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //GetCurrentRoom().GetCurrentView().FindItem(e.getX(),e.getY()).InteractWith();
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void start(Stage theStage) throws Exception {
          }
}

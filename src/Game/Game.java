package Game;

import Visual.Item;
import Visual.Items.CaneHolder;
import Visual.Items.Door;
import Visual.Items.Key;
import Visual.Items.Trashcan;
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

import java.awt.*;
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

        rooms = new Room[2];

        CreateRoom1();
        CreateRoom2();
    }

    private void CreateRoom1() {
        Room room = new Room(1);

        View[] views = new View[4];

        View view1 = new View("file:resources\\WallRoom1.png",1);

        Item item1v1 = new Item(480,50,"file:resources\\Door-closed.png",250,600,false,false);
        view1.addItem(item1v1);
        views[0] = view1;

        View view2 = new View("file:resources\\WallRoom1.png",2);

        Item item1v2 = new Item(150,370,"file:resources\\Desk.png",500,300,false,false);
        Item item2v2 = new Trashcan(630,570,"file:resources\\Trash-with-page.png",70,100,false,false);
        view2.addItem(item1v2);
        view2.addItem(item2v2);
        views[1] = view2;

        View view3 = new View("file:resources\\WallRoom1.png",3);

        Item item1v3 = new Item(340,100,"file:resources\\Window.png",500,400,false,false);
        view3.addItem(item1v3);
        views[2] = view3;

        View view4 = new View("file:resources\\WallRoom1.png",4);

        Item item1v4 = new Item(740,320,"file:resources\\Vault.png",250,350,false,false);
        Item item2v4 = new Item(300, 150,"file:resources\\RomanPoster.png",300,200,false,false);
        view4.addItem(item1v4);
        view4.addItem(item2v4);
        views[3] = view4;

        room.setViews(views);
        rooms[0] = room;
    }
    private void CreateRoom2() {
        Room room = new Room(1);

        View[] views = new View[4];

        View view1 = new View("file:resources\\WallRoom2.png",1);

        Item item1v1 = new Item(480,50,"file:resources\\Door-closed.png",250,600,false,false);
        Item item2v1 = new Trashcan(300,570,"file:resources\\Trash-no-page.png",70,100,false,false);
        Item item3v1 = new CaneHolder(850,370,"file:resources\\Cane-holder.png",70,300,true,false);
        view1.addItem(item1v1);
        view1.addItem(item2v1);
        view1.addItem(item3v1);
        views[0] = view1;

        View view2 = new View("file:resources\\WallRoom2.png",2);

        Item item1v2 = new Item(480,50,"file:resources\\Door-closed.png",250,600,false,false);
        view2.addItem(item1v2);
        views[1] = view2;

        View view3 = new View("file:resources\\WallRoom2.png",3);

        Item item1v3 = new Item(480,50,"file:resources\\Door-open.png",250,600,false,false);
        view3.addItem(item1v3);
        views[2] = view3;

        View view4 = new View("file:resources\\WallRoom2.png",4);

        Item item1v4 = new Door(620,100,"file:resources\\Painting-Man.png",320,440,"cane",2,false,true);
        Item item2v4 = new Item(230,100,"file:resources\\Painting-Woman.png",320,440,false,false);
        view4.addItem(item1v4);
        view4.addItem(item2v4);
        views[3] = view4;

        room.setViews(views);
        rooms[1] = room;
    }

    private void LoadGame() throws Exception {
        currentRoom = 2;
        GetCurrentRoom().setCurrentView(1);
        start(stage);
    }
    @Override
    public void start(Stage theStage) throws Exception {
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
                    Paint();
                };
            }
        });

        Paint();

        theStage.show();
    }
    private void Paint(){
        PaintRoom();
        PaintMoves();
        PaintInventory();
    }
    private void PaintInventory(){
        img = new Image("file:resources\\Inventory.png",110,800,false,false);
        gc.drawImage(img, 1170, 0);

        int i = 35;

        for (Item item : Inventory.getItems())
        {
            if(item != null)
            {
                img = new Image(item.getImage(),80,100,false,false);
                gc.drawImage(img, 1185,i);
                i += 158;
            }
        }

    }
    private void PaintMoves(){
        img = new Image("file:resources\\Previous.png",150,100,false,false);
        gc.drawImage(img, 20, 650);
        img = new Image("file:resources\\Next.png",150,100,false,false);
        gc.drawImage(img, 1000, 650);
    }
    private void PaintRoom(){
        img = new Image(GetCurrentRoom().GetCurrentView().getBackground(),1180, 800, false, false);
        gc.drawImage( img, 0, 0 );

        for (Item item : GetCurrentRoom().GetCurrentView().getItems())
        {
            img = new Image(item.getImage(),item.getWidth(),item.getHeight(),false,false);
            gc.drawImage(img, item.getXpos(), item.getYpos());
        }
    }

    private Room GetCurrentRoom(){
        return rooms[currentRoom-1];    }

    private void ViewChange(int x, int y){
        CheckNext(x,y);
        CheckPrevious(x,y);
        CheckInventory(x,y);
    }
    private void CheckInventory(int x , int y){

        if(x < 1180){
            inRoom(x,y);
        }
        else{
            inIventory(y);
        }


    }
    private void inIventory(int y){
        currentHolding = inventory.getItemOn(y);
    }
    private void inRoom(int x,int y){
        View currentView = GetCurrentRoom().GetCurrentView();
        Item clicked = currentView.findItem(x,y);
        if(clicked != null){
            if(currentHolding != null){
                if(clicked.interactWith(currentHolding))
                {
                    inventory.removeItem(clicked);
                }
            }
            else if(clicked.isCollectable()){
                inventory.addItem(clicked.GetItem());
                if(clicked.isDropable())
                currentView.dropItem(clicked);
            }
        }

    }
    private void CheckPrevious(int x , int y){
        if (y > 650 && y < 750 && x < 120 && x > 20)
        {
            GoPrevious();
        }
    }
    private void CheckNext(int x , int y){
        if (y > 650 && y < 750 && x < 1100 && x > 1000)
        {
            GoNext();
        }
    }
    private void GoPrevious(){
        if(GetCurrentRoom().GetCurrentView().getId() == 1)
            GetCurrentRoom().setCurrentView(4);
        else
            GetCurrentRoom().setCurrentView(GetCurrentRoom().GetCurrentView().getId()-1);

        Paint();
    }
    private void GoNext(){
        if(GetCurrentRoom().GetCurrentView().getId() == 4)
            GetCurrentRoom().setCurrentView(1);
        else
            GetCurrentRoom().setCurrentView(GetCurrentRoom().GetCurrentView().getId()+1);

        Paint();
    }


}

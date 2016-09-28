package Game;

import Visual.Item;
import Visual.Items.*;
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
    Room[] rooms;
    Item currentHolding;
    Stage stage;
    Item tmp;
    Group root;
    Scene theScene;
    Canvas canvas;
    GraphicsContext gc;
    Image img;
    Player player;

    public Game(Stage stage) throws Exception {
        this.stage = stage;
        player =  new Player();
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

        Item item1v1 = new Item(480,50,"file:resources\\Door-closed.png",250,600);
        view1.addItem(item1v1);
        //view1.addItem(item2v1);
        views[0] = view1;

        View view2 = new View("file:resources\\WallRoom1.png",2);

        Item item1v2 = new Item(150,370,"file:resources\\Desk.png",500,300);
        Item item2v2 = new Trashcan(630,570,"file:resources\\Trash-with-page.png",70,100,"file:resources\\p2.jpg");
        view2.addItem(item1v2);
        view2.addItem(item2v2);
        //view2.addItem(item3v2);
        views[1] = view2;

        View view3 = new View("file:resources\\WallRoom1.png",3);

        Item item1v3 = new Item(340,100,"file:resources\\Window.png",500,400);
        view3.addItem(item1v3);
        views[2] = view3;

        View view4 = new View("file:resources\\WallRoom1.png",4);

        Item item1v4 = new Item(740,320,"file:resources\\Vault.png",250,350);
        Item item2v4 = new Item(300, 150,"file:resources\\RomanPoster.png",300,200);
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

        Item item1v1 = new Item(480,50,"file:resources\\Door-closed.png",250,600);
        Item item2v1 = new Trashcan(300,570,"file:resources\\Trash-with-page.png",70,100,"file:resources\\p17.jpg");
        Item item3v1 = new CaneHolder(850,370,"file:resources\\Cane-holder.png",70,300);
        view1.addItem(item1v1);
        view1.addItem(item2v1);
        view1.addItem(item3v1);
        views[0] = view1;

        View view2 = new View("file:resources\\WallRoom2.png",2);

        Item item1v2 = new Item(480,50,"file:resources\\Door-closed.png",250,600);
        view2.addItem(item1v2);
        views[1] = view2;

        View view3 = new View("file:resources\\WallRoom2.png",3);

        Item item1v3 = new Item(480,50,"file:resources\\Door-open.png",250,600);
        view3.addItem(item1v3);
        views[2] = view3;

        View view4 = new View("file:resources\\WallRoom2.png",4);

        Key key = new Key(1,1,"file:resources\\Key.bmp","B");

        Item item1v4 = new Painting(620,100,"file:resources\\Painting-Man.png",320,440,"cane");
        Item item2v4 = new Item(230,100,"file:resources\\Painting-Woman.png",320,440);
        view4.addItem(item1v4);
        view4.addItem(item2v4);
        views[3] = view4;

        room.setViews(views);
        rooms[1] = room;
    }

    private void LoadGame() throws Exception {
        currentRoom = 1;
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
                //todo kijken waar word geklikt
                int x =  (int)event.getX();
                int y =  (int)event.getY();
                if (CheckInventory(x,y));
                else if(CheckPrevious(x,y));
                else if(CheckNext(x,y));
                else if(CheckBook(x,y));
                else{
                    // view
                    View  currentView = GetCurrentRoom().GetCurrentView();
                    Item item = currentView.findItem((int) event.getX(),(int) event.getY());
                    if(currentHolding == null)
                    {
                       if(item.clicked()){
                           {
                                currentView.dropItem(item);
                           }
                       }
                    }
                    else
                    {
                        if(item.interactWith(currentHolding)){
                            currentView.dropItem(item);

                        }

                    }

                }
                    Paint();
            }
        });
        Paint();

        theStage.show();
    }


    private void Paint(){
        PaintRoom();
        PaintMoves();
        PaintInventory();
        PaintBookIcon();
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
    private void PaintBookIcon(){
        Book book = Player.getBook();
        Image img =  new Image(book.getImage());
//        img = new Image("file:resources\\Bookcover.png",980,600,false,false);
       gc.drawImage(img, book.getX(), book.getY(),book.getWidth(),book.getHeight());
    }
    private void PaintRoom(){
        View currentView = GetCurrentRoom().GetCurrentView();
        img = new Image(currentView.getBackground(),1180, 800, false, false);
        gc.drawImage( img, 0, 0 );

        for (Item item : currentView.getItems())
        {
            img = new Image(item.getImage(),item.getWidth(),item.getHeight(),false,false);
            gc.drawImage(img, item.getXpos(), item.getYpos());
        }
    }


    private Room GetCurrentRoom(){
        return rooms[currentRoom-1];    }

    private Boolean CheckPrevious(int x , int y){
        if (y > 650 && y < 750 && x < 170 && x > 20)
        {
            GoPrevious();
            return true;
        }
        return false;
    }
    private Boolean CheckNext(int x , int y){
        if (y > 650 && y < 750 && x < 1150 && x > 1000)
        {
            GoNext();
            return true;
        }
        return false;
    }
    private Boolean CheckInventory(int x , int y){
        if(x > 1180){
            inIventory(y);
            return true;
        }
        return false;
    }
    private Boolean CheckBook(int x, int y){
         Book book = Player.getBook();
        if (y > book.getY() && y < book.getY()+book.getHeight() && x < book.getX()+book.getWidth() && x > book.getX())
        {
            book.clickBook();
            return true;
        }
        return false;
    }


    private void inIventory(int y){
        Item item =  Player.getItemFromInventory(y);
        if (item != null) {
            if(currentHolding == item)
            {
                if (currentHolding instanceof Key) {
                    Key tmp = (Key) currentHolding;
                    tmp.select();
                }
                currentHolding = null;
            }
            else{
                currentHolding = Player.getItemFromInventory(y);
                if (currentHolding instanceof Key) {
                    Key tmp = (Key) currentHolding;
                    tmp.select();
                }
            }

        }

    }
    private void inRoom(int x,int y){
        View currentView = GetCurrentRoom().GetCurrentView();
        Item clicked = currentView.findItem(x,y);
        if(clicked != null){
            if(currentHolding != null){
                if(clicked.interactWith(currentHolding))
                {
                    CheckDoors((Door) clicked);
                    //CheckPaintings((Painting) clicked);
                }
            }
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

    private void CheckDoors(Door door)
    {
        if(door.getOpen())
            currentRoom = door.getNextRoom();
        Paint();
    }


}

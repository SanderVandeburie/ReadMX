package Game;

import Visual.Item;
import Visual.Room;
import Book.Book;
import Visual.View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public final class Game implements MouseListener{

    int currentRoom;
    Book book;
    Room[] rooms;
    Item currentHolding;

    public void Game()
    {
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

        View view1 = new View("Wall_1");

        Item item1v1 = new Item(1,1,1,"Vault");
        Item item1v2 = new Item(1,1,1,"Painting");
        view1.addItem(item1v1);
        view1.addItem(item1v2);
        views[0] = view1;

        View view2 = new View("Wall_2");

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
        views[0] = view4;

        room.setViews(views);
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
        Draw();
    }

    private void Draw()
    {
        GetCurrentRoom().GetCurrentView().getBackground();

        for (Item item : GetCurrentRoom().GetCurrentView().getItems())
        {
            item.getImage();
        }
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
}

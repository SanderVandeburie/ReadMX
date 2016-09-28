package Game;
import Book.Book;
import Visual.Item;


/**
 * Created by yodi on 27/09/2016.
 */
public class Player {
    private static Inventory inventory;
    private static Book book;

    public Player(){
        inventory =  new Inventory();
        book = new Book();
    }

    public static void addToInventory(Item item){
        inventory.addItem(item);
    }
    public static Item getItemFromInventory(int ypos){return inventory.getItemOn(ypos);}
    public static void removeItem(Item item){
        inventory.removeItem(item);
    }
    public static void addPage(String path){
        book.insertPage(path);
    }
    public static Book getBook()
    {
        return book;
    }
}

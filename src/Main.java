import Game.Game;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static final void main(String[] args)  {
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Game game = new Game(primaryStage);
    }
}


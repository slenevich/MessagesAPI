package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.dummy.DummyMainPanel;
import sample.dummy.DummyMessages;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        DummyMessages dm = new DummyMessages();
        dm.populate();
        DummyMainPanel parentPanel = new DummyMainPanel();




        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
       // Scene primaryScene = new Scene(root, 800, 600);
        Scene primaryScene = new Scene(parentPanel.getMainPane(), 800, 600);

        primaryScene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>
                () {

            @Override
            public void handle(KeyEvent t) {
                if(t.getCode()== KeyCode.ESCAPE)
                {
                    System.out.println("click on escape");

                    primaryStage.close();
                }
            }
        });




        primaryStage.setTitle("Hello World");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


/*
Image imageDecline = new Image(getClass().getResourceAsStream("not.png"));
Button button5 = new Button();
button5.setGraphic(new ImageView(imageDecline));
 */
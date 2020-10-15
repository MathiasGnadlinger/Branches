import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Mathias Gnadlinger
 * @version 1.5, 15.10.2020
 */
public class Main extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }
    @Override
    public void start (Stage stage)
    {
        VBox main_box = new VBox();
        ObservableList data_list = main_box.getChildren();

        EventHandler<MouseEvent> addHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
            }
        };

        EventHandler<MouseEvent> saveHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
            }

        };

        //Creating a Scene
        Scene scene = new Scene(main_box);
        //Setting tittle to the scene
        stage.setTitle("Shopping List");
        //Adding the scene to the group
        stage.setScene(scene);
        //Displaying the conntents of a scene
        stage.show();
    }
}

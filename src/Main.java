import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

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
        main_box.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        ObservableList input = main_box.getChildren();
        ObservableList buttons = main_box.getChildren();
        

        Label lb1 = new Label("Grad Celsius");
            lb1.setStyle("-fx-font-size:26;-fx-font-weight: bold");
        TextField tf1 = new TextField();
            tf1.appendText("0");
            tf1.setStyle("-fx-font-size: 16");

        Label lb2 = new Label("Grad Fahrenheit");
            lb2.setStyle("-fx-font-size:26;-fx-font-weight: bold");
        TextField tf2 = new TextField();
            tf2.appendText("0");
            tf2.setStyle("-fx-font-size: 16");

        input.addAll(lb1,tf1,lb2,tf2);


        Button b1 = new Button("Convert C -> F");
            b1.setStyle("-fx-font-size:12");

        Button b2 = new Button("Convert F -> C");
            b2.setStyle("-fx-font-size:12");

        buttons.addAll(b1,b2);


        EventHandler<MouseEvent> CtoF = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                double fahrenheit = 0;
                double celsius = 0;

                try
                {
                    celsius = Double.parseDouble(tf1.getText());
                }
                catch (Exception ex)
                {
                    System.out.printf("Falsche Eingabe%n");
                }

                fahrenheit = 1.8 * celsius + 32;

               tf2.setText(Double.toString(fahrenheit) + " Grad Fahrenheit");
            }
        };

        EventHandler<MouseEvent> FtoC = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {

                double fahrenheit = 0;
                double celsius = 0;

                try
                {
                    fahrenheit = Double.parseDouble(tf2.getText());
                }
                catch (Exception ex)
                {
                    System.out.printf("Falsche Eingabe%n");
                }

                celsius = 0.5555555555 * (fahrenheit - 32);

                tf1.setText(Double.toString(celsius) + " Grad Celsius");
            }
        };

        b1.addEventHandler(MouseEvent.MOUSE_CLICKED,CtoF);
        b2.addEventHandler(MouseEvent.MOUSE_CLICKED,FtoC);


        //Creating a Scene
        Scene scene = new Scene(main_box,300,300);
        //Setting tittle to the scene
        stage.getIcons().add(new Image("TM.jpg"));
        stage.setTitle("Temperature Converter");
        //Adding the scene to the group
        stage.setScene(scene);
        //Displaying the conntents of a scene
        stage.show();
    }
}

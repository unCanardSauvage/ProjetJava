//package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//import javafx.scene.Parent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group root = new Group();
        primaryStage.setTitle("Echecs");
        primaryStage.setScene(new Scene(root, 600, 600, Color.GHOSTWHITE));
        //Affichage affichage = new Affichage(primaryStage);
        //root.getChildren().add(affichage);;
        Menu menu = new Menu(primaryStage);
        root.getChildren().add(menu);

        primaryStage.show();
    }







    public static void main(String[] args) {

        launch(args);

        Main monProjet = new Main();
        //monProjet.creationPlateau();



    }



}

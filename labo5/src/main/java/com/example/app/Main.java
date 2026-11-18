package com.example.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charge le fichier FXML depuis le dossier resources
        URL fxmlLocation = getClass().getResource("fenetre_principale.fxml");
        
        if (fxmlLocation == null) {
            throw new IllegalStateException("Impossible de trouver fenetre_principale.fxml. Assurez-vous qu'il est dans src/main/resources/com/example/app/");
        }

        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();

        // Crée la scène avec une taille par défaut (ex: 800x600)
        Scene scene = new Scene(root, 800, 600);
        
        // Configure et affiche la fenêtre
        primaryStage.setTitle("Laboratoire MVC -Image et perspectives");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
package it.polito.tdp.libretto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.channels.NonReadableChannelException;

import it.polito.tdp.libretto.model.Libretto;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
    	
    	//Crea scena e controller e li collega tra loro
    	FXMLLoader loader = new FXMLLoader(App.class.getResource("main.fxml")) ;
    	Parent root = loader.load();
    	Scene scene = new Scene(root) ;
    	
    	//Collego model e controller
    	Libretto modelLibretto = new Libretto();
    	Controller controller = loader.getController();
    	controller.setModel(modelLibretto);

    	stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
    	System.out.println("Launching app...");
        launch();
    }

}
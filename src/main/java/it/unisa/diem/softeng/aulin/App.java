package it.unisa.diem.softeng.aulin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        String javaVersion = SystemInfo.javaVersion();
        String javafxVersion = SystemInfo.javafxVersion();

        Label label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Label marioLabel = new Label("evidentemente, questo commit è banale");
        Label manuLabel = new Label("https://www.youtube.com/watch?v=dQw4w9WgXcQ");

        VBox root = new VBox(10, label, marioLabel, manuLabel);
        root.setAlignment(javafx.geometry.Pos.CENTER);
        
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
package sahan.abr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sahan.abr.local.WriteLocalData;
import sahan.abr.network.ClientConnection;

public class Main extends Application {

    public static ClientConnection connection = new ClientConnection();
    public static WriteLocalData writeLocalData = new WriteLocalData();
    public static final String urlAddress = "http://localhost:8080";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/srm.fxml"));
        primaryStage.setTitle("SRM System");
        primaryStage.setScene(new Scene((root)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

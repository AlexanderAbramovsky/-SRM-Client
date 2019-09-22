package sahan.abr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sahan.abr.local.WriteLocalData;
import sahan.abr.network.ClientConnection;
import sahan.abr.network.ParentConnection;

public class Main extends Application {

    public static ClientConnection connection = new ClientConnection();
    public static ParentConnection connectionParent = new ParentConnection();

    public static WriteLocalData writeLocalData = new WriteLocalData();
    public static final String urlAddress = "http://localhost:8080";
    public static Stage MAIN_STAGE;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        MAIN_STAGE = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/srm.fxml"));
        primaryStage.setTitle("SRM System");
        primaryStage.setScene(new Scene((root)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

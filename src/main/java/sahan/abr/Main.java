package sahan.abr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sahan.abr.TEST.MainController;
import sahan.abr.TEST.VistaNavigator;
import sahan.abr.local.WriteLocalData;
import sahan.abr.network.ClientConnection;
import sahan.abr.network.ParentConnection;

import java.io.IOException;

public class Main extends Application {

    public static ClientConnection connection = new ClientConnection();
    public static ParentConnection connectionParent = new ParentConnection();

    public static WriteLocalData writeLocalData = new WriteLocalData();
    public static final String urlAddress = "http://localhost:8080";
    public static Stage MAIN_STAGE;

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("SRM");
        stage.setScene(createScene(loadMainPane()));
        MAIN_STAGE = stage;
        stage.show();
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(VistaNavigator.MAIN)
        );

        MainController mainController = loader.getController();

        VistaNavigator.setMainController(mainController);
        VistaNavigator.loadVista(VistaNavigator.VISTA2);

        return mainPane;
    }

    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        return scene;
    }

    /*@Override
    public void start(final Stage primaryStage) throws Exception {
        MAIN_STAGE = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/test.fxml"));
        primaryStage.setTitle("SRM System");
        primaryStage.setScene(new Scene((root)));
        primaryStage.show();
    }
*/
    public static void main(String[] args) {
        launch(args);
    }
}

package sahan.abr;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sahan.abr.fx.controllers.MainController;
import sahan.abr.fx.controllers.Navigator;
import sahan.abr.entities.*;

import java.io.IOException;

public class Main extends Application {

    public static ObservableList<String> observableListPosition = FXCollections.observableArrayList();
    public static ObservableList<String> observableListPoll = FXCollections.observableArrayList();

    public static ObservableList<Employee> observableListEmployees = FXCollections.observableArrayList();
    public static ObservableList<Subscription> observableListSubscriptions = FXCollections.observableArrayList();
    public static ObservableList<Customer> observableListCustomers = FXCollections.observableArrayList();

//    public static ClientConnection connection = new ClientConnection();
//    public static ParentConnection connectionParent = new ParentConnection();
//
//    public static WriteLocalData writeLocalData = new WriteLocalData();
    public static final String urlAddress = "http://localhost:8080";
    public static Stage MAIN_STAGE;

    @Override
    public void start(Stage stage) throws Exception{

        observableListPoll.add("Большой");
        observableListPoll.add("Средний");
        observableListPoll.add("Маленький");
        //observableListPoll.add("Маленький");
        //observableListPoll.add("Маленький");

        // Добавляем для теста
        observableListPosition.add("Тренер");
        Employee employee = new Employee(0, "Абрамовский", "Александр",
                "Владимирович", "Тренер", "89237795552");
        DateJobEmployee dateJobEmployee = new DateJobEmployee("11:00",
                "19:00", "10.10.19", "Большой");
        employee.getTimetable().put(4, dateJobEmployee);
        observableListEmployees.add(employee);

        Subscription subscription = new Subscription(0, "Премиум", 1000,
                30, 12);
        observableListSubscriptions.add(subscription);

        Parent parent = new Parent(0, "Абрамовский", "Александр",
                "Владимирович", "НЕТ", "123123", "22.10.19", "89237795552", "89237795552",
                "sahan.abr@yandex.ru", "НЕТ", true, true, true, "0");

        Customer customer = new Customer(parent);
        observableListCustomers.add(customer);

        stage.setTitle("SRM");
        stage.setScene(createScene(loadMainPane()));
        MAIN_STAGE = stage;
        stage.show();
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(Navigator.MAIN)
        );

        MainController mainController = loader.getController();

        Navigator.setMainController(mainController);
        Navigator.loadVista(Navigator.SUBSCRIPTION);

        return mainPane;
    }

    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        scene.getStylesheets().add("./css/bootstrap3.css");
        scene.getStylesheets().add("./css/buttons.css");
        scene.getStylesheets().add("./css/titledPane.css");
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

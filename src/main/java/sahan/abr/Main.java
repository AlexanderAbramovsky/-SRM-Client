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
import sahan.abr.repository.EmployeeRepository;
import sahan.abr.repository.ScheduleRepository;
import sahan.abr.repository.SubscriptionRepository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {

    private final static String FOR_NAME = "org.sqlite.JDBC";
    private final static String URL = "jdbc:sqlite:testDB.s3db";

    public static SubscriptionRepository subscriptionRepository;
    public static EmployeeRepository employeeRepository;
    public static ScheduleRepository scheduleRepository;

    public static ObservableList<String> observableListPosition = FXCollections.observableArrayList();
    public static ObservableList<String> observableListPoll = FXCollections.observableArrayList();

    public static ObservableList<Employee> observableListEmployees = FXCollections.observableArrayList();
    public static ObservableList<Subscription> observableListSubscriptions = FXCollections.observableArrayList();
    public static ObservableList<Customer> observableListCustomers = FXCollections.observableArrayList();

    public static final String urlAddress = "http://localhost:8080";
    public static Stage MAIN_STAGE;

    @Override
    public void start(Stage stage) throws Exception{

        observableListPoll.add("Большой");
        observableListPoll.add("Средний");
        observableListPoll.add("Маленький");

        observableListPosition.add("Тренер");

        Parent parent = new Parent(0, "???????????", "?????????",
                "????????????", "???", "123123", "22.10.19", "89237795552", "89237795552",
                "sahan.abr@yandex.ru", "???", true, true, true, "0");

        Customer customer = new Customer(parent);
        observableListCustomers.add(customer);

        stage.setTitle("SRM");
        stage.setScene(createScene(loadMainPane()));
        MAIN_STAGE = stage;
        stage.show();
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = loader.load(
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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName(FOR_NAME);
        Connection connection = DriverManager.getConnection(URL);

        subscriptionRepository = new SubscriptionRepository();
        employeeRepository = new EmployeeRepository();
        scheduleRepository = new ScheduleRepository();

        launch(args);
    }
}

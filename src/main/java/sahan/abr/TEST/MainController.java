package sahan.abr.TEST;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class MainController {

    @FXML
    private StackPane vistaHolder;

    public void setVista(Node node) {
        vistaHolder.getChildren().setAll(node);
    }

    @FXML
    void actionTimeTable(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.TIMETABLE);
    }

    @FXML
    void actionEmployees(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.EMPLOYEES);
    }

    @FXML
    void actionVista2(ActionEvent event) {
        VistaNavigator.loadVista(VistaNavigator.VISTA2);
    }

}
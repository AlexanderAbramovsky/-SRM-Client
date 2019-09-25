package sahan.abr.controllers;

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
        Navigator.loadVista(Navigator.TIMETABLE);
    }

    @FXML
    void actionSubscription(ActionEvent event) {
        Navigator.loadVista(Navigator.SUBSCRIPTION);
    }

    @FXML
    void actionEmployees(ActionEvent event) {
        Navigator.loadVista(Navigator.EMPLOYEE);
    }

    @FXML
    void actionVista2(ActionEvent event) {
        Navigator.loadVista(Navigator.VISTA2);
    }

}
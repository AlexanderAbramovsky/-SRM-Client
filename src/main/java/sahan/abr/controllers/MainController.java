package sahan.abr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class MainController {

    @FXML
    private Button buttonTimeTable;

    @FXML
    private Button buttonSubscription;

    @FXML
    private Button buttonEmployees;


    @FXML
    private StackPane vistaHolder;

    public void setVista(Node node) {
        vistaHolder.getChildren().setAll(node);
    }

    @FXML
    void actionTimeTable(ActionEvent event) {
        Navigator.loadVista(Navigator.TIMETABLE);
        buttonTimeTable.setStyle("-fx-border-color: aliceblue; -fx-border-width : 3px");
        buttonSubscription.setStyle("-fx-border-color: none; -fx-border-width : 3px");
        buttonEmployees.setStyle("-fx-border-color: none; -fx-border-width : 3px");
    }

    @FXML
    void actionSubscription(ActionEvent event) {
        Navigator.loadVista(Navigator.SUBSCRIPTION);
        buttonTimeTable.setStyle("-fx-border-color: none; -fx-border-width : 3px");
        buttonSubscription.setStyle("-fx-border-color: aliceblue; -fx-border-width : 3px");
        buttonEmployees.setStyle("-fx-border-color: none; -fx-border-width : 3px");
    }

    @FXML
    void actionEmployees(ActionEvent event) {
        Navigator.loadVista(Navigator.EMPLOYEE);
        buttonTimeTable.setStyle("-fx-border-color: none; -fx-border-width : 3px");
        buttonSubscription.setStyle("-fx-border-color: none; -fx-border-width : 3px");
        buttonEmployees.setStyle("-fx-border-color: aliceblue; -fx-border-width : 3px");
    }

    @FXML
    void actionVista2(ActionEvent event) {
        Navigator.loadVista(Navigator.VISTA2);
    }

}
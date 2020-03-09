package sahan.abr.fx.controllers.employees;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sahan.abr.entities.Employee;

import static sahan.abr.Main.observableListEmployees;
import static sahan.abr.Main.observableListPosition;

public class ModalAddEmployeeController {

    @FXML
    private TextField textFieldSurname;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldMiddleName;

    @FXML
    private ComboBox<String> comboBoxPosition;

    @FXML
    private TextField textFieldPhoneNumber;

    @FXML
    private Button saveButton;

    @FXML
    private void initialize() {
        comboBoxPosition.setItems(observableListPosition);
    }

    @FXML
    void saveEmployee(ActionEvent event) {

        observableListEmployees.add(new Employee(0, textFieldSurname.getText(), textFieldName.getText(), textFieldMiddleName.getText(),
                comboBoxPosition.getValue(), textFieldPhoneNumber.getText()));

        // get a handle to the stage
        Stage stage = (Stage) saveButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}

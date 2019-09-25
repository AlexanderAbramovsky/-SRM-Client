package sahan.abr.controllers.employees;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sahan.abr.entities.Employee;

import static sahan.abr.controllers.employees.EmployeesController.observableListEmployees;

public class ModalAddEmployeeController {


    @FXML
    private TextField textFieldSurname;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldMiddleName;

    @FXML
    private TextField textFieldPosition;

    @FXML
    private TextField textFieldPhoneNumber;

    @FXML
    private Button saveButton;

    @FXML
    void saveEmployee(ActionEvent event) {

        observableListEmployees.add(new Employee(0, textFieldSurname.getText(), textFieldName.getText(), textFieldMiddleName.getText(),
                textFieldPosition.getText(), textFieldPhoneNumber.getText()));

        // get a handle to the stage
        Stage stage = (Stage) saveButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}

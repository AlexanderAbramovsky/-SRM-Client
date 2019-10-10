package sahan.abr.controllers.employees;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sahan.abr.entities.Employee;

public class ModalUpdateEmployeeController {

    @FXML
    private Label labelEmployee;

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
    private Button updateButton;

    private Employee employee;
    private EmployeesController employeesController;
    private boolean information;

    public ModalUpdateEmployeeController(Employee employee, EmployeesController employeesController) {
        this.employee = employee;
        this.employeesController = employeesController;
    }

    public ModalUpdateEmployeeController(Employee employee, boolean information) {
        this.employee = employee;
        this.information = information;
    }

    @FXML
    private void initialize() {
        textFieldSurname.setText(employee.getSurname());
        textFieldName.setText(employee.getName());
        textFieldMiddleName.setText(employee.getMiddleName());
        textFieldPosition.setText(employee.getPosition());
        textFieldPhoneNumber.setText(employee.getPhoneNumber());

        if (information) {
            updateButton.setVisible(false);
            labelEmployee.setText("Информация о сотруднике");
        }
    }

    @FXML
    void updateEmployee(ActionEvent event) {

        employee.setSurname(textFieldSurname.getText());
        employee.setName(textFieldName.getText());
        employee.setMiddleName(textFieldMiddleName.getText());
        employee.setPosition(textFieldPosition.getText());
        employee.setPhoneNumber(textFieldPhoneNumber.getText());

        employeesController.getTableViewEmployees().refresh();

        // get a handle to the stage
        Stage stage = (Stage) updateButton.getScene().getWindow();
        // do what you have to do
        stage.close();

    }

}

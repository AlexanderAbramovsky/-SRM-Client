package sahan.abr.controllers;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import sahan.abr.entities.Employee;

import static sahan.abr.Main.connection;

public class EmployeesController {


    @FXML
    private StackPane employees;

    @FXML
    private TextField fioField;

    @FXML
    private TextField positionField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Button addEmployeeButton;

    @FXML
    private TextField searchEmployeesField;

    @FXML
    private Button searchEmployeesButton;

    @FXML
    private Button resetEmployeesButton;

    @FXML
    private Button deleteEmployee;

    @FXML
    private Button removeEmployeeButton;

    @FXML
    private TableView<Employee> employeesTable;

    @FXML
    private TableColumn<Employee, Boolean> deleteColumn;

    @FXML
    private TableColumn<Employee, String> fioColumn;

    @FXML
    private TableColumn<Employee, String> positionColumn;

    @FXML
    private TableColumn<Employee, String> phoneNumberColumn;

    private ObservableList<Employee> employeesData;

    private boolean deleteColumnFlag = true;

    @FXML
    private void initialize() {

        deleteColumn.setVisible(false);
        deleteColumn.setCellFactory( tc -> new CheckBoxTableCell<Employee, Boolean>());

        // При редактировании в ячейке (для столбца Удалить)
        deleteColumn.setCellValueFactory(param -> {
            Employee person = param.getValue();

            SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(person.getDeleteEmployee());

            booleanProp.addListener((observable, oldValue, newValue) -> {
                person.setDeleteEmployee(newValue);
            });
            return booleanProp;
        });
        //_______________

        employeesTable.setEditable(true);

        employeesData = employeesTable.getItems();
        connection.getEmployees(employeesData);

        System.out.println(employeesData.size());

        employeesTable.setItems(employeesData);
        employeesTable.setVisible(true);

        fioColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("fio"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("phoneNumber"));

        fioColumn.setCellFactory(TextFieldTableCell.<Employee> forTableColumn());
        positionColumn.setCellFactory(TextFieldTableCell.<Employee> forTableColumn());
        phoneNumberColumn.setCellFactory(TextFieldTableCell.<Employee> forTableColumn());

        // При редактировании в ячейке (для столбца Инициалы)
        fioColumn.setOnEditCommit((TableColumn.CellEditEvent<Employee, String> event) -> {
            TablePosition<Employee, String> position = event.getTablePosition();

            String newFullName = event.getNewValue();

            int row = position.getRow();
            Employee employee = event.getTableView().getItems().get(row);

            employee.setFio(newFullName);

            connection.updateEmployee(employee);
        });

        // При редактировании в ячейке (для столбца Должность)
        positionColumn.setOnEditCommit((TableColumn.CellEditEvent<Employee, String> event) -> {
            TablePosition<Employee, String> position = event.getTablePosition();

            String newPosition = event.getNewValue();

            int row = position.getRow();
            Employee employee = event.getTableView().getItems().get(row);

            employee.setPosition(newPosition);

            connection.updateEmployee(employee);
        });

        // При редактировании в ячейке (для столбца Номер телефона)
        phoneNumberColumn.setOnEditCommit((TableColumn.CellEditEvent<Employee, String> event) -> {
            TablePosition<Employee, String> position = event.getTablePosition();

            String newPhoneNumber = event.getNewValue();

            int row = position.getRow();
            Employee employee = event.getTableView().getItems().get(row);

            employee.setPhoneNumber(newPhoneNumber);

            connection.updateEmployee(employee);
        });
    }

    private void deleteEmployees() {
        if (deleteColumnFlag) {
            deleteColumn.setVisible(true);
            removeEmployeeButton.setVisible(true);
            deleteColumnFlag = false;
        } else {
            deleteColumn.setVisible(false);
            removeEmployeeButton.setVisible(false);
            deleteColumnFlag = true;
        }
    }

    @FXML
    void addEmployee(ActionEvent event) {
        Employee employee = connection.addEmployee(fioField.getText(), positionField.getText(), phoneNumberField.getText());
        employeesData.add(employee);

        employeesTable.setItems(employeesData);
    }

    @FXML
    void actionDeleteButton(ActionEvent event) {
        deleteEmployees();
    }

    @FXML
    void removeEmployee(ActionEvent event) {
        ObservableList<Employee> newEmployeesData = FXCollections.observableArrayList();

        for (Employee employee : employeesData) {
            if (employee.getDeleteEmployee()){
                connection.removeEmployee(employee.getId());
            } else {
                newEmployeesData.add(employee);
            }
        }

        employeesData = newEmployeesData;

        employeesTable.setItems(employeesData);
        deleteEmployees();
    }

    @FXML
    void resetEmployees(ActionEvent event) {
        employeesTable.setItems(employeesData);
    }

    @FXML
    void searchEmployees(ActionEvent event) {

        String value = searchEmployeesField.getText();

        if (value==null || value.isEmpty()){
            employeesTable.setItems(employeesData);
        } else {
            ObservableList<Employee> employeesSearch = FXCollections.observableArrayList();

            for (Employee employee : employeesData) {
                if (employee.getFio().equals(value)){
                    employeesSearch.add(employee);
                }
            }

            employeesTable.setItems(employeesSearch);
        }
    }

}

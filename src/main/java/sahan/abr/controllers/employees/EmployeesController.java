package sahan.abr.controllers.employees;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import sahan.abr.entities.Employee;

import static sahan.abr.Main.connection;

public class EmployeesController {

    private TableView<Employee> employeesTable;
    private ObservableList<Employee> employeesData;

    private TableColumn<Employee, Boolean> deleteColumn;

    private Button removeEmployeeButton;

    private boolean deleteColumnFlag = true;

    public EmployeesController(TableView<Employee> employeesTable,
                               TableColumn<Employee, Boolean> deleteColumn,
                               TableColumn<Employee, String> initialsColumn,
                               TableColumn<Employee, String> positionColumn,
                               TableColumn<Employee, String> phoneNumberColumn,
                               Button removeEmployeeButton){

        this.employeesData = employeesTable.getItems();
        this.employeesTable = employeesTable;
        this.deleteColumn = deleteColumn;
        this.removeEmployeeButton = removeEmployeeButton;

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

        connection.getEmployees(employeesData);
        employeesTable.setItems(employeesData);

        employeesTable.setEditable(true);


        initialsColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("fio"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("phoneNumber"));

        initialsColumn.setCellFactory(TextFieldTableCell.<Employee> forTableColumn());
        positionColumn.setCellFactory(TextFieldTableCell.<Employee> forTableColumn());
        phoneNumberColumn.setCellFactory(TextFieldTableCell.<Employee> forTableColumn());

        // При редактировании в ячейке (для столбца Инициалы)
        initialsColumn.setOnEditCommit((TableColumn.CellEditEvent<Employee, String> event) -> {
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

    public void resetEmployees(){
        employeesTable.setItems(employeesData);
    }

    public void searchEmployees(String value) {

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

    public void deleteEmployees() {
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

    public void removeEmployees(){
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

    public void addEmployee( String fio, String position, String phoneNumber){
        Employee employee = connection.addEmployee(fio, position, phoneNumber);
        employeesData.add(employee);
    }
}

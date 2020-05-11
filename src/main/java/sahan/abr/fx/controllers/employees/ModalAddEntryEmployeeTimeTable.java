package sahan.abr.fx.controllers.employees;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sahan.abr.entities.DateJobEmployee;
import sahan.abr.entities.Employee;

import static sahan.abr.Main.observableListPoll;

public class ModalAddEntryEmployeeTimeTable {

    @FXML
    private ComboBox<String> comboBoxPoll;

    @FXML
    private TextField textFieldStart;

    @FXML
    private TextField textFieldEnd;

    @FXML
    private Button buttonSaveEntry;

    @FXML
    void saveEntry(ActionEvent event) {

        DateJobEmployee dateJobEmployee = null;

        if (update) {
            dateJobEmployee =  employee.getTimetable().get(dayOfWeek);
            dateJobEmployee.setStartTime(textFieldStart.getText());
            dateJobEmployee.setEndTime(textFieldEnd.getText());
            dateJobEmployee.setPool(comboBoxPoll.getValue());
        } else {
            dateJobEmployee = new DateJobEmployee(textFieldStart.getText(),
                    textFieldEnd.getText(), dateJob, comboBoxPoll.getValue());
            employee.getTimetable().put(dayOfWeek, dateJobEmployee);
        }

        vBox.getChildren().removeAll(vBox.getChildren());
        EmployeesTimeTableController.setVBoxEntryEmployee(employee, countRow ,dayOfWeek, vBox, dateJob);

        // get a handle to the stage
        Stage stage = (Stage) buttonSaveEntry.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    private VBox vBox;
    private Employee employee;
    private int dayOfWeek;
    private String dateJob;
    private int countRow;
    private boolean update;

    public ModalAddEntryEmployeeTimeTable(VBox vBox, Employee employee, int countRow, int dayOfWeek, String dateJob) {
        this.vBox = vBox;
        this.employee = employee;
        this.dayOfWeek = dayOfWeek;
        this.countRow = countRow;
        this.dateJob = dateJob;
    }

    public ModalAddEntryEmployeeTimeTable(VBox vBox, Employee employee, int dayOfWeek, int countRow, boolean update) {
        this.vBox = vBox;
        this.employee = employee;
        this.dayOfWeek = dayOfWeek;
        this.countRow = countRow;
        this.update = update;
    }

    @FXML
    private void initialize() {
        comboBoxPoll.setItems(observableListPoll);

        if (update) {
            DateJobEmployee dateJobEmployee = employee.getTimetable().get(dayOfWeek);
            textFieldStart.setText(dateJobEmployee.getStartTime());
            textFieldEnd.setText(dateJobEmployee.getEndTime());
            comboBoxPoll.setValue(dateJobEmployee.getPool());
        }
    }
}
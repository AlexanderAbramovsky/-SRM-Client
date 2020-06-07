package sahan.abr.fx.controllers.employees;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sahan.abr.entities.Employee;
import sahan.abr.entities.Schedule;
import sahan.abr.entities.ScheduleRole;

import java.sql.SQLException;

import static sahan.abr.Main.*;

public class ModalAddEntryEmployeeTimeTable {

    @FXML
    private ComboBox<String> comboBoxPoll;

    @FXML
    private ComboBox<String> comboBoxStart;

    @FXML
    private ComboBox<String> comboBoxEnd;

    @FXML
    private Button buttonSaveEntry;

    private VBox vBox;
    private Employee employee;
    private Schedule schedule;
    private String dateJob;
    private int countRow;
    private boolean update;

    @FXML
    void saveEntry(ActionEvent event) throws SQLException {

        if (update) {
            System.out.println(schedule);
            schedule = new Schedule(schedule.getId(), ScheduleRole.EMPLOYEE, employee.getId(), dateJob, comboBoxStart.getValue(), comboBoxEnd.getValue(), comboBoxPoll.getValue());
            scheduleRepository.update(schedule);
        } else {
            schedule = new Schedule(ScheduleRole.EMPLOYEE, employee.getId(), dateJob, comboBoxStart.getValue(), comboBoxEnd.getValue(), comboBoxPoll.getValue());
            scheduleRepository.save(schedule);
        }

        vBox.getChildren().removeAll(vBox.getChildren());

        EmployeesTimeTableController.setVBoxEntryEmployee(employee, schedule, countRow, vBox, dateJob);

        // get a handle to the stage
        Stage stage = (Stage) buttonSaveEntry.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public ModalAddEntryEmployeeTimeTable(VBox vBox, Employee employee, Schedule schedule, int countRow, String dateJob) {
        this.vBox = vBox;
        this.employee = employee;
        this.schedule = schedule;
        this.countRow = countRow;
        this.dateJob = dateJob;
    }

    public ModalAddEntryEmployeeTimeTable(VBox vBox, Employee employee, Schedule schedule, int countRow, String dateJob, boolean update) {
        this.vBox = vBox;
        this.employee = employee;
        this.schedule = schedule;
        this.countRow = countRow;
        this.dateJob = dateJob;
        this.update = update;
    }

    @FXML
    private void initialize() {
        comboBoxPoll.setItems(observableListPoll);
        comboBoxStart.setItems(observableListTime);
        comboBoxEnd.setItems(observableListTime);

        if (update) {
            comboBoxStart.setValue(observableListTime.get(observableListTime.indexOf(schedule.getSTime())));
            comboBoxEnd.setValue(observableListTime.get(observableListTime.indexOf(schedule.getETime())));
            comboBoxPoll.setValue(schedule.getPoll());
        } else {
            comboBoxPoll.getSelectionModel().select(observableListPoll.size() - 1);
        }
    }
}

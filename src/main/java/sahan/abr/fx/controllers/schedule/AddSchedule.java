package sahan.abr.fx.controllers.schedule;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sahan.abr.entities.Client;
import sahan.abr.entities.Schedule;
import sahan.abr.entities.ScheduleRole;
import sahan.abr.fx.controllers.Navigator;

import java.sql.SQLException;

import static sahan.abr.Main.*;

public class AddSchedule {
    @FXML
    private ComboBox<Client> comboBoxClients;

    @FXML
    private CheckBox checkBoxNewClient;

    @FXML
    private TextField textFieldSurname;

    @FXML
    private TextField textFieldPhoneNumber;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldMiddleName;

    @FXML
    private Button save;

    @FXML
    private HBox NewClient;

    String data;
    String sTime;
    String eTime;
    String poll;
    Client client;

    public AddSchedule(String data, String sTime, String eTime, String poll) {
        this.data = data;
        this.sTime = sTime;
        this.eTime = eTime;
        this.poll = poll;
    }

    @FXML
    private void initialize() {

        comboBoxClients.setItems(clientObservableList);

        NewClient.setDisable(true);
    }

    @FXML
    void save(ActionEvent event) throws SQLException {
        client = comboBoxClients.getValue();
        Schedule schedule = new Schedule(ScheduleRole.CLIENT, client.getId(), data, sTime, eTime, poll);
        scheduleRepository.save(schedule);

        // get a handle to the stage
        Stage stage = (Stage) save.getScene().getWindow();
        // do what you have to do
        stage.close();

        Navigator.loadVista(Navigator.TIMETABLE);
    }

    @FXML
    void clickCheck(ActionEvent event) {

    }
}

package sahan.abr.fx.controllers.employees;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import sahan.abr.entities.*;
import sahan.abr.fx.controllers.Navigator;
import sahan.abr.lib.LibSRM;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import static sahan.abr.Main.employeeRepository;
import static sahan.abr.Main.scheduleRepository;
import static sahan.abr.Main.observableListEmployees;
import static sahan.abr.Main.observableListPosition;

public class EmployeesTimeTableController {

    @FXML
    private Label labelWeek;

    @FXML
    private Label labelMonday;

    @FXML
    private Label labelTuesday;

    @FXML
    private Label labelWednesday;

    @FXML
    private Label labelThursday;

    @FXML
    private Label labelFriday;

    @FXML
    private Label labelSaturday;

    @FXML
    private Label labelSunday;

    @FXML
    private Button buttonThisWeek;

    @FXML
    private ComboBox<String> comboBoxPosition;

    @FXML
    private TextField textFieldSearchTitle;

    @FXML
    private GridPane gridPaneEmployeesTimeTable;

    private Calendar calendar;
    private Date date;
    private String[] strWeek = new String[8];

    @FXML
    private void initialize() throws SQLException {
        thisWeek();
//        dateOutput();
        comboBoxPosition.setItems(observableListPosition);

        for (int i = 0; i < observableListEmployees.size(); i++) {
            addEntry(observableListEmployees.get(i), i);
        }
    }

    private void addEntry(Employee employee, int countRow) throws SQLException {
        gridPaneEmployeesTimeTable.add(getVBoxEmployee(employee, countRow), 0, countRow);

        Schedule schedule = null;

//        for (int i = 1; i <= 7; i++) {
//            if (employee.getTimetable().get(i) == null) {
//                //если нет расписания на день недели
//                gridPaneEmployeesTimeTable.add(getVBoxAddEntryEmployee(employee, countRow, i, strWeek[i]), i, countRow);
//            } else {
//                //если есть расписание на день недели
//                gridPaneEmployeesTimeTable.add(getVBoxEntryEmployee(employee, countRow, i, strWeek[i]), i, countRow);
//            }
//        }
        for (int i = 1; i <= 7; i++) {
            if ((schedule = scheduleRepository.getByIdRoleAndDate(employee.getId(), strWeek[i])) == null) {
                //если нет расписания на день недели
                gridPaneEmployeesTimeTable.add(getVBoxAddEntryEmployee(employee, countRow, i, strWeek[i]), i, countRow);
            } else {
                //если есть расписание на день недели
                gridPaneEmployeesTimeTable.add(getVBoxEntryEmployee(employee, schedule, countRow, i, strWeek[i]), i, countRow);
            }
        }
    }

    private VBox getVBoxEmployee(Employee employee, int countRow) {
        VBox vBoxEmployee = new VBox();
        vBoxEmployee.setAlignment(Pos.CENTER);
        vBoxEmployee.setPadding(new Insets(0,0, 5,5));

        if (countRow % 2 == 1) {
            vBoxEmployee.setStyle("-fx-background-color : #e6f3fc");
        } else {
            vBoxEmployee.setStyle("-fx-background-color :  #9cd3ff");
        }

        vBoxEmployee.getStyleClass().add("border");
        HBox hBoxSurname = new HBox();
        Label labelSurname = new Label(LibSRM.getFIO(employee));
        labelSurname.getStyleClass().add("labelEmployee");
        hBoxSurname.getChildren().add(labelSurname);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        Label labelPosition = new Label(employee.getPosition());
        labelPosition.getStyleClass().add("labelEmployee");
        HBox hBoxButton = new HBox();
        hBoxButton.setPadding(new Insets(0,5, 0,0));
        hBoxButton.setAlignment(Pos.CENTER_RIGHT);
        Button button = new Button("");
        button.getStyleClass().add("toggle-button-journal");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ModalUpdateEmployeeController controller = new ModalUpdateEmployeeController(employee, true);
                Navigator.getModalWindow("SRM", Navigator.MODAL_UPDATE_EMPLOYEE, controller);
            }
        });
        hBoxButton.getChildren().add(button);
        hBox.getChildren().add(labelPosition);
        hBox.getChildren().add(hBoxButton);

        HBox.setHgrow(hBoxButton, Priority.ALWAYS);
        vBoxEmployee.getChildren().addAll(hBoxSurname, hBox);

        return vBoxEmployee;
    }

    public static VBox getVBoxAddEntryEmployee(Employee employee, int countRow, int dayOfWeek, String dateJob) {

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        if (countRow % 2 == 1) {
            vBox.setStyle("-fx-background-color : #e6f3fc");
        } else {
            vBox.setStyle("-fx-background-color :  #9cd3ff");
        }

        vBox.getStyleClass().add("border");

        Button button = new Button("");
        button.getStyleClass().add("toggle-button-add-round");
        button.setOnAction(event -> {
            ModalAddEntryEmployeeTimeTable controller = new ModalAddEntryEmployeeTimeTable(vBox, employee, null, countRow, dayOfWeek, dateJob);
            Navigator.getModalWindow("SRM", Navigator.MODAL_ADD_ENTRY_EMPLOYEE, controller);
        });

        vBox.getChildren().add(button);

        return vBox;
    }

    public static void setVBoxAddEntryEmployee(Employee employee, Schedule schedule, int countRow, int dayOfWeek, VBox vBox, String dateJob) {

        Button button = new Button("");
        button.getStyleClass().add("toggle-button-add-round");
        button.setOnAction(event -> {
            ModalAddEntryEmployeeTimeTable controller = new ModalAddEntryEmployeeTimeTable(vBox, employee, schedule, countRow, dayOfWeek, dateJob);
            Navigator.getModalWindow("SRM", Navigator.MODAL_ADD_ENTRY_EMPLOYEE, controller);
        });

        vBox.getChildren().add(button);
    }

    public static VBox getVBoxEntryEmployee(Employee employee, Schedule schedule, int countRow, int dayOfWeek, String dateJob) {

        VBox vBoxEmployee = new VBox();
        vBoxEmployee.setAlignment(Pos.CENTER);
        vBoxEmployee.setPadding(new Insets(0,0, 5,0));
        vBoxEmployee.getStyleClass().add("border");

        if (countRow % 2 == 1) {
            vBoxEmployee.setStyle("-fx-background-color : #e6f3fc");
        } else {
            vBoxEmployee.setStyle("-fx-background-color :  #9cd3ff");
        }

//        DateJobEmployee dateJobEmployee = employee.getTimetable().get(dayOfWeek);

        Label labelTime = new Label("C " + schedule.getSTime() + " по "
                + schedule.getETime());
        labelTime.getStyleClass().add("labelEmployee");

//        Label labelPool = new Label("Бассейн - " + dateJobEmployee.getPool());
//        labelPool.getStyleClass().add("labelEmployee");

        HBox hBoxButtons = new HBox();
        hBoxButtons.setAlignment(Pos.CENTER);
        hBoxButtons.setSpacing(10);

        Button buttonDelete = new Button("");
        buttonDelete.getStyleClass().add("toggle-button-delete");
        buttonDelete.setOnAction(event -> {

            vBoxEmployee.getChildren().removeAll(vBoxEmployee.getChildren());

            setVBoxAddEntryEmployee(employee, schedule, countRow, dayOfWeek, vBoxEmployee, dateJob);

            try {
                scheduleRepository.deleteById(schedule.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        Button buttonUpdate = new Button("");
        buttonUpdate.getStyleClass().add("toggle-button-pencil");
        buttonUpdate.setOnAction(event -> {
            ModalAddEntryEmployeeTimeTable controller =
                    new ModalAddEntryEmployeeTimeTable(vBoxEmployee, employee, schedule, dayOfWeek, countRow, true);
            Navigator.getModalWindow("SRM", Navigator.MODAL_ADD_ENTRY_EMPLOYEE, controller);
        });

        hBoxButtons.getChildren().addAll(buttonUpdate, buttonDelete);

        vBoxEmployee.getChildren().addAll(labelTime, hBoxButtons);

        return vBoxEmployee;
    }

    public static void setVBoxEntryEmployee(Employee employee, Schedule schedule, int countRow, int dayOfWeek, VBox vBoxEmployee, String dateJob) {

//        DateJobEmployee dateJobEmployee = employee.getTimetable().get(dayOfWeek);

        Label labelTime = new Label("C " + schedule.getSTime() + " по "
                + schedule.getETime());
        labelTime.getStyleClass().add("labelEmployee");

//        Label labelPool = new Label("������� - " + dateJobEmployee.getPool());
//        labelPool.getStyleClass().add("labelEmployee");

        HBox hBoxButtons = new HBox();
        hBoxButtons.setAlignment(Pos.CENTER);
        hBoxButtons.setSpacing(10);

        Button buttonDelete = new Button("");
        buttonDelete.getStyleClass().add("toggle-button-delete");
        buttonDelete.setOnAction(event -> {

            vBoxEmployee.getChildren().removeAll(vBoxEmployee.getChildren());

            setVBoxAddEntryEmployee(employee, schedule, countRow, dayOfWeek, vBoxEmployee, dateJob);

            try {
                scheduleRepository.deleteById(schedule.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        Button buttonUpdate = new Button("");
        buttonUpdate.getStyleClass().add("toggle-button-pencil");
        buttonUpdate.setOnAction(event -> {
            ModalAddEntryEmployeeTimeTable controller =
                    new ModalAddEntryEmployeeTimeTable(vBoxEmployee, employee, schedule, dayOfWeek, countRow, true);
            Navigator.getModalWindow("SRM", Navigator.MODAL_ADD_ENTRY_EMPLOYEE, controller);
        });

        hBoxButtons.getChildren().addAll(buttonUpdate, buttonDelete);

        vBoxEmployee.getChildren().addAll(labelTime, hBoxButtons);

        vBoxEmployee.setPadding(new Insets(0,0, 5,0));
    }

    public void dateOutput(){
        String day = "";
        String month = "";
        String year = "";

        for (int i = 1; i <= 6; i++) {

            day = ((calendar.get(Calendar.DAY_OF_MONTH) < 10) ? "0" : "") + calendar.get(Calendar.DAY_OF_MONTH);
            month = (((calendar.get(Calendar.MONTH) + 1) < 10) ? "0" : "") + (calendar.get(Calendar.MONTH) + 1);
            year = "" + calendar.get(Calendar.YEAR);
            String[] masYear = year.split("");
            year = masYear[masYear.length - 2] + masYear[masYear.length - 1];

            if (i == 1) labelMonday.setText(day + "." + month + "." + year);
            if (i == 2) labelTuesday.setText(day + "." + month + "." + year);
            if (i == 3) labelWednesday.setText(day + "." + month + "." + year);
            if (i == 4) labelThursday.setText(day + "." + month + "." + year);
            if (i == 5) labelFriday.setText(day + "." + month + "." + year);
            if (i == 6) labelSaturday.setText(day + "." + month + "." + year);

            date.setDate(date.getDate() + 1);
            calendar.setTime(date);
        }

        day = ((calendar.get(Calendar.DAY_OF_MONTH) < 10) ? "0" : "") + calendar.get(Calendar.DAY_OF_MONTH);
        month = (((calendar.get(Calendar.MONTH) + 1) < 10) ? "0" : "") + (calendar.get(Calendar.MONTH) + 1);
        year = "" + calendar.get(Calendar.YEAR);
        String[] masYear = year.split("");
        year = masYear[masYear.length - 2] + masYear[masYear.length - 1];

        labelSunday.setText(day + "." + month + "." + year);

        labelWeek.setText(labelMonday.getText() + " - " + labelSunday.getText());

        strWeek[7] = labelSunday.getText();
        strWeek[1] = labelMonday.getText();
        strWeek[2] = labelTuesday.getText();
        strWeek[3] = labelWednesday.getText();
        strWeek[4] = labelThursday.getText();
        strWeek[5] = labelFriday.getText();
        strWeek[6] = labelSaturday.getText();
    }

    public void thisWeek() {
        calendar = Calendar.getInstance();

        date = calendar.getTime();

        date.setDate(date.getDate() - date.getDay() + 1);
        calendar.setTime(date);

        dateOutput();
    }

    public void nextWeek() {
        date.setDate(date.getDate() - date.getDay() + 1);
        calendar.setTime(date);

        dateOutput();
    }

    public void lastWeek() {
       // System.out.println(date.getDay() + "  " + date.getDate());
        date.setDate(date.getDate() - 13);
        calendar.setTime(date);

        dateOutput();
    }

    @FXML
    void actionLastWeek(ActionEvent event) {
        lastWeek();
        dateOutput();
    }

    @FXML
    void actionNextWeek(ActionEvent event) {
        nextWeek();
        dateOutput();
    }

    @FXML
    void actionThisWeek(ActionEvent event) {
        thisWeek();
        dateOutput();
    }
}

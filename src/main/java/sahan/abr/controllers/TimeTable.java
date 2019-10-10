package sahan.abr.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sahan.abr.entities.DateJobEmployee;
import sahan.abr.entities.Employee;
import sahan.abr.lib.LibSRM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static sahan.abr.Main.observableListPoll;
import static sahan.abr.Main.observableListEmployees;

public class TimeTable {

    @FXML
    private Button buttonThisDay;

    @FXML
    private Button buttonLastDay;

    @FXML
    private Button buttonNextDay;

    @FXML
    private DatePicker datePickerCalendar;

    @FXML
    private VBox test;

    @FXML
    private Label labelDayOfWeek;

    @FXML
    private GridPane gridPaneTimeTable;

    HashMap<String, ArrayList<VBox>> hashMapVBox  = new HashMap<>();

    ArrayList<String> arrayListTime = new ArrayList<>();

    Calendar calendar;
    Date date;

    @FXML
    private void initialize() {

        arrayListTime.add("");
        arrayListTime.add("09:00");
        arrayListTime.add("09:30");
        arrayListTime.add("10:00");
        arrayListTime.add("10:30");
        arrayListTime.add("11:00");
        arrayListTime.add("11:30");
        arrayListTime.add("12:00");
        arrayListTime.add("12:30");
        arrayListTime.add("13:00");
        arrayListTime.add("13:30");
        arrayListTime.add("14:00");
        arrayListTime.add("14:30");
        arrayListTime.add("15:00");
        arrayListTime.add("15:30");
        arrayListTime.add("16:00");
        arrayListTime.add("16:30");
        arrayListTime.add("17:00");
        arrayListTime.add("17:30");
        arrayListTime.add("18:00");
        arrayListTime.add("18:30");
        arrayListTime.add("19:00");
        arrayListTime.add("19:30");
        arrayListTime.add("20:00");

        thisDay();
        satCalendar();
        setGridPaneTimeTable();
    }

    public void outputLabelDayWeek() {

        String dayOfWeek = "";

        String day = ((calendar.get(Calendar.DAY_OF_MONTH) < 10) ? "0" : "") + calendar.get(Calendar.DAY_OF_MONTH);
        String month = (((calendar.get(Calendar.MONTH) + 1) < 10) ? "0" : "") + (calendar.get(Calendar.MONTH) + 1);
        String year = "" + calendar.get(Calendar.YEAR);
        String[] masYear = year.split("");
        year = masYear[masYear.length - 2] + masYear[masYear.length - 1];

        if (date.getDay() == 1) dayOfWeek = "Понедельник";
        if (date.getDay() == 2) dayOfWeek = "Вторник";
        if (date.getDay() == 3) dayOfWeek = "Среда";
        if (date.getDay() == 4) dayOfWeek = "Четверг";
        if (date.getDay() == 5) dayOfWeek = "Пятница";
        if (date.getDay() == 6) dayOfWeek = "Суббота";
        if (date.getDay() == 0) dayOfWeek = "Воскресенье";

        labelDayOfWeek.setText(dayOfWeek + " " + LibSRM.getDateStringFormat(calendar));
    }

    public void thisDay() {
        calendar = Calendar.getInstance();
        date = calendar.getTime();
        outputLabelDayWeek();
        setGridPaneTimeTable();
    }

    public void nextDay() {
        date.setDate(date.getDate() + 1);
        calendar.setTime(date);
        outputLabelDayWeek();
        setGridPaneTimeTable();
    }

    public void lasDay() {
        date.setDate(date.getDate() - 1);
        calendar.setTime(date);
        outputLabelDayWeek();
        setGridPaneTimeTable();
    }

    private void satCalendar() {
        datePickerCalendar.setDisable(true);
        datePickerCalendar.setStyle("-fx-opacity: 1");
        datePickerCalendar.getEditor().setStyle("-fx-opacity: 1");

        datePickerCalendar.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                System.out.println("New Value: " + newValue);
            }
        });

        datePickerCalendar.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("New Value: " + newValue);
        });

        DatePickerSkin datePickerSkin = new DatePickerSkin(datePickerCalendar);
        Node popupContent = datePickerSkin.getPopupContent();

        LocalDate selectedDate = datePickerCalendar.getValue();

        test.getChildren().add(popupContent);
    }

    private void setGridPaneTimeTable() {
        for (int i = 0; i < observableListPoll.size(); i++) {

            ArrayList<VBox> arrayList = new ArrayList<>();
            VBox boxNamePool = new VBox();
            boxNamePool.setStyle("-fx-background-color:  #e6f3fc; -fx-border-color: #59a7ff");
            boxNamePool.setAlignment(Pos.CENTER);
            Label labelNamePoll = new Label(observableListPoll.get(i));
            labelNamePoll.getStyleClass().add("labelNamePoll");

            boxNamePool.getChildren().add(labelNamePoll);

            arrayList.add(boxNamePool);
            gridPaneTimeTable.add(boxNamePool, i + 1, 0);

            for (int j = 1; j < 24; j++) {

                VBox box = new VBox();
                box.setStyle("-fx-background-color: white; -fx-border-color: #59a7ff");

                for (Employee employee : observableListEmployees) {

                    DateJobEmployee dateJobEmployee = null;

                    if (date.getDay() != 0) {
                         dateJobEmployee = employee.getTimetable().get(date.getDay());
                    } else {
                         dateJobEmployee = employee.getTimetable().get(7);
                    }


                    if (dateJobEmployee == null) continue;

                    if (dateJobEmployee.getDate().equals(LibSRM.getDateStringFormat(calendar))
                            && dateJobEmployee.getPool().equals(observableListPoll.get(i))
                            && (dateJobEmployee.getStartTime().compareTo(arrayListTime.get(j)) <= 0)
                            && (dateJobEmployee.getEndTime().compareTo(arrayListTime.get(j)) >= 0)) {
                        Label labelEmployee = new Label(LibSRM.getFIO(employee));
                        labelEmployee.getStyleClass().add("labelEmployee");
                        box.getChildren().add(labelEmployee);
                        box.setStyle("-fx-background-color: #BCFF70; -fx-border-color: #59a7ff");
                    } else {

                    }

                }

                box.setAlignment(Pos.CENTER);

                arrayList.add(box);
                gridPaneTimeTable.add(box, i + 1, j);
            }

            hashMapVBox.put(observableListPoll.get(i), arrayList);
        }

       // gridPaneTimeTable.setGridLinesVisible(true);
    }

    @FXML
    void actionLastDay(ActionEvent event) {
        lasDay();
    }

    @FXML
    void actionNextDay(ActionEvent event) {
        nextDay();
    }

    @FXML
    void actionThisDay(ActionEvent event) {
        thisDay();
    }
}

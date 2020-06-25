package sahan.abr.fx.controllers.schedule;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sahan.abr.entities.*;
import sahan.abr.fx.controllers.Navigator;
import sahan.abr.fx.controllers.customer.AddClientController;
import sahan.abr.fx.controllers.employees.ModalAddEntryEmployeeTimeTable;
import sahan.abr.lib.LibSRM;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import static sahan.abr.Main.*;

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

    HashMap<String, ArrayList<VBox>> hashMapVBox = new HashMap<>();

    ArrayList<String> arrayListTime = new ArrayList<>();

    Calendar calendar;
    Date date;

    @FXML
    private void initialize() throws SQLException {

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
        setGridPaneTimeTable(getDate());
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

    public void thisDay() throws SQLException {
        calendar = Calendar.getInstance();
        date = calendar.getTime();
        LocalDate localDate = LocalDate.now();
        datePickerCalendar.setValue(localDate);
        outputLabelDayWeek();
        setGridPaneTimeTable(getDate());
    }

    public void nextDay() throws SQLException {
        date.setDate(date.getDate() + 1);
        calendar.setTime(date);
        outputLabelDayWeek();
        setGridPaneTimeTable(getDate());
    }

    public void lasDay() throws SQLException {
        date.setDate(date.getDate() - 1);
        calendar.setTime(date);
        outputLabelDayWeek();
        setGridPaneTimeTable(getDate());
    }

    public String getDate() {
        String day = ((calendar.get(Calendar.DAY_OF_MONTH) < 10) ? "0" : "") + calendar.get(Calendar.DAY_OF_MONTH);
        String month = (((calendar.get(Calendar.MONTH) + 1) < 10) ? "0" : "") + (calendar.get(Calendar.MONTH) + 1);
        String year = "" + calendar.get(Calendar.YEAR);
        String[] masYear = year.split("");
        year = masYear[masYear.length - 2] + masYear[masYear.length - 1];
        return day + "." + month + "." + year;
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

    private void setGridPaneTimeTable(String date) throws SQLException {

//        List<Schedule> schedulesEmployee = scheduleRepository.getAllByDateAndRole(date, ScheduleRole.EMPLOYEE);
//        List<Schedule> schedulesClient = scheduleRepository.getAllByDateAndRole(date, ScheduleRole.CLIENT);
//
//        List<Employee> trainers = new ArrayList<>();
//        List<Client> clients = new ArrayList<>();
//
//        //получаем список всех тренеров на текущий день недели
//        for (Schedule schedule : schedulesEmployee) {
//            Employee employee = employeeRepository.getById(schedule.getIdRole());
//            if (employee.getPosition().equals(EmployeePosition.TRAINER)) {
//                trainers.add(employee);
//            }
//        }
//
//        //получаем всех клиентов на 3 бассейна на день недели
//        for (Schedule schedule : schedulesClient) {
//            clients.add(clientRepository.getById(schedule.getIdRole()));
//        }

        VBox[][] vBoxes = new VBox[25][3];

        for (int i = 0; i < observableListPoll.size() - 1; i++) {

            // настройка названия бассейна
            VBox boxNamePoll = new VBox();
            boxNamePoll.setStyle("-fx-background-color:  #e6f3fc; -fx-border-color: #59a7ff");
            boxNamePoll.setAlignment(Pos.CENTER);
            Label labelNamePoll = new Label(observableListPoll.get(i));
            labelNamePoll.getStyleClass().add("labelNamePoll");

            boxNamePoll.getChildren().add(labelNamePoll);

            vBoxes[0][i] = boxNamePoll;
            gridPaneTimeTable.add(boxNamePoll, i + 1, 0);

            // вставляем таблицы во все ячейки разных цветов
            for (int j = 1; j < 24; j++) {
                VBox box = new VBox();

                box.setPadding(new Insets(10, 10, 10, 10));
                box.setSpacing(10);
                box.setFillWidth(true);

                if (j % 2 == 0) {
                    box.setStyle("-fx-background-color: #e6f3fc; -fx-border-color: #59a7ff");
                } else {
                    box.setStyle("-fx-background-color: #9cd3ff; -fx-border-color: #59a7ff");
                }

                box.setAlignment(Pos.CENTER);
                vBoxes[j][i] = box;
                gridPaneTimeTable.add(box, i + 1, j);
            }

            for (Schedule schedule : scheduleRepository.getAllByDateAndRoleAndPoll(date, ScheduleRole.EMPLOYEE, observableListPoll.get(i))) {
                Employee employee = employeeRepository.getById(schedule.getIdRole());

                if (employee.getPosition().equals(EmployeePosition.ADMINISTRATOR)) continue;

                int start = arrayListTime.indexOf(schedule.getSTime());
                int end = arrayListTime.indexOf(schedule.getETime());
                // выставляем время работы для каждого сотрудника
                for (int j = start; j <= end; j++) {
                    Label label = new Label("Тренер - " + LibSRM.getFIO(employee));
                    label.getStyleClass().add("labelEmployee");
                    vBoxes[j][i].getChildren().add(label);
                }
            }

            for (Schedule schedule : scheduleRepository.getAllByDateAndRoleAndPoll(date, ScheduleRole.CLIENT, observableListPoll.get(i))) {

                Client client = clientRepository.getById(schedule.getIdRole());
                int start = arrayListTime.indexOf(schedule.getSTime());

                HBox hBoxMain = new HBox();
                HBox hBoxButton = new HBox();
                VBox vBoxLabel = new VBox();

                hBoxMain.setAlignment(Pos.CENTER);
                hBoxButton.setAlignment(Pos.CENTER);
                vBoxLabel.setAlignment(Pos.CENTER);
                hBoxButton.setPadding(new Insets(0, 0, 0, 20));

                Label labelClient = new Label("Клиент");
                Label labelFioClient = new Label(LibSRM.getFIO(client));
                labelClient.getStyleClass().add("labelEmployee");
                labelFioClient.getStyleClass().add("labelEmployee");

                Button buttonInformClient = new Button();
                Button buttonDelete = new Button();

                buttonDelete.setOnAction(event -> {
                    DeleteSchedule controller = new DeleteSchedule(schedule);
                    Navigator.getModalWindow("SRM", Navigator.MODAL_DELETE_SCHEDULE, controller);
                });

                buttonInformClient.setOnAction((ActionEvent event) -> {
                    AddClientController controller = new AddClientController(client, true);
                    Navigator.loadVista(Navigator.ADD_CUSTOMERS, controller);
                });

                buttonInformClient.getStyleClass().add("toggle-button-journal");
                buttonDelete.getStyleClass().add("toggle-button-delete");
                hBoxButton.setSpacing(10);

                hBoxButton.getChildren().addAll(buttonDelete, buttonInformClient);
                vBoxLabel.getChildren().addAll(labelClient, labelFioClient);
                hBoxMain.getChildren().addAll(vBoxLabel, hBoxButton);

                vBoxes[start][i].getChildren().add(hBoxMain);
            }

            for (int j = 1; j < 24; j++) {
               if (vBoxes[j][i].getChildren().size() == 1) {
                   Button button = new Button("");
                   button.getStyleClass().add("toggle-button-square");

                   int finalJ = j;
                   int finalI = i;
                   button.setOnAction(event -> {
                       String time = arrayListTime.get(finalJ);
                       String poll = observableListPoll.get(finalI);
                       AddSchedule controller = new AddSchedule(date, time, time, poll);
                       Navigator.getModalWindow("SRM", Navigator.MODAL_ADD_SCHEDULE, controller);
                   });

                   vBoxes[j][i].getChildren().add(button);
               }
            }

//            for (Schedule schedule : scheduleRepository.getAllByDateAndRoleAndPool(date, ScheduleRole.EMPLOYEE, observableListPoll.get(i))) {
//
//                VBox box = new VBox();
//                box.setStyle("-fx-background-color: white; -fx-border-color: #59a7ff");
//
//                if (schedule.getRole().equals(ScheduleRole.EMPLOYEE)) {
//                    Employee employee = employeeRepository.getById(schedule.getIdRole());
//                    Label labelEmployee = new Label(LibSRM.getFIO(employee));
//                    labelEmployee.getStyleClass().add("labelEmployee");
//                    box.getChildren().add(labelEmployee);
//                    box.setStyle("-fx-background-color: #BCFF70; -fx-border-color: #59a7ff");
//
//                    arrayList.add(box);
//                    gridPaneTimeTable.add(box, i + 1, arrayListTime.indexOf(schedule.getSTime()));
//                } else {
//
//                }
//            }

//            for (int j = 1; j < 24; j++) {
//
//                VBox box = new VBox();
//                box.setStyle("-fx-background-color: white; -fx-border-color: #59a7ff");
//
//                for (Employee employee : observableListEmployees) {
//
//                    DateJobEmployee dateJobEmployee = null;
//
////                    if (date.getDay() != 0) {
////                         dateJobEmployee = employee.getTimetable().get(date.getDay());
////                    } else {
////                         dateJobEmployee = employee.getTimetable().get(7);
////                    }
//
//
//                    if (dateJobEmployee == null) continue;
//
//                    if (dateJobEmployee.getDate().equals(LibSRM.getDateStringFormat(calendar))
//                            && dateJobEmployee.getPool().equals(observableListPoll.get(i))
//                            && (dateJobEmployee.getStartTime().compareTo(arrayListTime.get(j)) <= 0)
//                            && (dateJobEmployee.getEndTime().compareTo(arrayListTime.get(j)) >= 0)) {
//                        Label labelEmployee = new Label(LibSRM.getFIO(employee));
//                        labelEmployee.getStyleClass().add("labelEmployee");
//                        box.getChildren().add(labelEmployee);
//                        box.setStyle("-fx-background-color: #BCFF70; -fx-border-color: #59a7ff");
//                    } else {
//
//                    }
//
//                }
//
//                box.setAlignment(Pos.CENTER);
//
//                arrayList.add(box);
//                gridPaneTimeTable.add(box, i + 1, j);
//            }

//            hashMapVBox.put(observableListPoll.get(i), arrayList);
        }

        // gridPaneTimeTable.setGridLinesVisible(true);
    }

    public static void setVBoxAddEntry(Employee employee, Schedule schedule, int countRow, VBox vBox, String dateJob) {

        Button button = new Button("");
        button.getStyleClass().add("toggle-button-add-round");
        button.setOnAction(event -> {
//            ModalAddEntryEmployeeTimeTable controller = new ModalAddEntryEmployeeTimeTable(vBox, employee, schedule, countRow, dateJob);
//            Navigator.getModalWindow("SRM", Navigator.MODAL_ADD_ENTRY_EMPLOYEE, controller);
        });

        vBox.getChildren().add(button);
    }

    @FXML
    void actionLastDay(ActionEvent event) throws SQLException {
        lasDay();
    }

    @FXML
    void actionNextDay(ActionEvent event) throws SQLException {
        nextDay();
    }

    @FXML
    void actionThisDay(ActionEvent event) throws SQLException {
        thisDay();
    }
}

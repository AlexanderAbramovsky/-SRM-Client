package sahan.abr.fx.controllers.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import sahan.abr.fx.controllers.Navigator;
import sahan.abr.entities.Customer;

import static sahan.abr.Main.observableListCustomers;

public class CustomerController {

    @FXML
    private TableView<Customer> tableViewCustomers;

    @FXML
    private TableColumn<Customer, String> tableColumnFIO;

    @FXML
    private TableColumn<Customer, String> tableColumnPhoneNumber;

    @FXML
    private TableColumn<Customer, String> tableColumnChild;

    //public static ArrayList<Customer> observableListCustomer = new ArrayList<>();

    @FXML
    private void initialize() {

        tableViewCustomers.setItems(observableListCustomers);

        tableColumnFIO.setCellValueFactory(new PropertyValueFactory<Customer, String>("fio"));
        tableColumnPhoneNumber.setCellValueFactory(new PropertyValueFactory<Customer, String>("phoneNumber"));
        tableColumnChild.setCellValueFactory(new PropertyValueFactory<Customer, String>("shortNameChild"));

        addButtonsToTableCustomers();
    }

    @FXML
    void buttonAddCustomer(ActionEvent event) {
        Navigator.loadVista(Navigator.ADD_CUSTOMERS, new AddCustomerController());
        //Navigator.getModalWindow("SRM",Navigator.MODAL_ADD_CUSTOMER);
    }

    private void addButtonsToTableCustomers() {
        TableColumn colBtn = new TableColumn("Действия");

        Callback<TableColumn<Customer, Void>, TableCell<Customer, Void>> cellFactory =
                new Callback<TableColumn<Customer, Void>, TableCell<Customer, Void>>() {
                    @Override
                    public TableCell<Customer, Void> call(final TableColumn<Customer, Void> param) {
                        final TableCell<Customer, Void> cell = new TableCell<Customer, Void>() {

                            private final HBox hBox = new HBox();
                            {
                                hBox.setSpacing(10);
                                hBox.setAlignment(Pos.CENTER);

                                Button buttonDelete = new Button("Удалить");
                                buttonDelete.setPrefWidth(93);
                                buttonDelete.setAlignment(Pos.CENTER_RIGHT);
                                buttonDelete.getStyleClass().add("toggle-button-delete-left");

                                buttonDelete.setOnAction((ActionEvent event) -> {
                                    Customer data = getTableView().getItems().get(getIndex());
                                    observableListCustomers.remove(data);
                                });

                                Button buttonUpdate = new Button("Обновить");
                                buttonUpdate.setPrefWidth(103);
                                buttonUpdate.setAlignment(Pos.CENTER_RIGHT);
                                buttonUpdate.getStyleClass().add("toggle-button-update-left");

                                buttonUpdate.setOnAction((ActionEvent event) -> {
                                    Customer data = getTableView().getItems().get(getIndex());
                                    AddCustomerController controller = new AddCustomerController(data);
                                    Navigator.loadVista(Navigator.ADD_CUSTOMERS, controller);
                                });

                                Button buttonAdditionalInformation = new Button("Доп. инф.");
                                buttonAdditionalInformation.setPrefWidth(110);
                                buttonAdditionalInformation.setAlignment(Pos.CENTER_RIGHT);
                                buttonAdditionalInformation.getStyleClass().add("toggle-button-information-left");

                                buttonAdditionalInformation.setOnAction((ActionEvent event) -> {
                                    Customer data = getTableView().getItems().get(getIndex());
                                    // ModalUpdateEmployeeController controller = new ModalUpdateEmployeeController(data, employeesController);
                                    // Navigator.getModalWindow("SRM", Navigator.MODAL_UPDATE_EMPLOYEE, controller);
                                });

                                hBox.getChildren().add(buttonAdditionalInformation);
                                hBox.getChildren().add(buttonUpdate);
                                hBox.getChildren().add(buttonDelete);
                            }

                            @Override
                            public void updateItem(Void item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                } else {
                                    setGraphic(hBox);
                                }
                            }
                        };
                        return cell;
                    }
                };

        colBtn.setCellFactory(cellFactory);

        tableViewCustomers.getColumns().add(colBtn);

    }
}

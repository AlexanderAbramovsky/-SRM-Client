package sahan.abr.controllers.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import sahan.abr.controllers.Navigator;
import sahan.abr.entities.Client;

import java.util.ArrayList;

public class CustomerController {

    private static VBox vBoxStaticCustomers;

    @FXML
    private  VBox vBoxCustomers;

    public static ArrayList<Client> observableListCustomer = new ArrayList<>();

    @FXML
    private void initialize() {
        vBoxStaticCustomers = vBoxCustomers;
    }

    @FXML
    void buttonAddCustomer(ActionEvent event) {
        Navigator.getModalWindow("SRM",Navigator.MODAL_ADD_CUSTOMER);
    }

    public static VBox getvBoxStaticCustomers() {
        return vBoxStaticCustomers;
    }
}

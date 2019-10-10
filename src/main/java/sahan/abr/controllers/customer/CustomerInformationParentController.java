package sahan.abr.controllers.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sahan.abr.controllers.Navigator;
import sahan.abr.controllers.employees.ModalUpdateEmployeeController;
import sahan.abr.entities.Client;
import sahan.abr.entities.Parent;

import static sahan.abr.controllers.customer.CustomerController.observableListCustomer;

public class CustomerInformationParentController {

    private Client client;

    @FXML
    private Label labelInitials;

    @FXML
    private Label labelContactPhoneNumber;

    @FXML
    private void initialize() {
        labelInitials.setText(client.getParent().getSurname() + " " + client.getParent().getName() + " " + client.getParent().getMiddleName());
        labelContactPhoneNumber.setText(client.getParent().getContactPhoneNumber());
    }

    public CustomerInformationParentController(Client client) {
        this.client = client;
    }

    @FXML
    void updateCustomer(ActionEvent event) {
        ModalUpdateParentController controller = new ModalUpdateParentController(client);
        Navigator.getModalWindow("SRM", Navigator.MODAL_UPDATE_CUSTOMER, controller);
    }

    @FXML
    void deleteCustomer(ActionEvent event) {
        observableListCustomer.remove(client);
        CustomerController.getvBoxStaticCustomers().getChildren().remove(client.getvBoxClient());
    }

    @FXML
    void additionalInformationParent(ActionEvent event) {
        ModalAdditionalInformationParentController controller = new ModalAdditionalInformationParentController(client);
        Navigator.getModalWindow("SRM", Navigator.MODAL_ADDITIONAL_INFORMATION_PARENT_CUSTOMER, controller);
    }

    @FXML
    void addChild(ActionEvent event) {
        client.addvBoxChildren(Navigator.getVBox("SRM", Navigator.CUSTOMER_INFORMATION_CHILD));
    }
}

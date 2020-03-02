package sahan.abr.controllers.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sahan.abr.controllers.Navigator;
import sahan.abr.controllers.customer.modal.ModalAdditionalInformationParentController;
import sahan.abr.controllers.customer.modal.ModalUpdateParentController;
import sahan.abr.entities.Customer;

import static sahan.abr.Main.observableListCustomers;

public class CustomerInformationParentController {

    private Customer customer;

    @FXML
    private Label labelInitials;

    @FXML
    private Label labelContactPhoneNumber;

    @FXML
    private void initialize() {
        labelInitials.setText(customer.getParent().getSurname() + " " + customer.getParent().getName() + " " + customer.getParent().getMiddleName());
        labelContactPhoneNumber.setText(customer.getParent().getContactPhoneNumber());
    }

    public CustomerInformationParentController(Customer customer) {
        this.customer = customer;
    }

    @FXML
    void updateCustomer(ActionEvent event) {
        ModalUpdateParentController controller = new ModalUpdateParentController(customer);
        Navigator.getModalWindow("SRM", Navigator.MODAL_UPDATE_CUSTOMER, controller);
    }

    @FXML
    void deleteCustomer(ActionEvent event) {

    }

    @FXML
    void additionalInformationParent(ActionEvent event) {
        ModalAdditionalInformationParentController controller = new ModalAdditionalInformationParentController(customer);
        Navigator.getModalWindow("SRM", Navigator.MODAL_ADDITIONAL_INFORMATION_PARENT_CUSTOMER, controller);
    }

    @FXML
    void addChild(ActionEvent event) {

    }
}

package sahan.abr.controllers.customer.modal;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sahan.abr.entities.Customer;

public class ModalAdditionalInformationParentController {

    @FXML
    private TextField textFieldSurname;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldMiddleName;

    @FXML
    private TextArea textFieldPassport;

    @FXML
    private TextField textFieldPhoneNumber;

    @FXML
    private TextField textFieldContactPhoneNumber;

    @FXML
    private TextField textFieldEmail;

    private Customer customer;

    public ModalAdditionalInformationParentController(Customer customer) {
        this.customer = customer;
    }

    @FXML
    private void initialize() {
        textFieldSurname.setText(customer.getParent().getSurname());
        textFieldName.setText(customer.getParent().getName());
        textFieldMiddleName.setText(customer.getParent().getMiddleName());
        textFieldPassport.setText(customer.getParent().getPassport());
        textFieldPhoneNumber.setText(customer.getParent().getPhoneNumber());
        textFieldContactPhoneNumber.setText(customer.getParent().getContactPhoneNumber());
        textFieldEmail.setText(customer.getParent().getEmail());
    }
}

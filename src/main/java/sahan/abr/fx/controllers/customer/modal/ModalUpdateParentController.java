package sahan.abr.fx.controllers.customer.modal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sahan.abr.entities.Customer;

import static sahan.abr.Main.clientObservableList;

public class ModalUpdateParentController {

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

    @FXML
    private Button updateButton;

    private Customer customer;

    public ModalUpdateParentController(Customer customer) {
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

    @FXML
    void updateParent(ActionEvent event) {

        customer.getParent().setSurname(textFieldSurname.getText());
        customer.getParent().setName(textFieldName.getText());
        customer.getParent().setMiddleName(textFieldMiddleName.getText());
        customer.getParent().setPassport(textFieldPassport.getText());
        customer.getParent().setPhoneNumber(textFieldPhoneNumber.getText());
        customer.getParent().setContactPhoneNumber(textFieldContactPhoneNumber.getText());
        customer.getParent().setEmail(textFieldEmail.getText());

//        clientObservableList.remove(customer);
//        clientObservableList.add(customer);

        // get a handle to the stage
        Stage stage = (Stage) updateButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}

package sahan.abr.controllers.customer;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sahan.abr.entities.Client;

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

    private Client client;

    public ModalAdditionalInformationParentController(Client client) {
        this.client = client;
    }

    @FXML
    private void initialize() {
        textFieldSurname.setText(client.getParent().getSurname());
        textFieldName.setText(client.getParent().getName());
        textFieldMiddleName.setText(client.getParent().getMiddleName());
        textFieldPassport.setText(client.getParent().getPassport());
        textFieldPhoneNumber.setText(client.getParent().getPhoneNumber());
        textFieldContactPhoneNumber.setText(client.getParent().getContactPhoneNumber());
        textFieldEmail.setText(client.getParent().getEmail());
    }
}

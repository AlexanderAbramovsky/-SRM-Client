package sahan.abr.controllers.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sahan.abr.controllers.Navigator;
import sahan.abr.entities.Client;
import sahan.abr.entities.Parent;

import static sahan.abr.controllers.customer.CustomerController.observableListCustomer;

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

    private Client client;

    public ModalUpdateParentController(Client client) {
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

    @FXML
    void updateParent(ActionEvent event) {

        client.getParent().setSurname(textFieldSurname.getText());
        client.getParent().setName(textFieldName.getText());
        client.getParent().setMiddleName(textFieldMiddleName.getText());
        client.getParent().setPassport(textFieldPassport.getText());
        client.getParent().setPhoneNumber(textFieldPhoneNumber.getText());
        client.getParent().setContactPhoneNumber(textFieldContactPhoneNumber.getText());
        client.getParent().setEmail(textFieldEmail.getText());

        CustomerInformationParentController controller = new CustomerInformationParentController(client);

        CustomerController.getvBoxStaticCustomers().getChildren().remove(client.getvBoxClient());

        client.setvBoxClient(Navigator.getVBox("SRM", Navigator.CUSTOMER_INFORMATION_PARENT, controller));

        CustomerController.getvBoxStaticCustomers().getChildren().add(client.getvBoxClient());

        // get a handle to the stage
        Stage stage = (Stage) updateButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}

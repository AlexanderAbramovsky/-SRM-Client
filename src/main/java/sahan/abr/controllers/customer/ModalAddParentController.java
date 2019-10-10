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

public class ModalAddParentController {

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
    private Button saveButton;

    @FXML
    void saveParent(ActionEvent event) {

        Client client = new Client(new Parent(0, textFieldSurname.getText(), textFieldName.getText(),
                textFieldMiddleName.getText(), textFieldPassport.getText(), textFieldPhoneNumber.getText(),
                textFieldContactPhoneNumber.getText(), textFieldEmail.getText(), null));

        observableListCustomer.add(client);

        CustomerInformationParentController controller = new CustomerInformationParentController(client);

        client.setvBoxClient(Navigator.getVBox("SRM",Navigator.CUSTOMER_INFORMATION_PARENT ,controller));

        CustomerController.getvBoxStaticCustomers().getChildren().add(client.getvBoxClient());

        // get a handle to the stage
        Stage stage = (Stage) saveButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}

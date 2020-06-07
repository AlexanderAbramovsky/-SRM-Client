package sahan.abr.fx.controllers.customer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sahan.abr.fx.controllers.Navigator;
import sahan.abr.entities.*;
import sahan.abr.lib.LibSRM;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import static sahan.abr.Main.*;

public class AddClientController {

    @FXML
    private Label labelOperation;

    @FXML
    private TextField textFieldSurnameParent;

    @FXML
    private TextField textFieldNameParent;

    @FXML
    private TextField textFieldMiddleNameParent;

    @FXML
    private TextField textFieldPassportSeries;

    @FXML
    private TextField textFieldPassportNumber;

    @FXML
    private TextField textFieldPassportDate;

    @FXML
    private TextField textFieldPassportIssuedBy;

    @FXML
    private TextField textFieldPassportAddress;

    @FXML
    private TextField textFieldContractNumber;

    @FXML
    private TextField textFieldContractDate;

    @FXML
    private TextField textFieldPhoneNumber;

    @FXML
    private TextField textFieldContactPhoneNumber;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldVK;

    @FXML
    private CheckBox checkBoxNotCall;

    @FXML
    private CheckBox checkBoxNotEmail;

    @FXML
    private CheckBox checkBoxNotVK;

    @FXML
    private TextField textFieldSurnameChild;

    @FXML
    private TextField textFieldNameChild;

    @FXML
    private TextField textFieldMiddleNameChild;

    @FXML
    private RadioButton radioButtonBoy;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton radioButtonGirl;

    @FXML
    private TextField textFieldDateOfBirth;

    @FXML
    private Label labelYears;

    @FXML
    private ComboBox<Employee> comboBoxEmployees;

    @FXML
    private TextArea textAreaNote;

    @FXML
    private ComboBox<Subscription> comboBoxTypeSubscription;

    @FXML
    private DatePicker datePickerSubscriptionStart;

    @FXML
    private Label labelSubscriptionEndDate;

    @FXML
    private CheckBox checkBoxFreeEntrance;

    @FXML
    private ComboBox<?> comboBoxMonday;

    @FXML
    private ComboBox<?> comboBoxTuesday;

    @FXML
    private ComboBox<?> comboBoxWednesday;

    @FXML
    private ComboBox<?> comboBoxThursday;

    @FXML
    private ComboBox<?> comboBoxFriday;

    @FXML
    private ComboBox<?> comboBoxSaturday;

    @FXML
    private ComboBox<?> comboBoxSunday;

    @FXML
    private Label labelNumberClasses;

    @FXML
    private TextField certificateValidityDateStart;

    @FXML
    private TextField certificateValidityDateEnd;

    private LocalDate dateOfBirth;
    private LocalDate dateStartSubscription;
    private String dateEndSubscriptionStr;
    private String dateStartSubscriptionStr;
    private String dateOfBirthStr;

    private Employee employee;
    private Subscription subscription;
    private String genderStr;

    private Client client;

    public AddClientController() {
    }

    public AddClientController(Client client) {
        this.client = client;
    }

    @FXML
    private void initialize() throws SQLException {

//        datePickerSubscriptionStart.focusedProperty().addListener(new DeterminingDateEndSubscription());

        comboBoxEmployees.setItems(observableListEmployees);
        comboBoxTypeSubscription.setItems(observableListSubscriptions);

        if (client != null) {

            Passport passport = passportRep.getById(client.getIdPassport());
            Contract contract = contractRepository.getById(client.getIdContract());
            Child child = childRep.getById(client.getIdChild());
//            Parent parent = client.getParent();

            System.out.println("_____________");
            System.out.println("passport" + passport);
            System.out.println("child" + child);
            System.out.println("contract" + contract);
            System.out.println("client" + client);


            textFieldSurnameParent.setText(client.getSurname());
            textFieldNameParent.setText(client.getName());
            textFieldMiddleNameParent.setText(client.getMiddleName());

            textFieldPassportSeries.setText(passport.getSeries() + "");
            textFieldPassportNumber.setText(passport.getNumber() + "");
            textFieldPassportAddress.setText(passport.getAddress());
            textFieldPassportIssuedBy.setText(passport.getIssuedBy());
            textFieldPassportDate.setText(passport.getDate());

            textFieldContractNumber.setText(contract.getNumber());
            textFieldContractDate.setText(contract.getDate());

            textFieldPhoneNumber.setText(client.getPhoneNumber());
            textFieldContactPhoneNumber.setText(client.getContactPhoneNumber());

//            textFieldEmail.setText(parent.getEmail());
//            textFieldVK.setText(parent.getVk());
//            checkBoxNotCall.setSelected(parent.isNotCall());
//            checkBoxNotEmail.setSelected(parent.isNotEmail());
//            checkBoxNotVK.setSelected(parent.isNotVK());


            textFieldSurnameChild.setText(child.getSurname());
            textFieldNameChild.setText(child.getName());
            textFieldMiddleNameChild.setText(child.getMiddleName());

            if (child.getGender().equals(Gender.Boy)) {
                radioButtonBoy.setSelected(true);
            } else {
                radioButtonGirl.setSelected(true);
            }


            textFieldDateOfBirth.setText(child.getDateOfBirth());

//            comboBoxEmployees.setValue(child());
//            certificateValidityDateStart.setText(child.getCertificateValidityDate()[0]);
//            certificateValidityDateEnd.setText(child.getCertificateValidityDate()[1]);

//            comboBoxTypeSubscription.setValue(child.getSubscription());

//            String[] str1 = child.getSubscriptionValidity()[0].split(".");
//            LocalDate localDate1 = LocalDate.of(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
//            datePickerSubscriptionStart.setValue(localDate1);
//            labelSubscriptionEndDate.setText("?? " + child.getSubscriptionValidity()[1]);
//            labelNumberClasses.setText("???-?? ??????? - " + child.getNumberOfLessonsRemaining());

            labelOperation.setText("ќбновление клиента");
        }
    }

    @FXML
    void back(ActionEvent event) {
        Navigator.loadVista(Navigator.CUSTOMERS);
    }

    @FXML
    void saveCustomer(ActionEvent event) throws SQLException {

        Passport passport = new Passport(
                null,
                Integer.parseInt(textFieldPassportSeries.getText()),
                Integer.parseInt(textFieldPassportNumber.getText()),
                textFieldPassportDate.getText(),
                textFieldPassportIssuedBy.getText(),
                textFieldPassportAddress.getText());

        Contract contract = new Contract(
                null,
                textFieldContractNumber.getText(),
                textFieldContractDate.getText()
        );

        Child child = new Child(
                null,
                null,
                textFieldSurnameChild.getText(),
                textFieldNameChild.getText(),
                textFieldMiddleNameChild.getText(),
                Gender.valueOf(genderStr),
                dateOfBirthStr,
                textAreaNote.getText()
        );

        Client newClient = new Client(
                null,
                null,
                null,
                textFieldSurnameParent.getText(),
                textFieldNameParent.getText(),
                textFieldMiddleNameParent.getText(),
                textFieldPhoneNumber.getText(),
                textFieldContactPhoneNumber.getText());

        if (client != null) {

            //ќбновл€ю клиента, паспорт, контракт, ребенка
            clientObservableList.remove(client);

            newClient.setId(client.getId());
            passport.setIdClient(client.getId());
            contract.setIdClient(client.getId());
            child.setIdClient(client.getId());

            passportRep.update(passport);
            contractRepository.update(contract);
            childRep.update(child);
            clientRepository.update(newClient);

            clientObservableList.add(newClient);
        } else {

            //—охран€ю клиента, паспорт, контракт, ребенка

            passport.setId(passportRep.save(passport));
            contract.setId(contractRepository.save(contract));
            child.setId(childRep.save(child));

            newClient.setIdChild(child.getId());
            newClient.setIdPassport(passport.getId());
            newClient.setIdContract(contract.getId());

            newClient.setId(clientRepository.save(newClient));

            passport.setIdClient(newClient.getId());
            contract.setIdClient(newClient.getId());
            child.setIdClient(newClient.getId());

            passportRep.update(passport);
            contractRepository.update(contract);
            childRep.update(child);

            System.out.println("_____________");
            System.out.println("passport" + passport);
            System.out.println("child" + child);
            System.out.println("contract" + contract);
            System.out.println("client" + newClient);

            clientObservableList.add(newClient);
        }
        Navigator.loadVista(Navigator.CUSTOMERS);
    }

    @FXML
    void setEmployee(ActionEvent event) {
        employee = comboBoxEmployees.getValue();
    }

    @FXML
    void setSubscription(ActionEvent event) {
        subscription = comboBoxTypeSubscription.getValue();
        labelNumberClasses.setText("???-?? ??????? - " + subscription.getNumberClasses());
    }

    @FXML
    void setGender(ActionEvent event) {
        if (radioButtonBoy.isSelected()) {
            genderStr = Gender.Boy.name();
        } else {
            genderStr = Gender.Girl.name();
        }
    }

//    private class DeterminingDateOfBirth implements ChangeListener<Boolean> {
//        @Override
//        public void changed(ObservableValue<? extends Boolean> ov, Boolean oldb, Boolean newb) {
//            dateOfBirth = datePickerDateOfBirth.getValue();
//            LocalDate localDate = LocalDate.now();
//            labelYears.setText("?????? ??? - " + (localDate.getYear() - dateOfBirth.getYear()));
//            dateOfBirthStr = dateOfBirth.getDayOfMonth() + "." +
//                    dateOfBirth.getMonthValue() + "." + dateOfBirth.getYear();
//        }
//    }

//    private class DeterminingDateEndSubscription implements ChangeListener<Boolean> {
//        @Override
//        public void changed(ObservableValue<? extends Boolean> ov, Boolean oldb, Boolean newb) {
//            dateStartSubscription = datePickerSubscriptionStart.getValue();
//            Date date = new Date();
//            date.setDate(dateStartSubscription.getDayOfMonth());
//            date.setMonth(dateStartSubscription.getMonthValue());
//            date.setYear(dateStartSubscription.getYear());
//            date.setDate(date.getDate() + subscription.getValidity());
//            dateStartSubscriptionStr = dateStartSubscription.getDayOfMonth() + "." +
//                    dateStartSubscription.getMonthValue() + "." + dateStartSubscription.getYear();
//            dateEndSubscriptionStr = date.getDate() + "." + date.getMonth() + "." + date.getYear();
//            labelSubscriptionEndDate.setText("?? " + date.getDate() + "." + date.getMonth() + "." + date.getYear());
//        }
//    }
}

package sahan.abr.fx.controllers.customer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sahan.abr.fx.controllers.Navigator;
import sahan.abr.entities.*;
import sahan.abr.lib.LibSRM;

import java.time.LocalDate;
import java.util.Date;

import static sahan.abr.Main.observableListCustomers;
import static sahan.abr.Main.observableListEmployees;
import static sahan.abr.Main.observableListSubscriptions;

public class AddCustomerController {

    @FXML
    private Label labelOperation;

    @FXML
    private TextField textFieldSurnameParent;

    @FXML
    private TextField textFieldNameParent;

    @FXML
    private TextField textFieldMiddleNameParent;

    @FXML
    private TextArea textFieldPassport;

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
    private TextField textFieldShortNameChild;

    @FXML
    private TextField textFieldMiddleNameChild;

    @FXML
    private RadioButton radioButtonBoy;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton radioButtonGirl;

    @FXML
    private DatePicker datePickerDateOfBirth;

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

    private Customer customer;

    public AddCustomerController() {
    }

    public AddCustomerController(Customer customer) {
        this.customer = customer;
    }

    @FXML
    private void initialize() {

        datePickerDateOfBirth.focusedProperty().addListener(new DeterminingDateOfBirth());
        datePickerSubscriptionStart.focusedProperty().addListener(new DeterminingDateEndSubscription());

        comboBoxEmployees.setItems(observableListEmployees);
        comboBoxTypeSubscription.setItems(observableListSubscriptions);

        if (customer != null) {

            Parent parent = customer.getParent();

            textFieldSurnameParent.setText(parent.getSurname());
            textFieldNameParent.setText(parent.getName());
            textFieldMiddleNameParent.setText(parent.getMiddleName());
            textFieldPassport.setText(parent.getPassport());
            textFieldContractNumber.setText(parent.getContractNumber());
            textFieldContractDate.setText(parent.getContractDate());
            textFieldPhoneNumber.setText(parent.getPhoneNumber());
            textFieldContactPhoneNumber.setText(parent.getContactPhoneNumber());
            textFieldEmail.setText(parent.getEmail());
            textFieldVK.setText(parent.getVk());
            checkBoxNotCall.setSelected(parent.isNotCall());
            checkBoxNotEmail.setSelected(parent.isNotEmail());
            checkBoxNotVK.setSelected(parent.isNotVK());

            Child2 child = customer.getChildren();

            textFieldSurnameChild.setText(child.getSurname());
            textFieldNameChild.setText(child.getName());
            textFieldShortNameChild.setText(child.getShortName());
            textFieldMiddleNameChild.setText(child.getMiddleName());

            if (child.getGender().equals("�������")) {
                radioButtonBoy.setSelected(true);
            } else {
                radioButtonGirl.setSelected(true);
            }

          //  String[] str = child.getDateOfBirth().split(".");
           // LocalDate localDate = LocalDate.of(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
           // datePickerDateOfBirth.setValue(localDate);

            comboBoxEmployees.setValue(child.getTrainer());
            certificateValidityDateStart.setText(child.getCertificateValidityDate()[0]);
            certificateValidityDateEnd.setText(child.getCertificateValidityDate()[1]);
            comboBoxTypeSubscription.setValue(child.getSubscription());

           // String[] str1 = child.getSubscriptionValidity()[0].split(".");
           // LocalDate localDate1 = LocalDate.of(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
           // datePickerSubscriptionStart.setValue(localDate1);
            labelSubscriptionEndDate.setText("�� " + child.getSubscriptionValidity()[1]);
            labelNumberClasses.setText("���-�� ������� - " + child.getNumberOfLessonsRemaining());

            labelOperation.setText("���������� �������");
        }
    }

    @FXML
    void back(ActionEvent event) {
        Navigator.loadVista(Navigator.CUSTOMERS);
    }

    @FXML
    void saveCustomer(ActionEvent event) {
        if (customer != null) {

            Parent parent = customer.getParent();

            parent.setSurname(textFieldSurnameParent.getText());
            parent.setName(textFieldNameParent.getText());
            parent.setMiddleName(textFieldMiddleNameParent.getText());
            parent.setPassport(textFieldPassport.getText());
            parent.setContractNumber(textFieldContractNumber.getText());
            parent.setContractDate(textFieldContractDate.getText());
            parent.setPhoneNumber(textFieldPhoneNumber.getText());
            parent.setContactPhoneNumber(textFieldContactPhoneNumber.getText());
            parent.setEmail(textFieldEmail.getText());
            parent.setVk(textFieldVK.getText());
            parent.setNotCall(checkBoxNotCall.isSelected());
            parent.setNotEmail(checkBoxNotEmail.isSelected());
            parent.setNotVK(checkBoxNotVK.isSelected());
            customer.setFio(LibSRM.getFIO(customer.getParent()));
            customer.setPhoneNumber(customer.getParent().getPhoneNumber());

            Child2 child = customer.getChildren();
        } else {

            Child2 child = new Child2(0, textFieldSurnameChild.getText(), textFieldNameChild.getText(), textFieldShortNameChild.getText(),
                    textFieldMiddleNameChild.getText(), genderStr, dateOfBirthStr, new String[]{certificateValidityDateStart.getText(), certificateValidityDateEnd.getText()},
                    textAreaNote.getText(), subscription, subscription.getNumberClasses(), new String[]{dateStartSubscriptionStr, dateEndSubscriptionStr},
                    true, null, null);

            child.setTrainer(employee);

            Parent parent = new Parent(0, textFieldSurnameParent.getText(), textFieldNameParent.getText(),
                    textFieldMiddleNameParent.getText(), textFieldPassport.getText(), textFieldContractNumber.getText(),
                    textFieldContractDate.getText(), textFieldPhoneNumber.getText(), textFieldContactPhoneNumber.getText(),
                    textFieldEmail.getText(), textFieldVK.getText(), checkBoxNotCall.isSelected(), checkBoxNotEmail.isSelected(),
                    checkBoxNotVK.isSelected(), "0");

            Customer customer = new Customer(parent, child);
            observableListCustomers.add(customer);
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
        labelNumberClasses.setText("���-�� ������� - " + subscription.getNumberClasses());
    }

    @FXML
    void setGender(ActionEvent event) {
        if (radioButtonBoy.isSelected()) {
            genderStr = "�������";
        } else {
            genderStr = "�������";
        }
    }

    private class DeterminingDateOfBirth implements ChangeListener<Boolean> {
        @Override
        public void changed(ObservableValue<? extends Boolean> ov, Boolean oldb, Boolean newb) {
            dateOfBirth = datePickerDateOfBirth.getValue();
            LocalDate localDate = LocalDate.now();
            labelYears.setText("������ ��� - " + (localDate.getYear() - dateOfBirth.getYear()));
            dateOfBirthStr = dateOfBirth.getDayOfMonth() + "." +
                    dateOfBirth.getMonthValue() + "." + dateOfBirth.getYear();
        }
    }

    private class DeterminingDateEndSubscription implements ChangeListener<Boolean> {
        @Override
        public void changed(ObservableValue<? extends Boolean> ov, Boolean oldb, Boolean newb) {
            dateStartSubscription = datePickerSubscriptionStart.getValue();
            Date date = new Date();
            date.setDate(dateStartSubscription.getDayOfMonth());
            date.setMonth(dateStartSubscription.getMonthValue());
            date.setYear(dateStartSubscription.getYear());
            date.setDate(date.getDate() + subscription.getValidity());
            dateStartSubscriptionStr = dateStartSubscription.getDayOfMonth() + "." +
                    dateStartSubscription.getMonthValue() + "." + dateStartSubscription.getYear();
            dateEndSubscriptionStr = date.getDate() + "." + date.getMonth() + "." + date.getYear();
            labelSubscriptionEndDate.setText("�� " + date.getDate() + "." + date.getMonth() + "." + date.getYear());
        }
    }
}

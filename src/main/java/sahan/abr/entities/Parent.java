package sahan.abr.entities;

public class Parent {

    /** Id родителя */
    private Integer id;

    /** Фамилия */
    private String surname;

    /** Имя */
    private String name;

    /** Отчество */
    private String middleName;

    /** Номер телефона */
    private String phoneNumber;

    /** Номер телефона для связи */
    private String contactPhoneNumber;


    // ПАСПОРТ

    /** Серия паспорта */
    private String passportSeries;

    /** Номер паспорта */
    private String passportID;

    /** Кем выдан паспорт */
    private String passportIssuedBy;

    /** Дата выдачи паспорта */
    private String passportIssueDate;

    /** Код подразделения выдачи паспорта */
    private String unitCode;


    // ДОГОВОР

    /** Дата заключения договора */
    private String dateContract;

    /** Номер договора */
    private String contractNumber;


    // ДЕТИ

    /** ID детей */
    private String childrenId;

    public Parent() {
    }

    public Parent(Integer id, String surname,
                  String name, String middleName,
                  String phoneNumber, String contactPhoneNumber,
                  String passportSeries, String passportID,
                  String passportIssuedBy, String passportIssueDate,
                  String unitCode, String dateContract,
                  String contractNumber, String childrenId) {

        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.contactPhoneNumber = contactPhoneNumber;
        this.passportSeries = passportSeries;
        this.passportID = passportID;
        this.passportIssuedBy = passportIssuedBy;
        this.passportIssueDate = passportIssueDate;
        this.unitCode = unitCode;
        this.dateContract = dateContract;
        this.contractNumber = contractNumber;
        this.childrenId = childrenId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public String getPassportIssuedBy() {
        return passportIssuedBy;
    }

    public void setPassportIssuedBy(String passportIssuedBy) {
        this.passportIssuedBy = passportIssuedBy;
    }

    public String getPassportIssueDate() {
        return passportIssueDate;
    }

    public void setPassportIssueDate(String passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getDateContract() {
        return dateContract;
    }

    public void setDateContract(String dateContract) {
        this.dateContract = dateContract;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getChildrenId() {
        return childrenId;
    }

    public void setChildrenId(String childrenId) {
        this.childrenId = childrenId;
    }
}


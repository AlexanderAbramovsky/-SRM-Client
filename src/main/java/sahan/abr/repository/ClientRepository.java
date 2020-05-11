package sahan.abr.repository;

import sahan.abr.entities.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements CRUDRepository<Client> {

    private final static String FOR_NAME = "org.sqlite.JDBC";
    private final static String URL = "jdbc:sqlite:testDB.s3db";

    private final static String INSERT = "INSERT INTO CLIENT (ID_PASSPORT, ID_CHILD, ID_CONTRACT, SURNAME, NAME, MIDDLE_NAME, PHONE_NUMBER, CONTACT_PHONE_NUMBER) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE CLIENT SET ID_PASSPORT = ?, ID_CHILD = ?, ID_CONTRACT = ?, SURNAME = ?, NAME = ?, MIDDLE_NAME = ?, PHONE_NUMBER = ?, CONTACT_PHONE_NUMBER = ?  WHERE ID = ?";
    private final static String DELETE = "DELETE FROM CLIENT WHERE ID = ?";
    private final static String SELECT_ALL = "SELECT * FROM CLIENT";
    private final static String SELECT_BY_ID = "SELECT * FROM CLIENT WHERE ID = ?";

    public static Connection connection;

    public ClientRepository() throws SQLException, ClassNotFoundException {
        Class.forName(FOR_NAME);
        connection = DriverManager.getConnection(URL);
        System.out.println("Есть подключение!");
    }

    @Override
    public Client getById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();

        result.next();
        if (result.isFirst()) {
            int idClient = result.getInt("ID");
            int idPassport = result.getInt("ID_PASSPORT");
            int idChild = result.getInt("ID_CHILD");
            int idContract = result.getInt("ID_CONTRACT");
            String surname = result.getString("SURNAME");
            String name = result.getString("NAME");
            String middleName = result.getString("MIDDLE_NAME");
            String phoneNumber = result.getString("PHONE_NUMBER");
            String contactPhoneNumber = result.getString("CONTACT_PHONE_NUMBER");
            return new Client(idClient, idPassport, idChild, idContract, surname, name, middleName, phoneNumber, contactPhoneNumber);
        }

        return null;
    }

    @Override
    public List<Client> getAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
        ResultSet result = statement.executeQuery();

        List<Client> clients = new ArrayList<>();

        while (result.next()) {
            int idClient = result.getInt("ID");
            int idPassport = result.getInt("ID_PASSPORT");
            int idChild = result.getInt("ID_CHILD");
            int idContract = result.getInt("ID_CONTRACT");
            String surname = result.getString("SURNAME");
            String name = result.getString("NAME");
            String middleName = result.getString("MIDDLE_NAME");
            String phoneNumber = result.getString("PHONE_NUMBER");
            String contactPhoneNumber = result.getString("CONTACT_PHONE_NUMBER");
            clients.add(new Client(idClient, idPassport, idChild, idContract, surname, name, middleName, phoneNumber, contactPhoneNumber));
        }

        return clients;
    }


    @Override
    public int save(Client data) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, data.getIdPassport());
        statement.setInt(2, data.getIdChild());
        statement.setInt(3, data.getIdContract());
        statement.setString(4, data.getSurname());
        statement.setString(5, data.getName());
        statement.setString(6, data.getMiddleName());
        statement.setString(7, data.getPhoneNumber());
        statement.setString(8, data.getContactPhoneNumber());
        return executeId(statement);
    }

    @Override
    public boolean update(Client data) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE);
        statement.setInt(1, data.getIdPassport());
        statement.setInt(2, data.getIdChild());
        statement.setInt(3, data.getIdContract());
        statement.setString(4, data.getSurname());
        statement.setString(5, data.getName());
        statement.setString(6, data.getMiddleName());
        statement.setString(7, data.getPhoneNumber());
        statement.setString(8, data.getContactPhoneNumber());
        statement.setInt(9, data.getId());
        return executeDML(statement);
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DELETE);
        statement.setInt(1, id);
        return executeDML(statement);
    }
}

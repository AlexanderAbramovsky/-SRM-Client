package sahan.abr.repository;

import sahan.abr.entities.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements CRUDRepository<Contract> {

    private final static String FOR_NAME = "org.sqlite.JDBC";
    private final static String URL = "jdbc:sqlite:testDB.s3db";

    private final static String INSERT = "INSERT INTO CONTRACT (ID_CLIENT, NUMBER, DATE) VALUES (?, ?, ?)";
    private final static String UPDATE = "UPDATE CONTRACT SET ID_CLIENT = ?, NUMBER = ?, DATE = ?, WHERE ID = ?";
    private final static String DELETE = "DELETE FROM CONTRACT WHERE ID = ?";
    private final static String SELECT_ALL = "SELECT * FROM CONTRACT";
    private final static String SELECT_BY_ID = "SELECT * FROM CONTRACT WHERE ID = ?";

    public static Connection connection;

    public ContractRepository() throws ClassNotFoundException, SQLException {
        Class.forName(FOR_NAME);
        connection = DriverManager.getConnection(URL);
        System.out.println("Есть подключение!");
    }

    @Override
    public Contract getById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();

        result.next();
        if (result.isFirst()) {
            int idContract = result.getInt("ID");
            int idClient = result.getInt("ID_CLIENT");
            String number = result.getString("NUMBER");
            String date = result.getString("DATE");
            return new Contract(idContract, idClient, number, date);
        }

        return null;
    }

    @Override
    public List<Contract> getAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
        ResultSet result = statement.executeQuery();

        List<Contract> contracts = new ArrayList<>();

        while (result.next()) {
            int idContract = result.getInt("ID");
            int idClient = result.getInt("ID_CLIENT");
            String number = result.getString("NUMBER");
            String date = result.getString("DATE");
            contracts.add(new Contract(idContract, idClient, number, date));
        }

        return contracts;
    }

    @Override
    public int save(Contract data) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, data.getIdClient());
        statement.setString(2, data.getNumber());
        statement.setString(3, data.getDate());
        return executeId(statement);
    }

    @Override
    public boolean update(Contract data) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE);
        statement.setInt(1, data.getIdClient());
        statement.setString(2, data.getNumber());
        statement.setString(3, data.getDate());
        statement.setInt(4, data.getId());
        return executeDML(statement);
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DELETE);
        statement.setInt(1, id);
        return executeDML(statement);
    }
}

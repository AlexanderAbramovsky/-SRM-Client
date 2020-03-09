package sahan.abr.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sahan.abr.service.Subscription;

public class SubscriptionRepository implements CRUDRepository<Subscription> {

    private static String FOR_NAME = "org.sqlite.JDBC";
    private static String URL = "jdbc:sqlite:testDB.s3db";

    private static String INSERT = "INSERT INTO SUBSCRIPTION ('NAME') VALUES (?);";
    private static String UPDATE = "UPDATE  SUBSCRIPTION SET NAME = ? WHERE ID = ?;";
    private static String DELETE = "DELETE FROM SUBSCRIPTION WHERE ID = ?";
    private static String SELECT_ALL = "SELECT * FROM SUBSCRIPTION";
    private static String SELECT_BY_ID = "SELECT * FROM SUBSCRIPTION WHERE ID = ?";

    public static Connection connection;

    public SubscriptionRepository() throws ClassNotFoundException, SQLException {
        Class.forName(FOR_NAME);
        connection = DriverManager.getConnection(URL);
        System.out.println("База Подключена!");
    }

    @Override
    public Subscription getById(int id) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();

        if (result.isFirst()) {
            int idSubscription = result.getInt("ID");
            String nameSubscription = result.getString("NAME");
            return new Subscription(idSubscription, nameSubscription);
        }

        return null;
    }


    @Override
    public List<Subscription> getAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
        ResultSet result = statement.executeQuery();

        List<Subscription> subscriptions = new ArrayList<>();

        while (result.next()) {
            int id = result.getInt("ID");
            String name = result.getString("NAME");
            subscriptions.add(new Subscription(id, name));
        }

        return subscriptions;
    }

    @Override
    public void save(Subscription data) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT);
        statement.setString(1, data.getFirstName());
        statement.execute();
    }

    @Override
    public void update(Subscription data) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE);
        statement.setString(1, data.getFirstName());
        statement.setInt(2, data.getId());
        statement.execute();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DELETE);
        statement.setInt(1, id);
        statement.execute();
    }
}

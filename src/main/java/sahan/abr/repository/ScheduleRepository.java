package sahan.abr.repository;

import sahan.abr.entities.Schedule;
import sahan.abr.entities.ScheduleRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleRepository implements CRUDRepository<Schedule> {

    private final static String INSERT = "INSERT INTO SCHEDULE (ROLE, ID_ROLE, DATE, S_TIME, E_TIME) VALUES (?, ?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE SCHEDULE SET ROLE = ?, ID_ROLE = ?, DATE = ?, S_TIME = ?, E_TIME = ? WHERE ID = ?";
    private final static String DELETE = "DELETE FROM SCHEDULE WHERE ID = ?";
    private final static String SELECT_ALL = "SELECT * FROM SCHEDULE";
    private final static String SELECT_BY_ID = "SELECT * FROM SCHEDULE WHERE ID = ?";

    private final static String SELECT_BY_ID_ROLE_AND_DATE = "SELECT * FROM SCHEDULE WHERE ID_ROLE = ? AND DATE = ?";

    public static Connection connection;

    public ScheduleRepository(Connection connection) {
        this.connection = connection;
        System.out.println("База Подключена!");
    }

    @Override
    public Schedule getById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        result.next();
        if (result.isFirst()) {
            int idSchedule = result.getInt("ID");
            String role = result.getString("ROLE");
            int idRole = result.getInt("ID_ROLE");
            String date = result.getString("DATE");
            String sTime = result.getString("S_TIME");
            String eTime = result.getString("E_TIME");
            return new Schedule(idSchedule, ScheduleRole.valueOf(role), idRole, date, sTime, eTime);
        }
        return null;
    }

    public Schedule getByIdRoleAndDate(int idRole, String date) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_ROLE_AND_DATE);
        statement.setInt(1, idRole);
        statement.setString(2, date);

        ResultSet result = statement.executeQuery();
        result.next();

        while (result.isFirst()) {
            int idSchedule = result.getInt("ID");
            String role = result.getString("ROLE");
            int idRoleSchedule = result.getInt("ID_ROLE");
            String dateSchedule = result.getString("DATE");
            String sTimeSchedule = result.getString("S_TIME");
            String eTimeSchedule = result.getString("E_TIME");
            return new Schedule(idSchedule, ScheduleRole.valueOf(role), idRoleSchedule, dateSchedule, sTimeSchedule, eTimeSchedule);
        }

        return null;
    }

    @Override
    public List<Schedule> getAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
        ResultSet result = statement.executeQuery();

        List<Schedule> schedules = new ArrayList<>();

        while (result.next()) {
            int idSchedule = result.getInt("ID");
            String role = result.getString("ROLE");
            int idRole = result.getInt("ID_ROLE");
            String date = result.getString("DATE");
            String sTime = result.getString("S_TIME");
            String eTime = result.getString("E_TIME");
            schedules.add(new Schedule(idSchedule, ScheduleRole.valueOf(role), idRole, date, sTime, eTime));
        }

        return schedules;
    }

    @Override
    public int save(Schedule data) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, data.getRole().name());
        statement.setInt(    2, data.getIdRole());
        statement.setString(3, data.getDate());
        statement.setString(4, data.getSTime());
        statement.setString(5, data.getETime());

        return executeId(statement);
    }

    @Override
    public boolean update(Schedule data) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE);
        statement.setString(1, data.getRole().name());
        statement.setInt(    2, data.getIdRole());
        statement.setString(3, data.getDate());
        statement.setString(4, data.getSTime());
        statement.setString(5, data.getETime());
        statement.setInt(6, data.getId());
        return executeDML(statement);
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DELETE);
        statement.setInt(1, id);
        return executeDML(statement);
    }
}

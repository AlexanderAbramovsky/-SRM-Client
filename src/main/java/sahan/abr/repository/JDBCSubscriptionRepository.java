package sahan.abr.repository;

import sahan.abr.entities.Subscription;
import sahan.abr.repository.sql.SqlQuery;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

import java.util.List;

import static sahan.abr.repository.sql.SqlQuery.DATABASE_URL;

public class JDBCSubscriptionRepository implements CRUDRepository<Subscription> {

    public static void main(String[] args) {
        try {
//            Class.forName("org.h2.Driver").newInstance();

            Connection conn = DriverManager.getConnection("jdbc:h2:~/test");
            Statement st = null;
            st = conn.createStatement();
           // st.execute(SqlQuery.createTable("Sahan"));

//            st.execute(SqlQuery.insertValue("1, 'polina'", "Sahan"));
//            st.execute(SqlQuery.insertValue("2, 'sahan'", "Sahan"));


            String name1 = "Jack";
            String q = "insert into TEST(name) values(?)";
            PreparedStatement st1 = null;

            st1 = conn.prepareStatement(q);
            st1.setString(1, name1);
            st1.execute();

            ResultSet result;
            result = st.executeQuery("SELECT * FROM Sahan");
            while (result.next()) {

                String name = result.getString("NAME");
                System.out.println(result.getString("Personid")+" "+name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean save(Subscription data) {
        return false;
    }

    @Override
    public boolean update(Subscription data) {
        return false;
    }

    @Override
    public boolean delete(Subscription data) {
        return false;
    }

    @Override
    public Subscription findById(int id) {
        return null;
    }

    @Override
    public List<Subscription> findAll() {
        return null;
    }
}

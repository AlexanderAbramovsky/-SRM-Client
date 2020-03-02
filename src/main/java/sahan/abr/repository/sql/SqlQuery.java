package sahan.abr.repository.sql;

public class SqlQuery {
    public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static String DATABASE_URL = "jdbc:h2:~/test";

    public static String createTable(String tableName) {
        return "CREATE TABLE " + tableName + " (" +
                "    Personid int NOT NULL AUTO_INCREMENT," +
                "    NAME varchar(255) NOT NULL," +
                "    PRIMARY KEY (Personid)" +
                ");";
    }

    public static String insertValue(String value, String tableName) {
         return "INSERT INTO " + tableName + " VALUES (" + value + ")";
    }
}

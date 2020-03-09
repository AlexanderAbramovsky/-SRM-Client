package sahan.abr.repository;

import java.sql.SQLException;
import java.util.List;

public interface CRUDRepository<T> {

    T getById(int id) throws SQLException;

    List<T> getAll() throws SQLException;

    void save(T data) throws SQLException;

    void update(T data) throws SQLException;

    void deleteById(int id) throws SQLException;
}

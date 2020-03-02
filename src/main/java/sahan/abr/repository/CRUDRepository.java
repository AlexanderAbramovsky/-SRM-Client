package sahan.abr.repository;

import java.util.List;

public interface CRUDRepository<T> {
    boolean save(T data);

    boolean update(T data);

    boolean delete(T data);

    T findById(int id);

    List<T> findAll();
}

package ru.itis.mystery_shopper_managment.repositories;

import java.util.List;

public interface CrudRepository<T, V> {
    void save(T model);

    T findOne(V id);

    void update(T model);

    void delete(V id);

    List<T> findAll();
}

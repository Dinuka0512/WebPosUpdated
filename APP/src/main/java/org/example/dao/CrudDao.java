package org.example.dao;

import java.util.ArrayList;

public interface CrudDao<T> extends SuperDAO{
    ArrayList<T> getAll();
    boolean save(T dto);
    boolean update(T dto);
    boolean exist(String id);
    boolean delete(String id);
    String generateNewId();
    T search(String id);
}

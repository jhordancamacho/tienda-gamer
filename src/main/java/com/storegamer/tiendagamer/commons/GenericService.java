package com.storegamer.tiendagamer.commons;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericService <T,ID extends Serializable>{
    T save(T entity);

    void delete(ID id);

    T get(ID id);

    List<T> getAll();

    List<T> getAllById(ID id);

    Map<String, Object> msg(boolean status, String msg);
}

package com.storegamer.tiendagamer.commons;

import com.storegamer.tiendagamer.modelo.Alquiler;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GenericService <T,ID extends Serializable>{
    T save(T entity);

    void delete(ID id);

    T get(ID id);

    List<T> getAll();


    Map<String, Object> msg(boolean status, String msg);

}

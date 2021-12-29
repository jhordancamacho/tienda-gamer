package com.storegamer.tiendagamer.commons;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {


    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T get(ID id) {
        Optional<T> obj = getDao().findById(id);
        if(obj.isPresent()) {
            return obj.get();
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        List<T> returnList = new ArrayList<>();
        getDao().findAll().forEach(obj -> returnList.add(obj));
        return returnList;
    }
    @Override
    public List<T> getAllById(ID id) {
        Optional<T> obj = getDao().findById(id);
        if(obj.isPresent()) {
        List<ID> idList=Arrays.asList(id);
        return (List<T>)  getDao().findAllById(idList);
        }
        return null;
    }

    @Override
    public Map<String, Object> msg(boolean status, String msg) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("msg", msg);
        respuesta.put("status", status);
        return respuesta;
    }

    public abstract CrudRepository<T, ID> getDao();

}

package com.joshguna.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService<T, ID> {

    //We use this to abstract this component from the app
    //No objs needed from here. Only CRUD
    //This is also not interface as there'll be method with implementation

    protected Map<ID, T> map = new HashMap<>();

    T save(ID id, T object) {
        map.put(id, object);
        return object;
    }

    T findByID(ID id) {
        return map.get(id);
    }

    List<T> findAll() {
        return new ArrayList<>(map.values());
    }

    void deleteByID(ID id) {
        map.remove(id);
    }


}

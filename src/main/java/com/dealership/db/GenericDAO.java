package com.dealership.db;

import com.dealership.util.dealershipCollection;

import java.sql.SQLException;


/**
 * A dao contract to determine functionality in the GymDao objects.
 * @param <T> The class used for this dao object.
 * @param <I> The primary key used by the class.
 */

public interface GenericDAO<T> {



    void save(T t);
    //select an object by its primary key
    T getById(T id) throws SQLException;

    //gather all objects in the db
    dealershipCollection getAll();

    //delete an object from the db
    boolean remove(T id);

    //update an object in the db
    boolean update(T t);

    //update all records in a table that correspond to the objects inside the GymCollection argument
    int updateAll(dealershipCollection collection);
}

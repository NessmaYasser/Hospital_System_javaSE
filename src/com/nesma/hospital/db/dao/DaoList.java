
package com.nesma.hospital.db.dao;

import java.util.List;

/**
 * generic interface
 * @param <T> (objects from different "types") 
 * operations on database
 */
public interface DaoList <T>{
    // load the whole database    
    public List <T> loadAll() throws Exception;
    //insert in database
    public int insert(T t) throws Exception;
    //update the datebase
    public int update(T t) throws Exception;
    //delet from database
    public int delet(T t) throws Exception;
    //select from database
    public T getData(T t) throws Exception;
}

package com.jmat.skripsicall.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by User on 2/28/2016.
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable>  extends CrudRepository<T,ID> {

    /**
    void delete(T deleted);

    List<T> findAll();

    T findOne(ID id);

    <S extends T> S save(S entity);

    T save(T persisted);

    Boolean delete (T persisted);

    boolean isDeleted(T persisted);

    */
    void remove(T persisted);
}

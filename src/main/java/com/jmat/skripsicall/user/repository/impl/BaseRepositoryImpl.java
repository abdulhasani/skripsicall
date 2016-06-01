package com.jmat.skripsicall.user.repository.impl;



import com.jmat.skripsicall.support.entity.AbstractEntity;
import com.jmat.skripsicall.user.repository.BaseRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;


/**
 * Created by User on 2/28/2016.
 */
@NoRepositoryBean
public class BaseRepositoryImpl<T extends AbstractEntity, ID extends Serializable> extends SimpleJpaRepository<T ,ID> implements BaseRepository<T, ID> {

    protected Class<T> entityClass;

    private final EntityManager entityManager;
    private final JpaEntityInformation<T, ?> entityInformation;


    public BaseRepositoryImpl(JpaEntityInformation<?, Serializable> entityInformation, Class<?> domainClass, EntityManager entityManager ) {
        super((Class<T>) domainClass, entityManager);

        // Keep the EntityManager around to used from the newly introduced methods.
        this.entityManager = entityManager;
        this.entityInformation = (JpaEntityInformation<T, ?>) entityInformation;
    }

    private  Class<?> springDataRepositoryInterface;

    public Class<?> getSpringDataRepositoryInterface() {
        return springDataRepositoryInterface;
    }

    public void setSpringDataRepositoryInterface(
            Class<?> springDataRepositoryInterface) {
        this.springDataRepositoryInterface = springDataRepositoryInterface;
    }

    @Override
    public void delete(T deleted) {
    }

    @Override
    public List<T> findAll() {
        return super.findAll();
   }


    @Override
    public void remove(T persisted) {
        super.delete(persisted);
    }
}

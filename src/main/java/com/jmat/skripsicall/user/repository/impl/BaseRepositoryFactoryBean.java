package com.jmat.skripsicall.user.repository.impl;



import com.jmat.skripsicall.support.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by User on 2/28/2016.
 */
public class BaseRepositoryFactoryBean <R extends JpaRepository<T, I>, T,
        I extends Serializable> extends JpaRepositoryFactoryBean<R, T, I> {

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager em){
        return new BaseRepositoryFactory(em);
    }

    private static class BaseRepositoryFactory<T extends AbstractEntity, I extends Serializable> extends JpaRepositoryFactory{

        private final EntityManager entityManager;

        /**
         * Creates a new {@link JpaRepositoryFactory}.
         *
         * @param entityManager must not be {@literal null}
         */
        public BaseRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
            Assert.notNull(entityManager);
            this.entityManager=entityManager;
        }

        @Override
        protected Object getTargetRepository(RepositoryMetadata metadata) {
            Class<?> repositoryInterface = metadata.getRepositoryInterface();
            JpaEntityInformation<?, Serializable> entityInformation =  getEntityInformation(metadata.getDomainType());//repositoryInterface
            return new BaseRepositoryImpl<T , I>(entityInformation,metadata.getDomainType(), entityManager);
        }

        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return BaseRepositoryImpl.class;
        }
    }
}

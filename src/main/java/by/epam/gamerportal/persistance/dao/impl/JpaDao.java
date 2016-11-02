package by.epam.gamerportal.persistance.dao.impl;

import by.epam.gamerportal.persistance.dao.IJpaDao;
import by.epam.gamerportal.persistance.exception.DaoException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Yayheniy_Lepkovich on 10/31/2016.
 */

@Repository
public abstract class JpaDao<T extends Serializable> implements IJpaDao<T>{
    @Setter @Getter
    @PersistenceContext
    private EntityManager entityManager;

    @Setter
    private Class<T> entityClass;

    public JpaDao(){
    }


    public T findById(long id){
        return entityManager.find(entityClass, id);
    }

    public List<T> getAll(){
        return entityManager.createQuery("select * from " + entityClass.getName()).getResultList();
    }

    public void add(T entity) throws DaoException {
        try {
            entityManager.persist(entity);
            entityManager.flush();
        } catch (Exception e){
            throw new DaoException(e.getMessage(), e);
        }
    }

    public void update(T entity){
        entityManager.merge(entity);
    }

    public void delete(T entity){
        entityManager.remove(entity);
        entityManager.flush();
    }

    public void deleteById(long id){
        T entity = entityManager.find(entityClass, id);
        delete(entity);
    }
}

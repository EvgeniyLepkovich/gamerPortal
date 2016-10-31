package by.epam.gamerportal.persistance.dao.impl;

import by.epam.gamerportal.persistance.dao.IJpaDao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Yayheniy_Lepkovich on 10/31/2016.
 */
public abstract class JpaDao<T extends Serializable> implements IJpaDao<T>{
    @Setter @Getter
    protected EntityManager EM;

    @Setter
    private Class<T> entityClass;

    protected JpaDao(){
        EM = Persistence.createEntityManagerFactory("PRODUCTION").createEntityManager();
    }

    public T findById(long id){
        return EM.find(entityClass, id);
    }

    public List<T> getAll(){
        return EM.createQuery("select * from " + entityClass.getName()).getResultList();
    }

    public void add(T entity){
        EM.persist(entity);
    }

    public void update(T entity){
        EM.merge(entity);
    }

    public void delete(T entity){
        EM.remove(entity);
    }

    public void deleteById(long id){
        T entity = EM.find(entityClass, id);
        delete(entity);
    }
}

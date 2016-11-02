package by.epam.gamerportal.service.impl;

import by.epam.gamerportal.persistance.dao.IJpaDao;
import by.epam.gamerportal.persistance.dao.impl.JpaDao;
import by.epam.gamerportal.persistance.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yayheniy_Lepkovich on 11/2/2016.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class JpaCrudService<T> implements IJpaDao<T> {
    @Autowired
    private JpaDao jpaDao;

    @Override
    public T findById(long id) {
        return (T) jpaDao.findById(id);
    }

    @Override
    public List<T> getAll() {
        return jpaDao.getAll();
    }

    @Override

    public void add(T entity) throws DaoException {
        jpaDao.add(entity);
    }

    @Override
    public void update(T entity) {
        jpaDao.update(entity);
    }

//    @Override
//    @Transactional
//    public void delete(T entity) {
//        jpaDao.delete(entity);
//    }

    @Override
    public void deleteById(long id) {
        jpaDao.deleteById(id);
    }
}

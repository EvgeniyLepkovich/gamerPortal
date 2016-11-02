package by.epam.gamerportal.service.impl;

import by.epam.gamerportal.persistance.dao.impl.SectionDao;
import by.epam.gamerportal.persistance.exception.DaoException;
import by.epam.gamerportal.persistance.to.Section;
import by.epam.gamerportal.service.ISectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yayheniy_Lepkovich on 10/31/2016.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SectionService extends JpaCrudService<Section> implements ISectionService {
    @Autowired
    private SectionDao sectionDao;

//    public Section findById(long id) {
//        return (Section) sectionDao.findById(id);
//    }
//
//    public List getAll() {
//        return sectionDao.getAll();
//    }
//
//    @Override
//    @Transactional
//    public void add(Section entity) throws DaoException {
//        sectionDao.add(entity);
//    }
//
//    @Override
//    public void update(Section entity) {
//
//    }
//
//    @Override
//    public void delete(Section entity) {
//
//    }
//
//    @Transactional
//    public void deleteById(long id) {
//        sectionDao.deleteById(id);
//    }
}

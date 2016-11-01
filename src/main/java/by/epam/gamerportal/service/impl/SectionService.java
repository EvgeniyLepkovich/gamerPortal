package by.epam.gamerportal.service.impl;

import by.epam.gamerportal.persistance.dao.impl.SectionDao;
import by.epam.gamerportal.persistance.to.Section;
import by.epam.gamerportal.service.ISectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yayheniy_Lepkovich on 10/31/2016.
 */
@Service
public class SectionService implements ISectionService {
    @Autowired
    private SectionDao sectionDao;

    public Serializable findById(long id) {
        return null;
    }

    public List getAll() {
        return sectionDao.getAll();
    }

    public void add(Serializable entity) {

    }

    public void update(Serializable entity) {

    }

    public void delete(Serializable entity) {

    }

    public void deleteById(long id) {

    }
}

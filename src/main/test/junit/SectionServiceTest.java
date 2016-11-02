package junit;

import by.epam.gamerportal.config.AppContext;
import by.epam.gamerportal.persistance.dao.impl.SectionDao;
import by.epam.gamerportal.persistance.exception.DaoException;
import by.epam.gamerportal.persistance.to.Section;
import by.epam.gamerportal.service.impl.SectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yayheniy_Lepkovich on 11/1/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppContext.class}, loader = AnnotationConfigContextLoader.class)
public class SectionServiceTest {
    @Autowired
    SectionDao sectionDao;

    @Test
    public void testGetAll() throws Exception {
        List list = sectionDao.getAll();
        Assert.notNull(list);
    }

    @Test
    @Transactional
    public void testAdd() throws Exception {
        Section section = new Section();
        section.setParentId(0);
        section.setSectionName("LOL");
        sectionDao.add(section);
    }
}
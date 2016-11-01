package dbunit;

import by.epam.gamerportal.config.AppContext;
import by.epam.gamerportal.config.TestDataBaseConfig;
import by.epam.gamerportal.persistance.dao.impl.SectionDao;
import by.epam.gamerportal.persistance.to.Section;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import config.DbUnitConfig;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;

/**
 * Created by Yayheniy_Lepkovich on 11/1/2016.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDataBaseConfig.class}, loader = AnnotationConfigContextLoader.class)
public class JpaDaoTest{

    @Autowired
    private SectionDao sectionDao;

    public JpaDaoTest() {

    }


    @DatabaseSetup("testdata/section/section-data.xml")
    @DatabaseTearDown("testdata/section/section-tear-down.xml")
    @Test
    public void testFindById() throws Exception {
        Section section = (Section) sectionDao.findById(1);
        Assert.assertEquals("CS:GO", section.getSectionName());
    }

//    @Test
//    public void testGetAll() throws Exception {
//
//    }
//
//    @Test
//    public void testAdd() throws Exception {
//
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//
//    }
//
//    @Test
//    public void testDelete() throws Exception {
//
//    }
//
//    @Test
//    public void testDeleteById() throws Exception {
//
//    }
}
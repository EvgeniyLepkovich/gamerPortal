package dbunit;

import by.epam.gamerportal.config.TestDataBaseConfig;
import by.epam.gamerportal.persistance.dao.impl.SectionDao;
import by.epam.gamerportal.persistance.to.Section;
import by.epam.gamerportal.service.impl.SectionService;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yayheniy_Lepkovich on 11/1/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDataBaseConfig.class}, loader = AnnotationConfigContextLoader.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseTearDown(value = "/data/section/section-tear-down.xml")
public class SectionDaoTest {

    @Autowired
    private SectionService sectionService;

    public SectionDaoTest() {
    }

    @Test
    @DatabaseSetup(value = "/data/section/section-data.xml")
    public void testFindById(){
        Section section = sectionService.findById(2);
        Assert.assertEquals("Dota 2", section.getSectionName());
        Assert.assertEquals(1, section.getArticles().size());
    }

    @Test
    @DatabaseSetup(value = "/data/section/section-data.xml")
    public void testGetAll(){
        List<Section> sections = sectionService.getAll();
        Assert.assertEquals(2, sections.size());
        Assert.assertEquals("CS:GO", sections.get(0).getSectionName());
        Assert.assertEquals("Dota 2", sections.get(1).getSectionName());
    }

    @Test
    @DatabaseSetup(value = "/data/section/section-data.xml")
    @ExpectedDatabase(value = "/data/section/section-expected-update.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testUpdate(){
        Section section = new Section();
        section.setId(1);
        section.setParentId(0);
        section.setSectionName("LOL");
        section.setDescription("");
        sectionService.update(section);
    }

//    @Test
//    @DatabaseSetup(value = "/data/section/section-data.xml")
//    @ExpectedDatabase(value = "/data/section/section-expected-remove.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
//    public void testDelete(){
//        Section section = sectionService.findById(2);
//        sectionService.delete(section);
//    }

    @Test
    @DatabaseSetup(value = "/data/section/section-data.xml")
    @ExpectedDatabase(value = "/data/section/section-expected-add.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testAdd() throws Exception {
        Section section = new Section();
        section.setParentId(0);
        section.setSectionName("LOL");
        section.setDescription("");
        sectionService.add(section);
    }

    @Test
    @DatabaseSetup(value = "/data/section/section-data.xml")
    @ExpectedDatabase(value = "/data/section/section-expected-remove.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testDeleteById() throws Exception{
        sectionService.deleteById(2);
    }
}
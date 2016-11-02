package by.epam.gamerportal.persistance.dao.impl;

import by.epam.gamerportal.persistance.dao.ISectionDao;
import by.epam.gamerportal.persistance.to.Section;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yayheniy_Lepkovich on 10/31/2016.
 */

@Repository
@Scope("prototype")
public class SectionDao extends JpaDao<Section> implements ISectionDao {
    public SectionDao(){
        super();
        setEntityClass(Section.class);
    }
}

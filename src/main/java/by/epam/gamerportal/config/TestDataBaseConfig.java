package by.epam.gamerportal.config;

import by.epam.gamerportal.persistance.dao.impl.SectionDao;
import by.epam.gamerportal.service.impl.SectionService;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Yayheniy_Lepkovich on 11/1/2016.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(value = {"by.epam.gamerportal.persistance", "by.epam.gamerportal.service"})
@PropertySource("classpath:db.properties")
public class TestDataBaseConfig extends DataBase {
    @Value("${dbtest.driver}")
    private String driver;
    @Value("${dbtest.url}")
    private String url;
    @Value("${dbtest.username}")
    private String username;
    @Value("${dbtest.password}")
    private String password;

    @Value("${dbtest.dialect}")
    private String dialect;
    @Value("${dbtest.showsql}")
    private String show_sql;
    @Value("${dbtest.hbm2ddl_auto}")
    private String hbm2ddl_auto;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        return super.entityManagerFactory(hibernateProp(dialect, show_sql, hbm2ddl_auto), dataSourceProp(driver, url, username, password));
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        return super.transactionManager(hibernateProp(dialect, show_sql, hbm2ddl_auto), dataSourceProp(driver, url, username, password));
    }

    @Bean
    public DataSource dataSource(){
        return super.dataSource(dataSourceProp(driver, url, username, password));
    }
}

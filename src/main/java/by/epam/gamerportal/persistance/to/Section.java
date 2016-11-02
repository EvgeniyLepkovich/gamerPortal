package by.epam.gamerportal.persistance.to;

import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Yayheniy_Lepkovich on 10/31/2016.
 */
@Entity
@Table(name = "section")
public @Data class Section implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "parentId")
    private long parentId;
    @Column(name = "sectionName", nullable = false)
    private String sectionName;
    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "section", fetch = FetchType.EAGER)
    private List<Article> articles;
}

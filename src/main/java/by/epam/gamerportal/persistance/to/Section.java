package by.epam.gamerportal.persistance.to;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
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

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Article> articles;
}

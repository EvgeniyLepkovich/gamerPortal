package by.epam.gamerportal.persistance.to;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Yayheniy_Lepkovich on 10/28/2016.
 */
@Entity
@Table(name = "rule")
public @Data class Rule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nameRule", nullable = false)
    private String nameRule;
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "ruleSet")
    private Set<Role> roleSet;
}

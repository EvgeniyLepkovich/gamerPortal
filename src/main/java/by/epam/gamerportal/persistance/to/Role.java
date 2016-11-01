package by.epam.gamerportal.persistance.to;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Yayheniy_Lepkovich on 10/28/2016.
 */

@Entity
@Table(name = "role")
public @Data class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nameRole", nullable = false)
    private String nameRole;
    @Column(name = "description")
    private String description;
    @ManyToMany
    @JoinTable(name="RoleRule",
            joinColumns=
            @JoinColumn(name="RoleId", referencedColumnName="ID"),
            inverseJoinColumns=
            @JoinColumn(name="RuleId", referencedColumnName="ID")
    )
    private Set<Rule> ruleSet;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private Set<Account> accounts;
}

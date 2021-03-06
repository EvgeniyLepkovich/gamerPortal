package by.epam.gamerportal.persistance.to;

import org.springframework.core.serializer.Serializer;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Yayheniy_Lepkovich on 10/28/2016.
 */

@Entity
@Table(name = "account")
public @Data class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "mail", nullable = false)
    private String mail;
    @OneToOne(optional = false)
    @JoinColumn(name="profileID", unique = true, nullable = true)
    private Profile profile;
    @ManyToMany
    @JoinTable(name="AccountRole",
            joinColumns = @JoinColumn(name="accountId", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name="roleId", referencedColumnName="ID")
    )
    private Set<Role> roles;
    @ManyToMany(mappedBy = "accounts")
    private Set<Article> articles;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Comment> comments;

}

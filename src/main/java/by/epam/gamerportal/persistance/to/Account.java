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
@Table(name = "acount")
public @Data class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "mail", nullable = false)
    private String mail;
    @ManyToMany
    @JoinTable(name="AccountRole",
            joinColumns = @JoinColumn(name="accountId", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name="roleId", referencedColumnName="ID")
    )
    private Set<Role> roles;



}

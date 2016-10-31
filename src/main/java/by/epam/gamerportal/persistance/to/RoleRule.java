package by.epam.gamerportal.persistance.to;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Yayheniy_Lepkovich on 10/31/2016.
 */
@Entity
@Table(name = "RoleRule")
public @Data class RoleRule {
    @Id
    private long roleId;
    @Id
    private long ruleId;
}

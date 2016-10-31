package by.epam.gamerportal.persistance.to;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Yayheniy_Lepkovich on 10/31/2016.
 */
@Entity
@Table(name = "tag")
public @Data class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "value", nullable = false)
    private String value;

    @OneToOne(mappedBy = "tag")
    private Article article;
}

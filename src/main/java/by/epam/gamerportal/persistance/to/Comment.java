package by.epam.gamerportal.persistance.to;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by Yayheniy_Lepkovich on 10/31/2016.
 */
@Entity
@Table(name = "comment")
public @Data class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "parentId")
    private long parentId;
    @Column(name = "commentText", nullable = false)
    private String commentText;

    @ManyToOne
    private Account account;
    @ManyToOne
    private Article article;
}

package by.epam.gamerportal.persistance.to;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yayheniy_Lepkovich on 10/31/2016.
 */

@Entity
@Table(name = "article")
public @Data class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "shortTitle", length = 100, nullable = false)
    private String shortTitle;
    @Column(name = "mainTitle", length = 50, nullable = false)
    private String mainTitle;
    @Column(name = "text", nullable = false)
    private String text;
    @Column(name = "mainPhoto")
    private String mainPhoto;

    @ManyToOne
    private Section section;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "ArticleTag",
            joinColumns = @JoinColumn(name="articleId", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="tagId", referencedColumnName = "id"))
    private Tag tag;
}

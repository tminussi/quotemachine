package br.com.bytecraft.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "author")
    private String author;
}

package com.anna.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString(exclude = {"owner"})
@NoArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student owner;
}


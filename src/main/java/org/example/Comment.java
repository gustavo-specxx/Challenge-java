package org.example;

import javax.persistence.Entity;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
    @NotBlank
    private String text;
    // getters e setters
}

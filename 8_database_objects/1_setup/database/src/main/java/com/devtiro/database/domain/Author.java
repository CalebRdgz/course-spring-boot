package com.devtiro.database.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //creates equals, hashcode, getters and setters
@AllArgsConstructor
@NoArgsConstructor
@Builder //so we can use the builder pattern
@Entity //labels this object as an entity that Spring Data JPA can use
@Table(name = "authors") //map this object as an authors table in the database
public class Author {
    @Id //identify this field as the id in the database:
    //every time an author created, database will create a new id for us incrementing by 1:
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    private Long id; //id of the author. long = defaults to zero, Long = defaults to null

    private String name; //name of the author is a String

    private Integer age; //age of the author. integer = defaults to zero, Integer = defaults to null

}

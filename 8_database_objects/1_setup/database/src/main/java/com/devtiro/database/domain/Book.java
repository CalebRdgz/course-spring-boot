package com.devtiro.database.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {
    //we will provide the isbn every time we create a book
    @Id //identify the unique identifier in the database
    private String isbn;

    private String title;
    //use private Author instead of private Long because of Spring Data JPA:
    //annotations to make it deal with the book and its related author (retrieve a book and its author)
    @ManyToOne(cascade = CascadeType.ALL) //when we get a book, we get to change its author in db
    @JoinColumn(name = "author_id") //author_id is the join column
    private Author author;

}

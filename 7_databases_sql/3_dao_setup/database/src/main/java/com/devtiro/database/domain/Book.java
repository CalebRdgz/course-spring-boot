package com.devtiro.database.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    private String isbn; //isbn of the book is the primary key of the book

    private String title; //title of the book

    private Long authorId; //the author id

}

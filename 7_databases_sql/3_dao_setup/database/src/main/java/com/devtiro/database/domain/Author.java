package com.devtiro.database.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //creates equals, hashcode, getters and setters
@AllArgsConstructor
@NoArgsConstructor
@Builder //so we can use the builder pattern
public class Author {

    private Long id; //id of the author. long = defaults to zero, Long = defaults to null

    private String name; //name of the author is a String

    private Integer age; //age of the author. integer = defaults to zero, Integer = defaults to null

}

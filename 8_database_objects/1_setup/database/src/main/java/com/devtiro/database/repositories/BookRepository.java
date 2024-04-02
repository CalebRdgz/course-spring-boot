package com.devtiro.database.repositories;

import com.devtiro.database.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Book type, and String type of id
public interface BookRepository extends CrudRepository<Book, String> {
}

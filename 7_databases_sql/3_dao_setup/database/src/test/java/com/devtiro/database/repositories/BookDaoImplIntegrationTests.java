//package com.devtiro.database.repositories;
//
//import com.devtiro.database.TestDataUtil;
//import com.devtiro.database.dao.AuthorDao;
//import com.devtiro.database.domain.Author;
//import com.devtiro.database.domain.Book;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class BookDaoImplIntegrationTests {
//    //need access to our AuthorDao interface, framework will determine what implementation well get:
//    private AuthorDao authorDao;
//    //reference to our class underTest
//    private BookDaoImpl underTest;
//    //generate tools to create the constructor for us
//
//    @Autowired
//    public BookDaoImplIntegrationTests(BookDaoImpl underTest, AuthorDao authorDao) {
//        this.underTest = underTest;
//        //add the authorDao interface to the constructor:
//        this.authorDao = authorDao;
//    }
//
//    //create our test
//    @Test
//    public void testThatBookCanBeCreatedAndRecalled() {
//        //create our author:
//        Author author = TestDataUtil.createTestAuthorA();
//        //save this author:
//        authorDao.create(author); //author is now created in the database
//        //need access to that book (extract the book created in BookDaoImplTests):
//        Book book = TestDataUtil.createTestBookA();
//        //before saving the author, set author id to be the author.getId()
//        book.setAuthorId(author.getId());
//        underTest.create(book);
//        Optional<Book> result = underTest.findOne(book.getIsbn()); //result variable, book.getIsbn returns an Optional<Book>
//        //assert that the result(book.getIsbn) is present in the database
//        assertThat(result).isPresent();
//        //returning the book in that optional is equal to the book created above^:
//        assertThat(result.get()).isEqualTo(book);
//    }
//
//    @Test
//    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
//        //we need access to our multiple books:
//        //make all of these books belong to this one author:
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author); //create the author in the database
//        //create our test books:
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthorId(author.getId()); //set the authorId on each of them
//        underTest.create(bookA); //create the bookA in the database
//        Book bookB = TestDataUtil.createTestBookB();
//        bookB.setAuthorId(author.getId()); //set the authorId on each of them
//        underTest.create(bookB); //create the bookB in the database
//        Book bookC = TestDataUtil.createTestBookC();
//        bookC.setAuthorId(author.getId()); //set the authorId on each of them
//        underTest.create(bookC); //create the bookC in the database
//        //we now have three books in the database
//        //return our list of books in the database:
//        List<Book> result = underTest.find();
//        //assert that the result has size 3 books and contains exactly bookA, bookB, and bookC
//        assertThat(result)
//                .hasSize(3)
//                .containsExactly(bookA, bookB, bookC);
//    }
//
//    //Integration Test for book:
//    @Test
//    public void testThatBookCanBeUpdated() {
//        //need an author from up there^
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author); //author created in database
//        //create test book:
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthorId(author.getId()); //set the authorId on each of them
//        underTest.create(bookA); //create the bookA in the database
//
//        //update that book^
//        bookA.setTitle("UPDATED");
//        underTest.update(bookA.getIsbn(), bookA); //pass in the book isbn and the updated book^
//
//        Optional<Book> result = underTest.findOne(bookA.getIsbn());
//        //assert that the book is present:
//        assertThat(result).isPresent();
//        //assert that result book = updated bookA with title "UPDATED"
//        assertThat(result.get()).isEqualTo(bookA);
//    }
//
//    @Test
//    public void testThatBookCanBeDeleted () {
//        //need an author from up there^
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author); //author created in database
//        //create test book:
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthorId(author.getId()); //set the authorId on each of them
//        underTest.create(bookA); //create the bookA in the database
//
//        //delete that book^
//        underTest.delete(bookA.getIsbn()); //this deletes the book from the database
//        //the result from finding the book in the database should be empty since its deleted:
//        Optional<Book> result = underTest.findOne(bookA.getIsbn());
//        //assert that result is empty:
//        assertThat(result).isEmpty();
//    }
//}

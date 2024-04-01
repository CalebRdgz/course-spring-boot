//package com.devtiro.database.repositories;
//
//import com.devtiro.database.TestDataUtil;
//import com.devtiro.database.domain.Author;
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
//@SpringBootTest //starts up a test version of our application when the test runs
//@ExtendWith(SpringExtension.class) //makes sure everything is fully integrated and supported
////DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD = after every test, clean context for next test
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class AuthorDaoImplIntegrationTests {
//    //Tests that our Author is created in the database, then use findOne method we created to retrieve the author when created
//
//    //reference to our class in the test
//    private AuthorDaoImpl underTest;
//    //get a hold of our test using constructor injection:
//    @Autowired //for constructor injection to work in this format (required for single item in test)
//    public AuthorDaoImplIntegrationTests(AuthorDaoImpl underTest) {
//        this.underTest = underTest;
//    }
//    @Test
//    public void testThatAuthorCanBeCreatedAndRecalled() {
//        //using the createTestAuthor as a author variable
//        Author author = TestDataUtil.createTestAuthorA();
//        //write our test:
//        underTest.create(author); //we should create an author in our database
//        Optional<Author> result = underTest.findOne(author.getId()); //passing in the authorId as an Optional Author result
//        //assert that the result is present in the database
//        assertThat(result).isPresent(); //asserThat gives good failure messages if test fails
//        //returning the author in that optional is equal to the author created above^:
//        assertThat(result.get()).isEqualTo(author); //.isEqualTo() uses the equals method in the class, Lombok uses every instance variable
//    }
//
//    //create a test
//    @Test
//    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
//        //we already have access to a single author^
////        Author authorA = TestDataUtil.createTestAuthor();
//        //create three new authors (from TestDataUtil):
//        Author authorA = TestDataUtil.createTestAuthorA();
//        underTest.create(authorA); // create these authors in the database
//        Author authorB = TestDataUtil.createTestAuthorB();
//        underTest.create(authorB); // create these authors in the database
//        Author authorC = TestDataUtil.createTestAuthorC();
//        underTest.create(authorC); // create these authors in the database
//
//        //get our result (list of authors):
//        List<Author> result = underTest.find();
//        //instead of two asserts, chain two asserts:
//        assertThat(result)
//                .hasSize(3) //assert that the result list has three authors
//                .containsExactly(authorA, authorB, authorC); //assert that has exactly these authors
//
//    }
//
//    @Test
//    public void testThatAuthorCanBeUpdated() {
//        //start with creating an author:
//        Author authorA = TestDataUtil.createTestAuthorA();
//        underTest.create(authorA); // create this author in the database
//        //update the authorA in the database:
//        authorA.setName("UPDATED");
//        underTest.update(authorA.getId(), authorA);
//        Optional<Author> result = underTest.findOne(authorA.getId());
//        //assert:
//        assertThat(result).isPresent(); //asserting that the Author is present in the database
//        assertThat(result.get()).isEqualTo(authorA); //asserting that author in the database = author^
//    }
//
//    @Test
//    public void testThatAuthorCanBeDeleted() {
//        //start with creating an author in the database:
//        Author authorA = TestDataUtil.createTestAuthorA();
//        underTest.create(authorA); // create this authorA in the database
//        underTest.delete(authorA.getId()); //delete the authorA with getId()
//        //put the author we deleted in the result optional:
//        Optional<Author> result = underTest.findOne(authorA.getId());
//        //assert that this author is empty in the database:
//        assertThat(result).isEmpty();
//
//    }
//}

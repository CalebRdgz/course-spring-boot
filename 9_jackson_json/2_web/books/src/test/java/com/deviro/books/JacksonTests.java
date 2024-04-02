package com.deviro.books;

import com.deviro.books.domain.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class JacksonTests {
    @Test
    public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException {
        //jackson object mapper:
        ObjectMapper objectMapper = new ObjectMapper();
        //create a new test book that is now available:
        Book book = Book.builder()
                .isbn("978-0-13-478627-5")
                .title("The Enigma of Eternity")
                .author("Aria Montogomery")
                .yearPublished("2005")
                .build();

        //convert this book^ into JSON in result variable:
        //if .writeValueAsString() (convert to JSON) doesn't work, will throw JsonProcessingException:
        String result = objectMapper.writeValueAsString(book);
        // .isEqualTo a string that IS equal:
        assertThat(result).isEqualTo("{\"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria Montogomery\",\"year\":\"2005\"}");
    }

    @Test
    public void testThatObjectMapperCanCreateJavaObjectFromJsonObject() throws JsonProcessingException {
        //create a new test book that is now available:
        Book book = Book.builder()
                .isbn("978-0-13-478627-5")
                .title("The Enigma of Eternity")
                .author("Aria Montogomery")
                .yearPublished("2005")
                .build();

        //create a json object that represents a book:
        //add foo: bar to our json object:
        String json = "{\"foo\":\"bar\", \"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria Montogomery\",\"year\":\"2005\"}";

        //create an object mapper:
        final ObjectMapper objectMapper = new ObjectMapper();

        //create a book (add JsonProcessingException in case error):
        Book result = objectMapper.readValue(json, Book.class);
        assertThat(result).isEqualTo(book);

    }
}

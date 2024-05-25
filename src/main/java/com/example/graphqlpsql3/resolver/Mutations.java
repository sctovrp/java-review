package com.example.graphqlpsql3.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.graphqlpsql3.model.Author;
import com.example.graphqlpsql3.model.Book;
import com.example.graphqlpsql3.repository.AuthorRepository;
import com.example.graphqlpsql3.repository.BookRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;
import jakarta.persistence.EntityNotFoundException;

@Component
public class Mutations implements GraphQLMutationResolver{
    
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;


    public Author createAuthor(String name, Integer Age){
        Author author = new Author();
        author.setName(name);
        author.setAge(Age);

        authorRepository.save(author);

        return author;
    }

    public Book createBook(String title, String description, Integer authorId){
        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        book.setAuthor(new Author(authorId));

        bookRepository.save(book);

        return book;
    }

    public Book updateBook(Integer id, String title, String description) throws EntityNotFoundException {
        Optional<Book> optBook = bookRepository.findById(id);

        if (optBook.isPresent()) {
            Book book = optBook.get();
            if (title != null) {
                book.setTitle(title);
            }

            if (description != null) {
                book.setDescription(description);
            }

            bookRepository.save(book);

            return book;
        }
        throw new EntityNotFoundException("Not Found Book to update");   
    }
    
    public Boolean deleteBook(Integer id){
        bookRepository.deleteById(id);
        return true;
    }
}

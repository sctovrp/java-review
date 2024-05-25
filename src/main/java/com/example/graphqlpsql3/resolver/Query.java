package com.example.graphqlpsql3.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.graphqlpsql3.model.Author;
import com.example.graphqlpsql3.model.Book;
import com.example.graphqlpsql3.repository.AuthorRepository;
import com.example.graphqlpsql3.repository.BookRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Iterable<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Iterable<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Integer countAuthors(){
        return (int) authorRepository.count();
    }

    public Integer countBooks(){
        return (int) bookRepository.count();
    }
}

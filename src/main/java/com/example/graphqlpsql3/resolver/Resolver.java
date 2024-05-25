package com.example.graphqlpsql3.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.graphqlpsql3.model.Author;
import com.example.graphqlpsql3.model.Book;
import com.example.graphqlpsql3.repository.AuthorRepository;

import graphql.kickstart.tools.GraphQLResolver;

@Component
public class Resolver implements GraphQLResolver<Book> {
    @Autowired
    private AuthorRepository authorRepository;

    public Author getAuthor(Book book){
        return authorRepository.findById(book.getAuthor().getId()).orElseThrow(null);
    }
}

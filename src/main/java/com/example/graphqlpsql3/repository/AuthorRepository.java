package com.example.graphqlpsql3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.graphqlpsql3.model.Author;

@Component
public interface AuthorRepository extends JpaRepository<Author, Integer>{
    
}

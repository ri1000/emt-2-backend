package com.emt.lab2.repository;

import com.emt.lab2.model.Author;
import com.emt.lab2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}

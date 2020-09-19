package com.example.h2functiontest.repository;

import com.example.h2functiontest.entity.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FooRepository extends JpaRepository<Foo, Integer> {
    @Query(value = "select * from theschema.foo " +
            "where name ilike ?1% ORDER BY similarity(name, ?1) asc LIMIT ?2", nativeQuery = true)
    List<Foo> searchName(String keyword, Integer resultLimit);

}

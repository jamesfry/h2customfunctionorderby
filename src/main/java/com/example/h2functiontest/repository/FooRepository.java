package com.example.h2functiontest.repository;

import com.example.h2functiontest.entity.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FooRepository extends JpaRepository<Foo, Integer> {

    @Query(value = "SELECT * from theschema.search_name(:name, :limit)", nativeQuery = true)
    List<Foo> searchName(@Param("name") String name, @Param("limit") Integer limit);

}

// Limitations on function use https://jira.spring.io/browse/DATAJPA-1092

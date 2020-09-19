package com.example.h2functiontest;

import com.example.h2functiontest.entity.Foo;
import com.example.h2functiontest.repository.FooRepository;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class H2functiontestApplicationTests {

	@Autowired
	private FooRepository fooRepository;

	@BeforeEach
	void setup() {
		Foo foo1 = new Foo("Foo1", 1);
		fooRepository.save(foo1);

		Foo foo2 = new Foo("Foo2", 2);
		fooRepository.save(foo2);
	}

	@Test
	void testFindLocationByKeyword() {
		String keyword = "Foo";
		List<Foo> results = fooRepository.searchName("Foo", 20);
		assertThat(results.size()).isEqualTo(2);
	}

}

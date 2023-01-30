package com.example.java7homeworksdata41.repository;

import com.example.java7homeworksdata41.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(value = "select p from Person p where p.city= :city order by p.surname")
    List<Person> findAllByCityOrderBySurname(@Param("city") String city);

    @Query(value = "select p from Person p where p.age < :age order by p.age")
    List<Person> findByAgeLessThanOrderByAge(@Min(0) @Param("age") int age);

    @Query(value = "select p from Person p where p.name=:name and p.surname=:surname")
    Optional<Person> findByNameAndSurname(@Param("name") String name,
                                          @Param("surname") String surname);
}
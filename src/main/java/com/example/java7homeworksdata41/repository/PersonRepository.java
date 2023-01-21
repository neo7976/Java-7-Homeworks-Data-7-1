package com.example.java7homeworksdata41.repository;

import com.example.java7homeworksdata41.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        var resultCity = entityManager.createQuery(
                "select c from Person c where c.city = :cityName order by c.surname")
                .setParameter("cityName", city);
        return resultCity.getResultList();
    }
}

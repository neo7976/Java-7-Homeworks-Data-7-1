package com.example.java7homeworksdata41.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PERSONS")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String surname;

    @Min(0)
    @Column()
    private int age;

    @Column(length = 10, nullable = false, name = "phone_number")
    private String phoneNumber;


    @Column(nullable = false, name = "city_of_living", length = 30)
//    @OneToMany
    private String city;
}

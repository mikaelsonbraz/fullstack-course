package com.mikaelsonbraz.serviceOrder.repository;

import com.mikaelsonbraz.serviceOrder.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    boolean existsByCpf(String cpf);

    Person findByCpf(String cpf);
}

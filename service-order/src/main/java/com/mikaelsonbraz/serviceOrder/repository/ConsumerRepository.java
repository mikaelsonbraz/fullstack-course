package com.mikaelsonbraz.serviceOrder.repository;

import com.mikaelsonbraz.serviceOrder.domain.person.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
}

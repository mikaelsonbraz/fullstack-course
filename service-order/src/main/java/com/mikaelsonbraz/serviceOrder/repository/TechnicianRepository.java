package com.mikaelsonbraz.serviceOrder.repository;

import com.mikaelsonbraz.serviceOrder.domain.person.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Integer> {
    boolean existsByCpf(String cpf);

    Technician findByCpf(String cpf);
}

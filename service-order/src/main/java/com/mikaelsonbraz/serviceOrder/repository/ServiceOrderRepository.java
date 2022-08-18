package com.mikaelsonbraz.serviceOrder.repository;

import com.mikaelsonbraz.serviceOrder.domain.serviceOrder.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer> {
}

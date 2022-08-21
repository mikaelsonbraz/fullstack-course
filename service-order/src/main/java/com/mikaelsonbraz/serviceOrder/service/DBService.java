package com.mikaelsonbraz.serviceOrder.service;

import com.mikaelsonbraz.serviceOrder.domain.person.Consumer;
import com.mikaelsonbraz.serviceOrder.domain.person.Technician;
import com.mikaelsonbraz.serviceOrder.domain.serviceOrder.ServiceOrder;
import com.mikaelsonbraz.serviceOrder.domain.serviceOrder.enums.PriorityLevel;
import com.mikaelsonbraz.serviceOrder.domain.serviceOrder.enums.Status;
import com.mikaelsonbraz.serviceOrder.repository.ConsumerRepository;
import com.mikaelsonbraz.serviceOrder.repository.ServiceOrderRepository;
import com.mikaelsonbraz.serviceOrder.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TechnicianRepository technicianRepository;
    @Autowired
    private ConsumerRepository consumerRepository;
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public void DBseeding(){

        Technician technician = new Technician(null, "João Técnico", "703.929.380-30", "(83) 99988-7766");
        Technician technician2 = new Technician(null, "Josefa Técnia", "350.339.860-07", "(83) 97766-5544");
        Consumer consumer = new Consumer(null, "José Consumidor", "956.741.720-21", "(84) 98877-6655");
        Consumer consumer2 = new Consumer(null, "Joana Consumidora", "071.469.380-42", "(84) 91122-3344");
        ServiceOrder serviceOrder = new ServiceOrder(null, PriorityLevel.LOW, null, Status.TO_DO, technician, consumer);
        ServiceOrder serviceOrder2 = new ServiceOrder(null, PriorityLevel.HIGH, null, Status.IN_PROGRESS, technician2, consumer2);

        technician.getServiceOrderList().add(serviceOrder);
        consumer.getRequestOrderServiceList().add(serviceOrder);

        technicianRepository.saveAll(Arrays.asList(technician, technician2));
        consumerRepository.saveAll(Arrays.asList(consumer, consumer2));
        serviceOrderRepository.saveAll(Arrays.asList(serviceOrder, serviceOrder2));

    }
}

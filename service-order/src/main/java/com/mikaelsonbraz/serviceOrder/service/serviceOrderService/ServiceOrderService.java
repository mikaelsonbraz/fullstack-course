package com.mikaelsonbraz.serviceOrder.service.serviceOrderService;

import com.mikaelsonbraz.serviceOrder.domain.person.Consumer;
import com.mikaelsonbraz.serviceOrder.domain.person.Technician;
import com.mikaelsonbraz.serviceOrder.domain.serviceOrder.ServiceOrder;
import com.mikaelsonbraz.serviceOrder.domain.serviceOrder.enums.PriorityLevel;
import com.mikaelsonbraz.serviceOrder.domain.serviceOrder.enums.Status;
import com.mikaelsonbraz.serviceOrder.dto.serviceOrder.ServiceOrderDTO;
import com.mikaelsonbraz.serviceOrder.repository.ServiceOrderRepository;
import com.mikaelsonbraz.serviceOrder.service.exception.ObjectNotFoundException;
import com.mikaelsonbraz.serviceOrder.service.personService.ConsumerService;
import com.mikaelsonbraz.serviceOrder.service.personService.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private TechnicianService technicianService;
    @Autowired
    private ConsumerService consumerService;

    public ServiceOrder findById(Integer id){
        Optional<ServiceOrder> serviceOrder = serviceOrderRepository.findById(id);
        return serviceOrder.orElseThrow(() -> new ObjectNotFoundException(
                                                    "Service Order not found! " + id + ", Type: " + ServiceOrder.class.getName()));
    }

    public List<ServiceOrder> getAll(){
        return serviceOrderRepository.findAll();
    }

    public ServiceOrder create(ServiceOrderDTO serviceOrderDTO){
        Technician technician = technicianService.findById(serviceOrderDTO.getTechnician());
        Consumer consumer = consumerService.findById(serviceOrderDTO.getConsumer());

        ServiceOrder serviceOrder = new ServiceOrder(null,
                PriorityLevel.toEnum(serviceOrderDTO.getPriorityLevel()),
                serviceOrderDTO.getComments(),
                Status.toEnum(serviceOrderDTO.getStatus()),
                technician,
                consumer);

        return serviceOrderRepository.save(serviceOrder);
    }
}

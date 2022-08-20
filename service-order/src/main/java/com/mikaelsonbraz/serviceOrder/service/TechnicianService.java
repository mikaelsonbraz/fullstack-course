package com.mikaelsonbraz.serviceOrder.service;

import com.mikaelsonbraz.serviceOrder.domain.person.Technician;
import com.mikaelsonbraz.serviceOrder.repository.TechnicianRepository;
import com.mikaelsonbraz.serviceOrder.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnicianService {

    @Autowired
    TechnicianRepository technicianRepository;

    public Technician findById(Integer id){
        Optional<Technician> technician = technicianRepository.findById(id);
        return technician.orElseThrow(() -> new ObjectNotFoundException(
                                                "Technician not found! Id: " + id + ", Type: " + Technician.class.getName()));
    }
}

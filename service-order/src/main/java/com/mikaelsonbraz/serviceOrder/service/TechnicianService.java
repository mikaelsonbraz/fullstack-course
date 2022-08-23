package com.mikaelsonbraz.serviceOrder.service;

import com.mikaelsonbraz.serviceOrder.domain.person.Technician;
import com.mikaelsonbraz.serviceOrder.dto.person.TechnicianDTO;
import com.mikaelsonbraz.serviceOrder.repository.TechnicianRepository;
import com.mikaelsonbraz.serviceOrder.service.exception.DuplicatedCpfExcecption;
import com.mikaelsonbraz.serviceOrder.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public List<Technician> getAll(){
        return technicianRepository.findAll();
    }

    public Technician create(TechnicianDTO technicianDTO){
        if(duplicatedCPF(technicianDTO)){
            throw new DuplicatedCpfExcecption("Duplicated CPF! " + technicianDTO.getCpf());
        }
        return technicianRepository.save(new Technician(null, technicianDTO.getName(), technicianDTO.getCpf(), technicianDTO.getPhone()));
    }

    public Technician update(Integer id, TechnicianDTO technicianDTO){
        Technician technicianToUpdate = findById(id);

        if(duplicatedCPF(technicianDTO) && !Objects.equals(findByCpf(technicianDTO).getId(), id)){
            throw new DuplicatedCpfExcecption("Duplicated CPF! " + technicianDTO.getCpf());
        }

        technicianToUpdate.setName(technicianDTO.getName());
        technicianToUpdate.setCpf(technicianDTO.getCpf());
        technicianToUpdate.setPhone(technicianDTO.getPhone());

        return technicianRepository.save(technicianToUpdate);
    }

    public void delete(Integer id){
        Technician technician = findById(id);
        if (technician.getServiceOrderList().size() > 0){
            throw new DataIntegrityViolationException("The id " + id + " technician has service orders, delete method unavailable");
        }
        technicianRepository.delete(technician);
    }

    private boolean duplicatedCPF(TechnicianDTO technicianDTO){
        return technicianRepository.existsByCpf(technicianDTO.getCpf());
    }

    private Technician findByCpf(TechnicianDTO technicianDTO){

        return technicianRepository.findByCpf(technicianDTO.getCpf());
    }
}
